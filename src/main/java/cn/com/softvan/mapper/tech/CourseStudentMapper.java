package cn.com.softvan.mapper.tech;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.system.SystemUserRole;
import cn.com.softvan.entity.tech.CourseStudent;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 信息详情dao
 */
@Component
public interface CourseStudentMapper extends Mapper<CourseStudent> {

    void deleteByCourseId(Integer courseId);

    List<SystemUser> selectCourseStudent(Integer courseId);
}