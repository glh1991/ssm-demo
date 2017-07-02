package me.allensea.facade.impl;

import me.allensea.facade.UserFacade;
import me.allensea.redis.RedisClientTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by allen on 17/7/1.
 */
@Service("userFacade")
public class UserFacadeImpl implements UserFacade {

    @Autowired
    private RedisClientTemplate redis;

    @Override
    public void setUserToken(int userId, String token) {
        this.redis.set("ut:" + userId, token);
    }

    @Override
    public String getUserToken(int userId) {
        return this.redis.get("ut:" + userId);
    }
}
