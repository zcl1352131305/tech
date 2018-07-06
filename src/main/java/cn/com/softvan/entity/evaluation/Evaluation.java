package cn.com.softvan.entity.evaluation;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.system.SystemUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_evaluation")
@Data
public class Evaluation extends BaseEntity {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "teacher_id")
    private Integer teacherId;

    private String content;


    private String score;

}
