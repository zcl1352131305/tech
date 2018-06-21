package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.mapper.data.DataFileMapper;
import cn.com.softvan.mapper.tech.CourseMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseWorkService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class CourseWorkServiceImpl extends AbstractService<CourseWork> implements CourseWorkService {

    @Autowired
    private DataFileMapper dataFileMapper;

    @Override
    public String getTemplatePath() {
        return "tech/courseWork";
    }

    public List<CourseWork> findList(Integer courseId){
        Condition condition = new Condition(Course.class);
        condition.createCriteria().andCondition("course_id = '" + courseId+ "'");
        List<CourseWork> list = findByCondition(condition);
        for(CourseWork courseWork:list){
            DataFile file = dataFileMapper.selectByPrimaryKey(courseWork.getFileId());
            if(null != file){
                courseWork.setFile(file);
            }
        }
        return list;
    }

}
