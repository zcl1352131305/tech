package cn.com.softvan.service.system.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemPermit;
import cn.com.softvan.mapper.system.SystemPermitMapper;
import cn.com.softvan.service.system.SystemPermitService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by madman on 2017/12/06.
 */
@Service
@Transactional
public class SystemPermitServiceImpl extends AbstractService<SystemPermit> implements SystemPermitService {
    @Resource
    private SystemPermitMapper systemPermitMapper;

    /**
     * 根据角色id查询所拥有的权限信息
     * @param roles
     * @return
     */
    @Override
    public List<SystemPermit> findPermitByRoleIds(List<Integer> roles){
        if(roles != null && !roles.isEmpty()){
            return systemPermitMapper.findPermitByRoleIds(roles);
        }
        return new ArrayList<>();
    }

    @Override
    public List<Map<String, String>> findTreeList() {
        SystemPermit permit = new SystemPermit();
        permit.setAvailable(1);
        List<SystemPermit> permits = systemPermitMapper.select(permit);

        List<Map<String, String>> result = new ArrayList<>();

        if(permits != null && !permits.isEmpty()){
            for (SystemPermit p: permits){
                Map<String, String> temp = new HashMap<>();
                temp.put("name", p.getName());
                temp.put("pId", String.valueOf(p.getParentId()));
                temp.put("id", String.valueOf(p.getId()));
                result.add(temp);
            }
        }

        return result;
    }

    @Override
    public List<SystemPermit> findPermitByRoleId(String roleId) {
        return systemPermitMapper.findPermitByRoleId(roleId);
    }


    @Override
    public String getTemplatePath() {
        return "system/permit";
    }
}
