package me.allensea.dao;

import me.allensea.entity.UserDo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by allen on 17/6/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:/spring-config/applicationContext-dao.xml",
        "classpath:/spring-config/mybatis-config.xml" })
public class UserDaoTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    public void testLoadUserById() {
        UserDo userDo = this.userDAO.loadUserById(1);
        Assert.assertEquals(1, userDo.getId());
    }
}
