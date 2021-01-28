package com.kevin.springboot.test.mapper;

import com.kevin.springboot.test.entity.dto.RolePermissionDto;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface RolePermissionMapper {
    List<RolePermissionDto> getPermissionByRole(String role_name);
}
