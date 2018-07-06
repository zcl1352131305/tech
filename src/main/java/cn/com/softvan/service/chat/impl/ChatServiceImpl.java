package cn.com.softvan.service.chat.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.chat.Chat;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseStudent;
import cn.com.softvan.mapper.chat.ChatMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.tech.CourseMapper;
import cn.com.softvan.mapper.tech.CourseStudentMapper;
import cn.com.softvan.service.Sys;
import cn.com.softvan.service.chat.ChatService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.service.tech.CourseVideoService;
import cn.com.softvan.service.tech.CourseWorkService;
import cn.com.softvan.utils.WebUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Condition;

import javax.servlet.http.HttpServletRequest;
import java.util.*;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class ChatServiceImpl extends AbstractService<Chat> implements ChatService {

    @Autowired
    private ChatMapper chatMapper;

    @Autowired
    private SystemUserMapper systemUserMapper;

    @Override
    public String getTemplatePath() {
        return "chat/";
    }


    /**
     * 和谁聊天
     * @param chatUserId
     * @return
     */
    public List<Chat> chatWith(Integer chatUserId){
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();

        //两人所有对话内容
        Map<String ,Integer> param = new HashMap<>();
        param.put("usr1",chatUserId);
        param.put("usr2",loginUsr.getId());
        List<Chat> chats = chatMapper.selectChatWithPeople(param);

        //和你对话的人
        SystemUser chatUser = systemUserMapper.selectByPrimaryKey(chatUserId);

        List<Chat> notReading = new ArrayList<>();
        for(Chat chat:chats){
            chat.setCreateDateStr(WebUtils.getDateTimeString(chat.getCreateDate()));
            if(!chat.getIsReading().equals("1") && chat.getReceiver().equals(loginUsr.getId())){
                notReading.add(chat);
            }
            //发送人（如果我是发送人，那么消息位置应该在右边，反之在左边）
            if(chat.getSender().equals(loginUsr.getId())){
                chat.setSenderDetail(loginUsr);
                chat.setSendFlag("1");
            }
            else{
                chat.setSendFlag("0");
                chat.setSenderDetail(chatUser);
            }
            //接收人
            if(chat.getReceiver().equals(loginUsr.getId())){
                chat.setReceiverDetail(loginUsr);
            }
            else{
                chat.setReceiverDetail(chatUser);
            }
        }

        for(Chat chat:notReading){
            chat.setIsReading("1");
            chatMapper.updateByPrimaryKeySelective(chat);
        }

        return chats;
    }

    /**
     * 获取聊天好友列表
     * @return
     */
    public JSONObject getFriendList(){
        List<SystemUser> teachersData = systemUserMapper.selectUsersByRole(2);
        List<SystemUser> studentsData = systemUserMapper.selectUsersByRole(3);
        List<SystemUser> teachers = new ArrayList<>();
        List<SystemUser> students = new ArrayList<>();
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();

        for(SystemUser systemUser:teachersData){
            if(!systemUser.getId().equals(loginUsr.getId())){
                teachers.add(systemUser);
            }
        }
        for(SystemUser systemUser:studentsData){
            if(!systemUser.getId().equals(loginUsr.getId())){
                students.add(systemUser);
            }
        }


        Condition condition = new Condition(Chat.class);
        condition.createCriteria().andCondition("receiver = " + loginUsr.getId()+ "").andCondition("is_reading = '0'");
        List<Chat> unReadingMessages = findByCondition(condition);

        for(SystemUser teacher:teachers){
            for(Chat chat:unReadingMessages){
                if(teacher.getId().equals(chat.getSender())){
                    teacher.addSendMessageNumsToMe();
                }
            }
        }

        for(SystemUser student:students){
            for(Chat chat:unReadingMessages){
                if(student.getId().equals(chat.getSender())){
                    student.addSendMessageNumsToMe();
                }
            }
        }
        JSONObject json = new JSONObject();
        json.put("teachers",teachers);
        json.put("students",students);
        return json;
    }


    public List<Chat> getUnReadingMessage() {
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        Condition condition = new Condition(Chat.class);
        condition.createCriteria().andCondition("receiver = " + loginUsr.getId()+ "").andCondition("is_reading = '0'");
        return findByCondition(condition);
    }
}
