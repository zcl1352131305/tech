package cn.com.softvan.entity.system;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "t_system_role_permit")
@Data
public class SystemRolePermit extends BaseEntity {

    @Column(name = "role_id")
    private Integer roleId;

    @Column(name = "permit_id")
    private Integer permitId;


}