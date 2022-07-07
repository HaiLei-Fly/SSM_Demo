package com.hailei.service.impl;

import com.hailei.domain.Role;
import com.hailei.domain.User;
import com.hailei.mapper.RoleMapper;
import com.hailei.mapper.UserMapper;
import com.hailei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        List<User> userList = userMapper.findAll();
        //封装userList中的每一个User的roles数据
        for (User user : userList) {
            //获得user的id
            Long id = user.getId();
            //将id作为参数 查询当前userId对应的Role集合数据
            List<Role> roles = roleMapper.findRoleByUserId(id);
            user.setRoles(roles);
        }
        return userList;
    }

    @Override
    public void save(User user, Long[] roleIds) {
        //第一步 向sys_user表中存储数据
        userMapper.save(user);
        User new_user = userMapper.findByUsernameAndPassword(user);
        //第二步 向sys_user_role 关系表中存储多条数据
        Long id = new_user.getId();
        userMapper.saveUserRoleRel(id,roleIds);
    }

    @Override
    public void del(Long userId) {
        //1、删除sys_user_role关系表
        userMapper.delUserRoleRel(userId);
        //2、删除sys_user表
        userMapper.del(userId);
    }

    @Override
    public User login(User user) {
        try {
            return userMapper.findByUsernameAndPassword(user);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }


}
