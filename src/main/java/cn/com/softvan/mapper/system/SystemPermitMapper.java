package cn.com.softvan.mapper.system;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.system.SystemPermit;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 信息详情dao
 */
@Component
public interface SystemPermitMapper extends Mapper<SystemPermit> {
    List<SystemPermit> findPermitByRoleId(String roleId);
    List<SystemPermit> findUserPermits(Integer userId);
    List<SystemPermit> findPermitByRoleIds(List<Integer> roles);
}