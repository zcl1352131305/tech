package cn.com.softvan.vo.wechat;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
public class WechatUserVO {
    private String id;

    private String openid;

    private String nickname;

    private String phone;



}