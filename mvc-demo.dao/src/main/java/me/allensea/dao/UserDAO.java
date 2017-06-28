package me.allensea.dao;

import org.apache.ibatis.annotations.Param;

import me.allensea.entity.UserDo;

import java.util.List;

public interface UserDAO {

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    UserDo loadUserById(@Param("id") int id);

    /**
     * 分页获取用户
     * @return
     */
    List<UserDo> findPageUsersByPage();

    /**
     * 更新用户
     * @param userDo
     */
    void  updateUser(UserDo userDo);
}
