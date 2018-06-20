package cn.com.softvan.controller.sms;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 10:03
 */
@Controller
@RequestMapping(value = "/sms/")
public class SmsController {


    @PostMapping(value = "/sendsms")
    @ResponseBody
    public Map<String,Object>  sendSms(String phone){
        String msg = "1";
        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isEmpty(phone)){
            msg = "手机号码不能为空！";
        }
        else{
            int random=(int)(Math.random()*1000000);
            String code = random + "";
            /**
             * 这里写发送短信的内容，验证码就是上面的code
             */
            map.put("code",code);
        }
        map.put("msg", msg);

        return map;
    }

}
