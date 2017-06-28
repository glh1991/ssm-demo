package me.allensea.service;

import me.allensea.entity.UserDo;

import java.util.List;

public interface UserService {

    UserDo findUserById(int id);

    List<UserDo> findPageUsers();

    boolean updateUser(int id, String name);
}
