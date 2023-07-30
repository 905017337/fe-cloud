package com.jm.controller;

import cn.hutool.core.lang.Dict;
import com.jm.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录统一控制器
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:08
 */

@RestController
public class AuthController {

    @Resource
    AuthService authService;


    @PostMapping("/login")
	public String login(@RequestBody Dict dict){
        String account = dict.getStr("account");
        String password = dict.getStr("password");
        String tenantCode = dict.getStr("tenantCode");  //验证码

        return  authService.login(account, password);
    }


}