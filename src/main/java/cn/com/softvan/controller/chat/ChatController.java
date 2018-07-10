package cn.com.softvan.controller.chat;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.chat.Chat;
import cn.com.softvan.entity.data.DataFile;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.entity.tech.CourseWork;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.chat.ChatService;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.service.tech.CourseService;
import cn.com.softvan.utils.WebUtils;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 10:03
 */
@Controller
@RequestMapping(value = "/admin/chat")
public class ChatController extends BaseController<Chat, Integer>{

    @Resource
    private ChatService chatService;
    @Resource
    private SystemUserService systemUserService;


    @GetMapping(value = "/tochat")
    public ModelAndView tochat(){
        return new ModelAndView(chatService.getTemplatePath().concat("chat"));
    }

    /**
     * 获取聊天数据
     * @param chatUserId
     * @return
     */
    @GetMapping(value = "/getChatData/{chatUserId}")
    @ResponseBody
    public List<Chat> getCchatData(@PathVariable Integer chatUserId){
        return chatService.chatWith(chatUserId);
    }

    @GetMapping(value = "/getFriendList")
    @ResponseBody
    public JSONObject getFriendList(){
        return chatService.getFriendList();
    }

    @GetMapping(value = "/getUnReadingMessage")
    @ResponseBody
    public List<Chat> getUnReadingMessage(){
        return chatService.getUnReadingMessage();
    }


    @PostMapping(value = "/sendMessage")
    @ResponseBody
    public Chat sendMessage(Chat bean){
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        if(null != bean){
            bean.setSender(loginUsr.getId());
            bean.setCreateDate(new Date());
            bean.setIsReading("0");
        }
        chatService.save(bean);
        bean.setSenderDetail(loginUsr);
        bean.setCreateDateStr(WebUtils.getDateTimeString(bean.getCreateDate()));
        bean.setSendFlag("1");
        return bean;
    }

    //后台管理员操作
    @GetMapping(value = "/adminList/{page}")
    public ModelAndView list(HttpServletRequest request, @PathVariable(value = "page")Integer page,
                             @RequestParam(value = "size", defaultValue = "15")Integer size,
                             Map<String, Object> map){

        PageHelper.startPage(page, size);
        List<Chat> list = chatService.findAll();
        for(Chat chat:list){
            if(null != chat.getSender()){
                chat.setSenderDetail(systemUserService.findById(chat.getSender()));
            }
            if(null != chat.getReceiver()){
                chat.setReceiverDetail(systemUserService.findById(chat.getReceiver()));
            }
            chat.setCreateDateStr(WebUtils.getDateTimeString(chat.getCreateDate()));
        }
        PageInfo pageInfo = new PageInfo<>(list);
        map.put("pageInfo", pageInfo);
        return new ModelAndView("tech/adminChat_list", map);
    }

}
