package cn.com.softvan.entity.system;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_system_role")
@Data
public class SystemRole  extends BaseEntity {

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

    @Transient
    List<Integer> permits;
}