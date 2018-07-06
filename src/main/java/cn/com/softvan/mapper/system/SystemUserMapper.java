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
    List<SystemUser> selectUsersByRole(Integer roleId);

}