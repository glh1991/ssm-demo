package me.allensea.facade;

/**
 * Created by allen on 17/7/1.
 */
public interface UserFacade {

    /**
     * 设置用户token到redis中
     * @param userId
     * @param token
     */
    void setUserToken(int userId, String token);

    /**
     * 获取用户token
     *
     * @param userId
     * @return
     */
    String getUserToken(int userId);
}
