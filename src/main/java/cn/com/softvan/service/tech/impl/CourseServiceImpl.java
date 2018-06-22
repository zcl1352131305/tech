package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.tech.CourseMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.vo.system.SystemUserVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Condition;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {

    @Autowired
    private CourseStudentMapper courseStudentMapper;

    @Autowired
    private CourseWorkService courseWorkService;

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public String getTemplatePath() {
        return "tech/course";
    }

    @Override
    public void save(Course model) {
        model.setCreateDate(new Date());
        model.setUpdateDate(new Date());
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        model.setTeacherId(user.getId());
        mapper.insertSelective(model);

    }

    public List<Course> findList(HttpServletRequest request){
        Condition condition = new Condition(Course.class);
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        condition.createCriteria().andCondition("teacher_id = '" + user.getId()+ "'");
        List<Course> list = findByCondition(condition);
        for(Course course:list){
            course.setWorkCount(courseWorkService.findList(course.getId()).size());
            course.setStudentCount(findCourseStudent(course.getId()).size());
        }
        return list;
    }


    public List<SystemUser> findCourseStudent(Integer courseId){
        return courseStudentMapper.selectCourseStudent(courseId);
    }

    public void deleteCourseStudent(Integer courseId){
        courseStudentMapper.deleteByCourseId(courseId);
    }

    public void saveCourseStudent(CourseStudent courseStudent){
        courseStudentMapper.insertSelective(courseStudent);
    }

    @Override
    public List<Course> findStudentCourses(Integer studentId) {
        List<Course> courses = courseMapper.selectStudentCourses(studentId);
        for(Course course:courses){
            course.setWorkCount(courseWorkService.findStudentWorkList(course.getId()).size());
            course.setStudentCount(findCourseStudent(course.getId()).size());
        }
        return courses;
    }
}
