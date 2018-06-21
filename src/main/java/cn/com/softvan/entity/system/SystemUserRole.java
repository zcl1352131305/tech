package cn.com.softvan.entity.system;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_system_user_role")
@Data
public class SystemUserRole  extends BaseEntity {

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;


}