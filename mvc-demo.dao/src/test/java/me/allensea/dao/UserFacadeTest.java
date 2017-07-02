package me.allensea.dao;

import me.allensea.facade.UserFacade;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by allen on 17/7/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-config/applicationContext-dao-test.xml",
        "classpath:/spring-config/applicationContext-redis.xml" })
public class UserFacadeTest {

    @Autowired
    private UserFacade userFacade;

    @Test
    public void testSetUserToken() {
        this.userFacade.setUserToken(1, "123456");
        String token = this.userFacade.getUserToken(1);
        Assert.assertEquals("123456", token);
    }
}
