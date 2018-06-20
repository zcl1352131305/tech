package cn.com.softvan.service.system.impl;


import cn.com.softvan.base.AbstractService;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.entity.system.SystemUserRole;
import cn.com.softvan.mapper.system.SystemRoleMapper;
import cn.com.softvan.mapper.system.SystemUserMapper;
import cn.com.softvan.mapper.system.SystemUserRoleMapper;
import cn.com.softvan.service.system.SystemUserService;
import cn.com.softvan.vo.system.SystemUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by madman on 2017/12/05.
 */
@Service
@Transactional
public class SystemUserServiceImpl extends AbstractService<SystemUser> implements SystemUserService {

    @Resource
    private SystemRoleMapper systemRoleMapper;

    @Autowired
    private SystemUserRoleMapper systemUserRoleMapper;

    @Override
    public String getTemplatePath() {
        return "system/user";
    }

    /**
     * 保存用户与角色
     * @param vo
     */
    @Override
    public void save(SystemUserVO vo) {
        SystemUser user = new SystemUser();
        BeanUtils.copyProperties(vo, user);
        //保存用户
        if(StringUtils.isEmpty(user.getId())){
            //系统自增
            mapper.insert(user);
        }else {
            mapper.updateByPrimaryKey(user);
        }
    }

    @Override
    public void save(SystemUser model) {
        int id = mapper.insertSelective(model);
        List<Integer> roles = model.getRoles();
        if(null != roles){
            for(Integer roleId:roles){
                SystemUserRole userRole = new SystemUserRole();
                userRole.setUserId(model.getId());
                userRole.setRoleId(roleId);
                systemUserRoleMapper.insertSelective(userRole);
            }
        }
    }


    @Override
    public SystemUser findById(Object id){

        SystemUser user = mapper.selectByPrimaryKey(id);
        List<Integer> roles = systemRoleMapper.findRoleIdByUserId((Integer)id);

        user.setRoles(roles);
        return user;
    }


}
