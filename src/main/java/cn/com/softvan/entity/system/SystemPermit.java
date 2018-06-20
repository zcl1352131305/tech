package cn.com.softvan.entity.system;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_system_permit")
@Data
public class SystemPermit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 类型
     */
    private String type;

    /**
     * 权限字符串
     */
    private String permission;

    /**
     * 地址
     */
    private String url;

    /**
     * 父级id
     */
    @Column(name = "parentId")
    private Integer parentId;

    /**
     * 父级id集合
     */
    @Column(name = "parentIds")
    private String parentIds;

    /**
     * 是否可用
     */
    private Integer available;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "del_flag")
    private String delFlag;


}