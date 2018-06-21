package cn.com.softvan.service.tech;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.vo.system.SystemUserVO;

import java.util.List;

/**
 * Created by madman on 2017/12/05.
 */
public interface CourseService extends Service<Course> {
    List<SystemUser> findCourseStudent(Integer courseId);
    void deleteCourseStudent(Integer courseId);
    void saveCourseStudent(CourseStudent courseStudent);

    List<Course> findStudentCourses(Integer studentId);
}
