package me.allensea.controller;

import me.allensea.controller.filter.PageFilter;
import me.allensea.entity.UserDo;
import me.allensea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by allen on 17/6/18.
 */
@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping(value ={"/users", "/"}, method = RequestMethod.GET)
    public Object index(HttpServletRequest request, HttpServletResponse response, Integer pageNo,
                        Integer pageRow) {
        List<UserDo> userDos = this.userService.findPageUsers();
        return  new ModelAndView("users/index", "users", userDos);
    }

    @RequestMapping(value = "/users/show", method = RequestMethod.GET)
    public Object show(Integer id) {
        return this.userService.findUserById(id);
    }

}
