package cn.com.softvan.service.system.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.mapper.system.SystemRoleMapper;
import cn.com.softvan.service.system.SystemRoleService;
import cn.com.softvan.vo.system.SystemRoleVO;
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
public class SystemRoleServiceImpl extends AbstractService<SystemRole> implements SystemRoleService {
    @Resource
    private SystemRoleMapper systemRoleMapper;

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
}
