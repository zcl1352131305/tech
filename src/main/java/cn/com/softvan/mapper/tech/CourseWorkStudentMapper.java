package cn.com.softvan.mapper.tech;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import org.springframework.stereotype.Component;


/**
 * 信息详情dao
 */
@Component
public interface CourseWorkStudentMapper extends Mapper<CourseWorkStudent> {
    CourseWorkStudent selectStudentWork(CourseWorkStudent entity);
}