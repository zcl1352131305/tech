package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_course")
@Data
public class Course  extends BaseEntity {

    @Column(name = "teacher_id")
    private Integer teacherId;

    private String name;

    private String code;
    private String score;

    private String grade;

    private String clazz;

    private String profession;


    @Transient
    private String teacherName;


}
