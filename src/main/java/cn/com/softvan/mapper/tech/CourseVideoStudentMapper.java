package cn.com.softvan.mapper.tech;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.tech.CourseVideoStudent;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import org.springframework.stereotype.Component;


/**
 * 信息详情dao
 */
@Component
public interface CourseVideoStudentMapper extends Mapper<CourseVideoStudent> {
    CourseVideoStudent selectStudentWatched(CourseVideoStudent entity);
}