package com.jm.service;

import com.jm.entity.SysUser;
import com.jm.entity.login.SysLoginUser;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:41
 */
public interface AuthService {

    String login(String account, String password);

    String doLogin(SysUser sysUser);

    SysLoginUser genSysLoginUser(SysUser sysUser);

}