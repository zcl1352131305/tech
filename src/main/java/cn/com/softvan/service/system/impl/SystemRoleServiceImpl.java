package cn.com.softvan.service.system.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.entity.system.SystemRolePermit;
import cn.com.softvan.entity.system.SystemUserRole;
import cn.com.softvan.mapper.system.SystemRoleMapper;
import cn.com.softvan.mapper.system.SystemRolePermitMapper;
import cn.com.softvan.service.system.SystemRoleService;
import cn.com.softvan.vo.system.SystemRoleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;


/**
 * Created by madman on 2017/12/06.
 */
@Service
@Transactional
public class SystemRoleServiceImpl extends AbstractService<SystemRole> implements SystemRoleService {
    @Resource
    private SystemRoleMapper systemRoleMapper;
    @Autowired
    private SystemRolePermitMapper systemRolepermitMapper;

    @Override
    public List<Integer> findRoleIdByUserId(Integer userId) {
        return systemRoleMapper.findRoleIdByUserId(userId);
    }


    @Override
    public String getTemplatePath() {
        return "system/role";
    }

    @Override
    public void save(SystemRoleVO vo){
        //查看是否存在
    }

    @Override
    public void save(SystemRole model) {
        model.setCreateDate(new Date());
        model.setUpdateDate(new Date());
        mapper.insertSelective(model);
        List<Integer> roles = model.getPermits();
        saveRolePermit(roles,model.getId());
    }

    public void update(SystemRole model) {
        model.setUpdateDate(new Date());
        mapper.updateByPrimaryKeySelective(model);
        SystemUserRole userRole = new SystemUserRole();
        userRole.setUserId(model.getId());
        systemRolepermitMapper.deleteByRoleId(model.getId());
        List<Integer> roles = model.getPermits();
        saveRolePermit(roles,model.getId());
    }

    private void saveRolePermit(List<Integer> roles ,Integer id){
        if(null != roles){
            for(Integer permitId:roles){
                SystemRolePermit rolePermit = new SystemRolePermit();
                rolePermit.setPermitId(permitId);
                rolePermit.setRoleId(id);
                systemRolepermitMapper.insertSelective(rolePermit);
            }
        }
    }
}
