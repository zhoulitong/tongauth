package com.zlt.liao.tongauth.controller;

import com.zlt.liao.tongauth.entity.domain.User;
import com.zlt.liao.tongauth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author: zhoulitong
 * @date: 2018/4/17
 * @description: LoginController
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/userinfo")
    @ResponseBody
    public Object login(@AuthenticationPrincipal User loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            return null;
        }
        if (loginedUser != null) {
            return userService.getById(loginedUser.getId());
        }
        return null;
    }
}