package cn.com.softvan.controller.system;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemPermit;
import cn.com.softvan.service.system.SystemPermitService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/18
 * Time: 9:50
 */
@Controller
@RequestMapping(value = "/admin/system/permit")
public class SystemPermitController extends BaseController<SystemPermit, Integer> {

    @Resource
    private SystemPermitService systemPermitService;
    /**
     * 自定义查询
     * @param id
     * @param map
     * @return
     */
    @GetMapping(value = {"/customize/{id}", "/customize"})
    public ModelAndView myEdit(@PathVariable(required = false) Integer id, Map<String, Object> map){
        SystemPermit permit;
        if(id == null || (permit = systemPermitService.findById(id))==null){
            //不存在,实例化对象
            permit = new SystemPermit();
        }
        //查询父级信息
        List<SystemPermit> permits = systemPermitService.findAll();
        map.put("bean", permit);
        map.put("permits", permits);
        return new ModelAndView("system/permit_edit", map);
    }
}
