package com.hailei.mapper;

import com.hailei.domain.User;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;

import java.util.List;

public interface UserMapper {

    List<User> findAll();

    void save(User user);

    void saveUserRoleRel(@Param("id") Long id, @Param("roleIds") Long[] roleIds);

    void delUserRoleRel(Long userId);

    void del(Long userId);

    User findByUsernameAndPassword(User user);
}
