package me.allensea.service;

import me.allensea.dao.UserDAO;
import me.allensea.entity.UserDo;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by allen on 17/6/18.
 */
public class UserServiceTest {

    @Autowired
    private UserDAO     userDAO;
    @Autowired
    private UserService userService;

    @Before
    public  void setUp() {
        UserDAO mockDao =  mock(UserDAO.class);
        when(mockDao.loadUserById(1)).thenReturn(new UserDo(1, "allen"));

    }

}
