package cn.com.softvan.service.system;


import cn.com.softvan.base.Service;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.vo.system.SystemUserVO;

/**
 * Created by madman on 2017/12/05.
 */
public interface SystemUserService extends Service<SystemUser> {
    void save(SystemUserVO vo);
}
