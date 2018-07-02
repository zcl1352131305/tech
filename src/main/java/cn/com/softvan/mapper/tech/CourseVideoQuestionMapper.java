package cn.com.softvan.mapper.tech;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.tech.CourseVideo;
import cn.com.softvan.entity.tech.CourseVideoQuestion;
import org.springframework.stereotype.Component;


/**
 * 信息详情dao
 */
@Component
public interface CourseVideoQuestionMapper extends Mapper<CourseVideoQuestion> {

    void deleteByVideoId(Integer videoId);
}