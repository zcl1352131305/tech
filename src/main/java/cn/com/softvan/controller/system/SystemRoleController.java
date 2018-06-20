package cn.com.softvan.controller.system;

import cn.com.softvan.controller.BaseController;
import cn.com.softvan.entity.system.SystemPermit;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.service.system.SystemPermitService;
import cn.com.softvan.utils.ResultUtil;
import cn.com.softvan.vo.CommonResultVO;
import cn.com.softvan.vo.system.SystemRoleVO;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lhl
 * Date: 2017/12/15
 * Time: 15:38
 */
@Controller
@RequestMapping(value = "/admin/system/role")
public class SystemRoleController extends BaseController<SystemRole, Integer>{

    @Resource
    private SystemPermitService systemPermitService;
    /**
     * 权限树形列表
     * @return
     */
    @GetMapping(value = "/permit/tree/{roleId}")
    @ResponseBody
    public CommonResultVO tree(@PathVariable(value = "roleId")String roleId){
        List<Map<String, String>> treeList = systemPermitService.findTreeList();
        //查询选中的节点
        List<String> checkedId = new ArrayList<>();
        if(!"init".equals(roleId)){
            //非初始化查询已有权限
            List<SystemPermit> ownPermit = systemPermitService.findPermitByRoleId(roleId);
            if(ownPermit != null && !ownPermit.isEmpty()){
                for(SystemPermit permit: ownPermit){
                    //为已有元素设置选中状态
                    for(Map<String, String> temp: treeList){
                        if(temp.get("id").equals(String.valueOf(permit.getId()))){
                            temp.put("checked","true");
                        }
                    }

                    checkedId.add(String.valueOf(permit.getId()));
                }
            }
        }


        JSONObject result = new JSONObject();
        result.put("tree", treeList);
        result.put("checked", checkedId);

        return ResultUtil.success("查询成功", result);
    }

    @PostMapping("/customize")
    public ModelAndView mySave(SystemRoleVO vo, RedirectAttributes attributes){
        return null;
    }


}
