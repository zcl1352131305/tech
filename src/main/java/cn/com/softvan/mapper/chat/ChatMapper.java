package cn.com.softvan.mapper.chat;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.chat.Chat;
import cn.com.softvan.entity.tech.Course;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 信息详情dao
 */
@Component
public interface ChatMapper extends Mapper<Chat> {
    List<Chat> selectChatWithPeople(Map<String,Integer> entity);
}