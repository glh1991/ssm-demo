package me.allensea.dao;

import org.apache.ibatis.annotations.Param;

import me.allensea.entity.UserDo;

public interface UserDAO {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UserDo loadUserById(@Param("id") int id);

    /**
     * 更新用户
     * @param userDo
     */
    void  updateUser(UserDo userDo);
}
