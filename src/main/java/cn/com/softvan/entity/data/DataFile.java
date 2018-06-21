package cn.com.softvan.entity.data;

import cn.com.softvan.entity.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "t_data_file")
@Data
public class DataFile  extends BaseEntity{


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




}