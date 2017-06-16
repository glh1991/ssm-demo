package me.allensea.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.allensea.service.UserService;

@RestController
public class HelloController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public Object index(HttpServletRequest request, HttpServletResponse response) {
        return this.userService.findUserById(1);
    }
}
