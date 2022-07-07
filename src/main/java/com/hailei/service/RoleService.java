package com.hailei.service;

import com.hailei.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> list() ;

    void save(Role role);
}
