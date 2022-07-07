package com.hailei.mapper;

import com.hailei.domain.Role;

import java.util.List;

public interface RoleMapper {

    List<Role> findAll();

    void save(Role role);

    List<Role> findRoleByUserId(Long id);

}
