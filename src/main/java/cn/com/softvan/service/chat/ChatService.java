package cn.com.softvan.service.chat;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.chat.Chat;
import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * Created by madman on 2017/12/05.
 */
public interface ChatService extends Service<Chat> {
    List<Chat> chatWith(Integer chatUserId);

    JSONObject getFriendList();

    List<Chat> getUnReadingMessage();
}
