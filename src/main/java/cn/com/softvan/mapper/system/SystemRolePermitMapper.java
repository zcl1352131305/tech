package cn.com.softvan.mapper.system;


import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.system.SystemRolePermit;
import cn.com.softvan.entity.system.SystemUserRole;
import org.springframework.stereotype.Component;


/**
 * 信息详情dao
 */
@Component
public interface SystemRolePermitMapper extends Mapper<SystemRolePermit> {

    void deleteByRoleId(Integer roleId);
}