package cn.com.softvan.entity.chat;

import cn.com.softvan.entity.BaseEntity;
import cn.com.softvan.entity.system.SystemUser;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "t_chat")
@Data
public class Chat extends BaseEntity {

    private Integer sender;

    @Transient
    private SystemUser senderDetail;

    private Integer receiver;

    @Transient
    private SystemUser receiverDetail;

    private String content;

    @Column(name = "is_reading")
    private String isReading;

    @Transient
    private String sendFlag;

    @Transient
    private String createDateStr;


}
