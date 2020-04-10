package com.example.service;

import com.example.model.User;

import java.util.List;
import java.util.Map;

public interface RoleService {
    List<Map<String, Object>> getAllRoles() throws Exception;
    List<Map<String, Object>> findUser(int id);
    List<Map<String, Object>> getAllRoles_Total() throws Exception;
    void insert(User user);
    void delete(int id);
    void update(User user);
    void tombstone(User user);
    List<Map<String, Object>> getUserbyName(User user);
    void recoverUser(User user);
}
