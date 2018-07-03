package cn.com.softvan.service.tech.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import cn.com.softvan.mapper.data.DataFileMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.mapper.tech.CourseWorkMapper;
import cn.com.softvan.mapper.tech.CourseWorkStudentMapper;
import cn.com.softvan.service.tech.CourseWorkService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class CourseWorkServiceImpl extends AbstractService<CourseWork> implements CourseWorkService {

    @Autowired
    private DataFileMapper dataFileMapper;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Autowired
    private CourseWorkMapper courseWorkMapper;

    @Autowired
    private CourseStudentMapper courseStudentMapper;

    @Autowired
    private CourseWorkStudentMapper courseWorkStudentMapper;

    @Override
    public String getTemplatePath() {
        return "tech/courseWork";
    }

    /**
     * 查询作业列表（教师查看）
     * @param courseId
     * @return
     */
    public List<CourseWork> findList(Integer courseId){
        Condition condition = new Condition(Course.class);
        condition.createCriteria().andCondition("course_id = '" + courseId+ "'");
        List<CourseWork> list = findByCondition(condition);
        for(CourseWork courseWork:list){
            DataFile file = dataFileMapper.selectByPrimaryKey(courseWork.getFileId());
            if(null != file){
                courseWork.setFile(file);
            }
            courseWork.setSubmitCount(getWorkSubmitStudents(courseWork.getId()).size());
        }
        if(null == list) list = new ArrayList<>();
        return list;
    }

    private List<CourseWorkStudent> getWorkSubmitStudents(Integer workId){
        Condition swCondition = new Condition(CourseWorkStudent.class);
        swCondition.createCriteria().andCondition("work_id = '" + workId+ "'");
        List<CourseWorkStudent> studentSubmitWorks = courseWorkStudentMapper.selectByCondition(swCondition);
        if(null == studentSubmitWorks) studentSubmitWorks = new ArrayList<>();
        return studentSubmitWorks;
    }

    /**
     * 获取该作业的学生提交情况（教师）
     * @param workId
     * @return
     */
    public List<SystemUser> getWorkSubmitStudentsDetailList(Integer workId){

        CourseWork courseWork = courseWorkMapper.selectByPrimaryKey(workId);

        List<CourseWorkStudent> studentSubmitWorks = getWorkSubmitStudents(workId);
        for(CourseWorkStudent courseWorkStudent:studentSubmitWorks){
            getStudentWorkFiles(courseWorkStudent);
        }

        List<SystemUser> courseUsers = courseStudentMapper.selectCourseStudent(courseWork.getCourseId());

        for(SystemUser student:courseUsers){
            for(CourseWorkStudent studentSubmitWork:studentSubmitWorks){
                if(student.getId() == studentSubmitWork.getStudentId()){
                    student.setStudentSubmitWork(studentSubmitWork);
                }
            }
        }

        return courseUsers;
    }

    /**
     * 获取学生提交的和老师批改的作业文件
     * @param studentWork
     * @return
     */
    private CourseWorkStudent getStudentWorkFiles(CourseWorkStudent studentWork){
        if(null != studentWork){
            if(null != studentWork.getSubmitFileId()){
                DataFile submitFile = dataFileMapper.selectByPrimaryKey(studentWork.getSubmitFileId());
                if(null != submitFile){
                    studentWork.setSubmitFile(submitFile);
                }
                else{
                    studentWork.setSubmitFile(new DataFile());
                }
            }
            if(null != studentWork.getCheckedFileId()){
                DataFile checkedFile = dataFileMapper.selectByPrimaryKey(studentWork.getCheckedFileId());
                if(null != checkedFile){
                    studentWork.setCheckedFile(checkedFile);
                }
                else{
                    studentWork.setCheckedFile(new DataFile());
                }
            }
        }
        return studentWork;
    }



    public CourseWorkStudent getCourseWorkStudentById(Integer id){
        return courseWorkStudentMapper.selectByPrimaryKey(id);
    }

    public void updateCourseWorkStudent(CourseWorkStudent courseWorkStudent){
        courseWorkStudentMapper.updateByPrimaryKeySelective(courseWorkStudent);
    }

    /**
     * 查询作业列表（学生查看）
     * @param courseId
     * @return
     */
    public List<CourseWork> findStudentWorkList(Integer courseId){
        Condition condition = new Condition(Course.class);
        condition.createCriteria().andCondition("course_id = '" + courseId+ "'").andCondition("state = '1'");
        SystemUser student = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        List<CourseWork> list = findByCondition(condition);
        for(CourseWork courseWork:list){
            DataFile file = dataFileMapper.selectByPrimaryKey(courseWork.getFileId());
            if(null != file){
                courseWork.setFile(file);
            }

            //作业是否超过截止日期
            Date dateLimit = null;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                dateLimit = dateFormat.parse(courseWork.getDateLimit().substring(0,courseWork.getDateLimit().length()-2));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(new Date().before(dateLimit)){
                courseWork.setWorkClose(false);
            }
            else{
                courseWork.setWorkClose(true);
            }

            //学生完成该作业情况
            CourseWorkStudent studentWork = new CourseWorkStudent();
            studentWork.setWorkId(courseWork.getId());
            studentWork.setStudentId(student.getId());
            studentWork = courseWorkStudentMapper.selectStudentWork(studentWork);
            if(null != studentWork){
                getStudentWorkFiles(studentWork);
                courseWork.setStudentWork(studentWork);
            }



        }
        return list;
    }


    /**
     * 获取学生完成的作业
     * @param workId
     * @return
     */
    public CourseWorkStudent getStudentWork(Integer workId){
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        CourseWorkStudent studentWork = new CourseWorkStudent();
        studentWork.setWorkId(workId);
        studentWork.setStudentId(user.getId());
        studentWork = courseWorkStudentMapper.selectStudentWork(studentWork);
        return studentWork;
    }


    /**
     * 学生提交作业
     * @param workId
     * @param fileId
     */
    public void submitWork(Integer workId,Integer fileId){
        SystemUser user = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        CourseWorkStudent studentWork = getStudentWork(workId);
        if(null != studentWork){
            if(null != fileId){
                studentWork.setSubmitFileId(fileId);
            }
            studentWork.setDateSubmit(new Date());
            courseWorkStudentMapper.updateByPrimaryKeySelective(studentWork);
        }
        else{
            studentWork = new CourseWorkStudent();
            studentWork.setStudentId(user.getId());
            if(null != fileId){
                studentWork.setSubmitFileId(fileId);
            }
            studentWork.setDateSubmit(new Date());
            studentWork.setWorkId(workId);
            courseWorkStudentMapper.insertSelective(studentWork);
        }

        if(null != fileId){
            DataFile file = dataFileMapper.selectByPrimaryKey(fileId);
            file.setInfoId(studentWork.getId()+"");
            dataFileMapper.updateByPrimaryKeySelective(file);
        }

    }

}
