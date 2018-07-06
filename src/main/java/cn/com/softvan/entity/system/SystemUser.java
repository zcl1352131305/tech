package cn.com.softvan.entity.system;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.tech.CourseVideoStudent;
import cn.com.softvan.entity.tech.CourseWorkStudent;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_system_user")
@Data
public class SystemUser extends BaseEntity{

    private String workid;
    private String grade;

    private String clazz;

    private String profession;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 登录名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    private String password;


    /**
     * 锁定
     */
    private Boolean locked;

    /**
     * 人员联系电话
     */
    private String phone;

    /**
     * 人员邮箱
     */
    private String mail;

    /**
     * 性别（M 男， F 女）
     */
    private String sex;


    /**
     * 职称
     */
    @Column(name = "job_title")
    private String jobTitle;




    @Transient
    List<Integer> roles;


    @Transient
    private CourseWorkStudent studentSubmitWork = new CourseWorkStudent();

    @Transient
    private CourseVideoStudent studentVideoWatched = new CourseVideoStudent();


    @Transient
    private Integer sendMessageNumsToMe = 0;

    public void addSendMessageNumsToMe(){
        sendMessageNumsToMe++;
    }

}