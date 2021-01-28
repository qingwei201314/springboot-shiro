package com.kevin.springboot.Utils.shiro;

import com.kevin.springboot.test.entity.dto.RolePermissionDto;
import com.kevin.springboot.test.mapper.RolePermissionMapper;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.permission.RolePermissionResolver;
import org.apache.shiro.authz.permission.WildcardPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class RolePermissionResolverImpement implements RolePermissionResolver {
    @Autowired
    private RolePermissionMapper rolesPermissionsMapper;

    /**
     *  根据角色，取出所有权限
     *  @Author: Kevin Zhang @Date: 2021-1-27 14:04
    **/
    @Override
    public Collection<Permission> resolvePermissionsInRole(String role) {
        List<RolePermissionDto> rolesPermissions = rolesPermissionsMapper.getPermissionByRole(role);
        List<Permission> permissions = new ArrayList<Permission>();
        if(rolesPermissions != null && rolesPermissions.size() > 0){
            for(RolePermissionDto rolesPermission: rolesPermissions){
                WildcardPermission wildcardpermission = new WildcardPermission(rolesPermission.getName() + ":" + rolesPermission.getPermission());
                permissions.add(wildcardpermission);
            }
        }
        return permissions;
    }
}
