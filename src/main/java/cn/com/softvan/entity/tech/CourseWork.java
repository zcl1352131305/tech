package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.data.DataFile;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_course_work")
@Data
public class CourseWork extends BaseEntity {

    @Column(name = "course_id")
    private Integer courseId;

    private String name;

    private String score;

    @Column(name = "file_id")
    private String fileId;

    @Column(name = "date_limit")
    private String dateLimit;

    @Transient
    private DataFile file;
}
