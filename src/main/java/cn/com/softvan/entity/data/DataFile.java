package cn.com.softvan.entity.data;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_data_file")
@Data
public class DataFile  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 信息id
     */
    private String infoId;

    /**
     * 文件名
     */
    private String name;

    /**
     * 文件尺寸
     */
    private Long size;

    /**
     * 路径
     */
    private String path;

    /**
     * 类型
     */
    private String type;

    /**
     * 关键字
     */
    private String keyword;

    /**
     * 后缀名
     */
    private String suffix;

    /**
     * 排序
     */
    private Integer sort;

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



}