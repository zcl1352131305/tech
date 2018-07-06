package cn.com.softvan.controller.system;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.enums.ResultEnum;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.vo.system.SystemUserVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 10:03
 */
@Controller
@RequestMapping(value = "/admin/system/user")
public class SystemUserController extends BaseController<SystemUser, Integer>{

    @Resource
    private SystemUserService systemUserService;
    @PostMapping(value = "/p")
    public ModelAndView save(SystemUserVO bean, RedirectAttributes attributes){
        systemUserService.save(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(systemUserService.getTemplatePath()).concat("/list/1"));
    }

    @PutMapping(value = "/p")
    public ModelAndView update(SystemUserVO bean, RedirectAttributes attributes){
        systemUserService.save(bean);
        attributes.addFlashAttribute("msg", ResultEnum.SUCCESS.getMsg());
        return new ModelAndView("redirect:/admin/".concat(systemUserService.getTemplatePath()).concat("/list/1"));
    }


    @GetMapping(value = "/toUpdate")
    public ModelAndView toUpdate(String msg, Map<String, Object> map){
        SystemUser loginUsr = (SystemUser) SecurityUtils.getSubject().getPrincipal();


        if(null != msg && msg.equals("1")){
            map.put("msg","更改成功！");
        }

        SystemUser user = systemUserService.findById(loginUsr.getId());
        Integer role = user.getRoles().get(0);

        map.put("bean",user);
        map.put("role",role);

        return new ModelAndView(systemUserService.getTemplatePath().concat("_update"),map);
    }


    @PutMapping(value = "/upd/updateUser")
    public ModelAndView toUpdate(SystemUser bean){
        systemUserService.updateUser(bean);
        return new ModelAndView("redirect:/admin/system/user/toUpdate?msg=1");
    }

}
