package cn.com.softvan.auth;

import cn.com.softvan.entity.system.SystemPermit;
import cn.com.softvan.entity.system.SystemUser;
import cn.com.softvan.service.system.SystemPermitService;
import cn.com.softvan.service.system.SystemRoleService;
import cn.com.softvan.service.system.SystemUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private SystemUserService systemUserService;

    @Autowired
    private SystemPermitService systemPermitService;
    @Autowired
    private SystemRoleService systemRoleService;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.debug("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        SystemUser userInfo  = (SystemUser)principals.getPrimaryPrincipal();
        //List<Integer> roles = systemUserService.findSelectedRolesId(userInfo.getId());
        List<Integer> roles = systemRoleService.findRoleIdByUserId(userInfo.getId());
        if(roles != null){
            for(Integer roleId: roles){
                authorizationInfo.addRole(String.valueOf(roleId));
            }
        }
        //添加权限
        List<SystemPermit> permits =systemPermitService.findPermitByRoleIds(roles);;
        Set<String> addPermits = new HashSet<>();
        if(permits != null){
            for(SystemPermit permit: permits){
                addPermits.add(permit.getPermission());
            }
        }
        authorizationInfo.setStringPermissions(addPermits);
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
            throws AuthenticationException {
        log.info("开始认证用户...");
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        SystemUser userInfo = systemUserService.findBy("userName", username);
        if(userInfo == null){
            return null;
        }

        //判断是否锁定
        if("1".equals(userInfo.getLocked())){
            throw new LockedAccountException();
        }

        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
                getName()  //realm name
        );
        //authenticationInfo.setCredentialsSalt(ByteSource.Util.bytes(userInfo.getSalt()));
        return authenticationInfo;
    }
}