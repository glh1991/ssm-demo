package me.allensea.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.allensea.dao.UserDAO;
import me.allensea.entity.UserDo;
import me.allensea.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public UserDo findUserById(int id) {
        return this.userDAO.loadUserById(id);
    }

    @Override
    public boolean updateUser(int id, String name) {
        UserDo userDo = this.findUserById(id);
        if (userDo == null)
            return false;
        userDo.setName(name);
        this.userDAO.updateUser(userDo);
        return true;
    }

}
