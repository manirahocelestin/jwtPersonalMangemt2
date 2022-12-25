package com.nkunda.useraplication.service;

import com.nkunda.useraplication.domain.Role;
import com.nkunda.useraplication.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();

}
