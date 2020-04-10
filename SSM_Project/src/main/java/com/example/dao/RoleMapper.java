package com.example.dao;

import com.example.model.User;

import java.util.List;
import java.util.Map;

public interface RoleMapper {
    List getAllRoles();  //ok
    List getAllRoles_Total(); //ok
    List findUser(int id); //ok
    void insert(User user);  //ok
    void update(User user); //ok
    void delete(int id); //ok
    void tombstone(User user); //ok
    List getUserbyName(User user);
    void recoverUser(User user);
}
