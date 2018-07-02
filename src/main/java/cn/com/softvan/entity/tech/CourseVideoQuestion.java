package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.data.DataFile;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_course_video_question")
@Data
public class CourseVideoQuestion extends BaseEntity {

    @Column(name = "video_id")
    private Integer videoId;

    private String question;

    private String answer;

    @Column(name = "alert_time")
    private Integer alertTime;

}
