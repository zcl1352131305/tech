package cn.com.softvan.service.tech;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.*;

import java.util.List;

/**
 * Created by madman on 2017/12/05.
 */
public interface CourseVideoService extends Service<CourseVideo> {

    List<CourseVideo> findList(Integer courseId);

    List<SystemUser> findVideoStudentsWatched(Integer videoId);

    List<CourseVideo> findStudentVideoList(Integer courseId);

    List<CourseVideoQuestion> getVideoQuestions(Integer videoId);

    void saveVideoQuestions(Integer videoId, List<CourseVideoQuestion> questions);

    CourseVideoStudent getStudentWatched(Integer videoId);

    void updateStudentWatchedProgress(Integer videoId, Integer progress, Integer latestWatched);
}
