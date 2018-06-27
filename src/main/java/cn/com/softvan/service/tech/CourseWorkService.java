package cn.com.softvan.service.tech;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;

import java.util.List;

/**
 * Created by madman on 2017/12/05.
 */
public interface CourseWorkService extends Service<CourseWork> {

    /**
     * 教师查看作业列表
     * @param courseId
     * @return
     */
    List<CourseWork> findList(Integer courseId);

    /**
     * 获取学生作业提交情况
     * @param workId
     * @return
     */
    List<SystemUser> getWorkSubmitStudentsDetailList(Integer workId);

    /**
     * 获取学生完成作业情况
     * @param id
     * @return
     */
    CourseWorkStudent getCourseWorkStudentById(Integer id);

    void updateCourseWorkStudent(CourseWorkStudent courseWorkStudent);
    /**
     * 学生查看作业列表
     * @param courseId
     * @return
     */
    List<CourseWork> findStudentWorkList(Integer courseId);

    /**
     * 学生提交作业
     * @param workId
     * @param fileId
     */
    void submitWork(Integer workId,Integer fileId);

    /**
     * 获取学生提交的作业
     * @param workId
     * @return
     */
    CourseWorkStudent getStudentWork(Integer workId);
}
