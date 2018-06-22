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

    private String state;

    private String score;

    @Column(name = "file_id")
    private Integer fileId;

    @Column(name = "date_limit")
    private String dateLimit;

    @Transient
    private DataFile file = new DataFile();


    //教师登陆时查看
    @Transient
    //提交作业的数量
    private Integer submitCount = 0;


    //学生登陆时查看
    @Transient
    //学生完成作业情况
    private CourseWorkStudent studentWork = new CourseWorkStudent();
    @Transient
    //作业是否截止
    private boolean isWorkClose;
}
