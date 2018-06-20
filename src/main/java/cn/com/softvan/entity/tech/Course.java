package cn.com.softvan.entity.tech;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String code;
    private String score;

    private String grade;

    private String clazz;

    private String profession;


    /**
     * 创建时间
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 更新时间
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记(1.删除，0未删除)
     */
    @Column(name = "del_flag")
    private String delFlag;

}
