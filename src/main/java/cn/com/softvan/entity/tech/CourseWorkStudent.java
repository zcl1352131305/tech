package cn.com.softvan.entity.tech;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Table(name = "t_course_work_student")
@Data
public class CourseWorkStudent extends BaseEntity {

    @Column(name = "work_id")
    private Integer workId;

    @Column(name = "student_id")
    private Integer studentId;

    @Column(name = "submit_file_id")
    private Integer submitFileId;

    @Column(name = "checked_file_id")
    private Integer checkedFileId;

    @Column(name = "date_submit")
    private Date dateSubmit;

    @Column(name = "date_checked")
    private Date dateChecked;

    private String score;


    @Transient
    private DataFile submitFile = new DataFile();
    @Transient
    private DataFile checkedFile = new DataFile();

}
