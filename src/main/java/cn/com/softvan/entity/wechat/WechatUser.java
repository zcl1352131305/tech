package cn.com.softvan.entity.wechat;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/12/19 0019.
 */
@Table(name = "t_wechat_user")
@Data
public class WechatUser {
    @Id
    private String id;

    private String openid;

    private String qrcode;

    private String headimgurl;

    private String nickname;

    private String sex;

    private String phone;

    private String country;

    private String province;

    private String city;

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
