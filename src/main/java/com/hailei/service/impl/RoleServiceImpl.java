package com.hailei.service.impl;

import com.hailei.domain.Role;
import com.hailei.mapper.RoleMapper;
import com.hailei.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> list() {
        List<Role> roleList = roleMapper.findAll();
        return roleList;
    }

    @Override
    public void save(Role role) {
        roleMapper.save(role);
    }
}
