package cn.com.softvan.service.system;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemRole;
import cn.com.softvan.vo.system.SystemRoleVO;

import java.util.List;


/**
 * Created by madman on 2017/12/06.
 */
public interface SystemRoleService extends Service<SystemRole> {
    List<Integer> findRoleIdByUserId(Integer userId);
    void save(SystemRoleVO vo);
}
