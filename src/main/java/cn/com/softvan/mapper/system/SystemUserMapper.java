package cn.com.softvan.mapper.system;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.system.SystemUser;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 信息详情dao
 */
@Component
public interface SystemUserMapper extends Mapper<SystemUser> {
    List<Integer> findSelectedRolesId(Integer userId);
    SystemUser findUserByName(String userName);
    List<Integer> findSelectOrganizationsId(Integer userId);

}