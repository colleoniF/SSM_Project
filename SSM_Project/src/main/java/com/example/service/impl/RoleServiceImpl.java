package com.example.service.impl;

import com.example.dao.RoleMapper;
import com.example.model.User;
import com.example.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Map<String, Object>> getAllRoles() throws Exception {
        return roleMapper.getAllRoles();
    }

    @Override
    public List<Map<String, Object>> getAllRoles_Total() throws Exception {
        return roleMapper.getAllRoles_Total();
    }

    @Override
    public List<Map<String, Object>> findUser(int id) {
        return roleMapper.findUser(id);
    }

    @Override
    public void insert(User user) {
        roleMapper.insert(user);
    }

    @Override
    public void delete(int id) {
        roleMapper.delete(id);
    }

    @Override
    public void tombstone(User user) {
        roleMapper.tombstone(user);
    }

    @Override
    public void update(User user) {
        roleMapper.update(user);
    }

    @Override
    public List<Map<String, Object>> getUserbyName(User user) {
        return roleMapper.getUserbyName(user);
    }

    @Override
    public void recoverUser(User user) {
        roleMapper.recoverUser(user);
    }

}
