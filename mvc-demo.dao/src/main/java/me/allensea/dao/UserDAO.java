package me.allensea.dao;

import org.apache.ibatis.annotations.Param;

import me.allensea.entity.UserDo;

public interface UserDAO {

    UserDo loadUserById(@Param("id") int id);
}
