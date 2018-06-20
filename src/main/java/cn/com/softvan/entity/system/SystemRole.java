package cn.com.softvan.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_system_role")
@Data
public class SystemRole {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 角色名
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 角色类型
     */
    @Column(name = "role_type")
    private String roleType;

    /**
     * 是否可用
     */
    private Boolean available;

    /**
     * 描述
     */
    private String description;

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