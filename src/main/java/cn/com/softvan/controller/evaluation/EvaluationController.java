package cn.com.softvan.controller.evaluation;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.chat.Chat;
import cn.com.softvan.entity.evaluation.Evaluation;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.tech.Course;
import cn.com.softvan.service.chat.ChatService;
import cn.com.softvan.service.evaluation.EvaluationService;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.utils.WebUtils;
import com.alibaba.fastjson.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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
@RequestMapping(value = "/admin/evaluation")
public class EvaluationController extends BaseController<Evaluation, Integer>{

    @Autowired
    private EvaluationService evaluationService;

    @Autowired
    private SystemUserService systemUserService;


    @GetMapping(value = "/toEvaluation")
    public ModelAndView toEvaluation(String msg, Map<String, Object> map){
        List<SystemUser> teachers = systemUserService.getRoleUsers(2);

        if(null != msg && msg.equals("1")){
            map.put("msg","评教成功！");
        }
        map.put("teachers",teachers);
        return new ModelAndView(evaluationService.getTemplatePath().concat("evaluation_edit"),map);
    }

    @PostMapping(value = "/saveEvaluation")
    @ResponseBody
    public ModelAndView saveEvaluation(Evaluation bean){
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();
        if(null != bean){
            bean.setUserId(loginUsr.getId());
            bean.setCreateDate(new Date());
        }
        evaluationService.save(bean);

        return  new ModelAndView("redirect:/admin/".concat(evaluationService.getTemplatePath()).concat("/toEvaluation?msg=1"));
    }

}
