package cn.com.softvan.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Table(name = "t_system_user_role")
@Data
public class SystemUserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "role_id")
    private Integer roleId;


}