package cn.com.softvan.service.system;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemPermit;

import java.util.List;
import java.util.Map;


/**
 * Created by madman on 2017/12/06.
 */
public interface SystemPermitService extends Service<SystemPermit> {
    List<SystemPermit> findPermitByRoleIds(List<Integer> roles);
    List<Map<String, String>> findTreeList();
    List<SystemPermit> findPermitByRoleId(String roleId);
}
