package com.kevin.springboot.Utils.shiro;

import java.util.*;
import com.kevin.springboot.test.entity.User;
import com.kevin.springboot.test.entity.UserPermit;
import com.kevin.springboot.test.mapper.UserMapper;
import com.kevin.springboot.test.mapper.UserPermitMapper;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.config.ConfigurationException;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.JdbcUtils;
import org.apache.shiro.util.ByteSource.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *  控制用户权限，作为shiro的Realm。
 *  @Author: Kevin Zhang @Date: 2021-1-28 9:06
**/
public class MybatisRealm extends AuthorizingRealm {
    @Autowired
    private RolePermissionResolverImpement rolePermissionResolverImpement;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserPermitMapper userPermitMapper;

    //由于修改了默认的表结构，此处暂时注释，如果有用到再独个找开。
//    protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
//    protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";
//    protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";
//    protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";
    private static final Logger log = LoggerFactory.getLogger(MybatisRealm.class);
    protected String authenticationQuery = "";
    protected String userRolesQuery = "";
    protected String permissionsQuery = "";
    protected boolean permissionsLookupEnabled = false;

    public MybatisRealm() {
        super.setRolePermissionResolver(rolePermissionResolverImpement);
    }

    public void setAuthenticationQuery(String authenticationQuery) {
        this.authenticationQuery = authenticationQuery;
    }

    public void setUserRolesQuery(String userRolesQuery) {
        this.userRolesQuery = userRolesQuery;
    }

    public void setPermissionsQuery(String permissionsQuery) {
        this.permissionsQuery = permissionsQuery;
    }

    public void setPermissionsLookupEnabled(boolean permissionsLookupEnabled) {
        this.permissionsLookupEnabled = permissionsLookupEnabled;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken upToken = (UsernamePasswordToken)token;
        String username = upToken.getUsername();
        if (username == null) {
            throw new AccountException("Null usernames are not allowed by this realm.");
        } else {
            String password = null;
            //取出password
            User user = userMapper.getByUsername(username);
            if (user == null || user.getPassword() == null) {
                throw new UnknownAccountException("No account found for user [" + username + "]");
            } else {
                password = user.getPassword();
            }
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(username, password.toCharArray(), this.getName());
            return info;
        }
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        if (principals == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        } else {
            String username = (String)this.getAvailablePrincipal(principals);
            // 根据用户名取出权限

            List<UserPermit> permits = userPermitMapper.getPermits(username);
            //拥有哪些角色
            LinkedHashSet<String> roles = new LinkedHashSet<>();
            //拥有哪些权限
            LinkedHashSet<String> permissions = new LinkedHashSet<String>();
            if(permits != null && permits.size() > 0){
                for(UserPermit permit: permits){
                    String permitString = permit.getPermit();
                    if(permitString != null && permitString.length() > 0){
                        String[] rolePermission = permitString.split(":");
                        roles.add(rolePermission[0]);
                        permissions.add(permitString);
                    }
                }
            }

            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            info.setRoles(roles);
            info.setStringPermissions(permissions);
            return info;
        }
    }

    protected Set<String> getPermissions(String username, Collection<String> roleNames) {
        List<String> roles = new ArrayList<String>();
        Iterator var6 = roleNames.iterator();
        while(var6.hasNext()) {
            String roleName = (String)var6.next();
            roles.add(roleName);
        }
        List<UserPermit> permits = userPermitMapper.getPermitsByUsernameAndRole(username, roles);
        LinkedHashSet<String> permissions = new LinkedHashSet<String>();
        if(permits != null && permits.size() > 0){
            for(UserPermit permit: permits){
                permissions.add(permit.getPermit());
            }
        }
        return permissions;
    }

}
