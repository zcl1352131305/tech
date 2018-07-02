package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.data.DataFile;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Table(name = "t_course_video")
@Data
public class CourseVideo extends BaseEntity {

    @Column(name = "course_id")
    private Integer courseId;

    private String name;



    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "head_img_file_id")
    private Integer headImgFileId;

    @Transient
    private DataFile videoFile = new DataFile();

    @Transient
    private DataFile headImgFile = new DataFile();

    @Transient
    private List<CourseVideoQuestion> questions;

}
