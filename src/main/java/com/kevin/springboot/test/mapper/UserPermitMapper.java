package com.kevin.springboot.test.mapper;

import com.kevin.springboot.test.entity.UserPermit;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserPermitMapper {
    List<UserPermit> getPermits(String username);
    List<UserPermit> getPermitsByUsernameAndRole(String username, List<String> roles);
}
