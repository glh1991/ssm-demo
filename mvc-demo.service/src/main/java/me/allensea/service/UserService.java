package me.allensea.service;

import me.allensea.entity.UserDo;

public interface UserService {

    UserDo findUserById(int id);

    boolean updateUser(int id, String name);
}
