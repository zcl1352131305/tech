package cn.com.softvan.mapper.system;



import cn.com.softvan.base.Mapper;
import cn.com.softvan.entity.system.SystemRole;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;


/**
 * 信息详情dao
 */
@Component
public interface SystemRoleMapper extends Mapper<SystemRole> {

    void deleteRoleAndPermit(Integer roleId);
    void insertRoleAndPermit(Map<String, Integer> param);
    void insertRoleAndUser(Map<String, Integer> param);
    void deleteRoleAndUser(Integer userId);
    List<Integer> findRoleIdByUserId(Integer userId);

}