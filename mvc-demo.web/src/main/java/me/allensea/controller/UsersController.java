package me.allensea.controller;

import me.allensea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by allen on 17/6/18.
 */
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    // show users by page
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Object index(Integer pageNo) {
        return null;
    }

    @RequestMapping(value = "/users/show", method = RequestMethod.GET)
    public Object show(Integer id) {
        return this.userService.findUserById(id);
    }

}
