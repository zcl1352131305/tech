package cn.com.softvan.vo.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_system_user")
@Data
public class SystemUserVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
     * 盐
     */
    private String salt;

    /**
     * 锁定
     */
    private Boolean locked;

    /**
     * 人员联系电话
     */
    private String phone;

    /**
     * 所属企业
     */
    private String enterprise;

    /**
     * 人员邮箱
     */
    private String mail;

    /**
     * 籍贯
     */
    private String origin;

    /**
     * 性别（M 男， F 女）
     */
    private String sex;

    /**
     * 职位
     */
    private String job;

    /**
     * 学历
     */
    private String education;

    /**
     * 职称
     */
    @Column(name = "job_title")
    private String jobTitle;

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


    private List<String> roles;

}