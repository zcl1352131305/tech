package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.data.DataFile;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "t_course_video_student")
@Data
public class CourseVideoStudent extends BaseEntity {

    @Column(name = "video_id")
    private Integer videoId;

    @Column(name = "student_id")
    private Integer studentId;

    private Integer progress;

    @Column(name = "latest_watched")
    private Integer latestWatched;

}
