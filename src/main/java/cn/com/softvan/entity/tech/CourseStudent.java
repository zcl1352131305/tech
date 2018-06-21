package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_course_student")
@Data
public class CourseStudent extends BaseEntity {

    @Column(name = "course_id")
    private Integer courseId;

    @Column(name = "student_id")
    private Integer studentId;


}