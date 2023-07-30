package com.jm.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.ObjectUtil;
import com.jm.Exception.AuthException;
import com.jm.Exception.enums.AuthExceptionEnum;
import com.jm.entity.SysUser;
import com.jm.entity.login.SysLoginUser;
import com.jm.enums.CommonStatusEnum;
import com.jm.factory.LoginUserFactory;
import com.jm.service.AuthService;
import com.jm.service.ISysUserService;
import com.jm.utils.CryptogramUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;


/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:42
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    ISysUserService sysUserService;
    @Override
    public String login(String account, String password) {

        if (ObjectUtil.hasEmpty(account, password)) {
            throw new AuthException(AuthExceptionEnum.ACCOUNT_PWD_EMPTY);
        }
        SysUser sysUser = sysUserService.getUserByCount(account);

        //用户不存在，账号或密码错误
        if (ObjectUtil.isEmpty(sysUser)) {
            throw new AuthException(AuthExceptionEnum.ACCOUNT_PWD_ERROR);
        }
        String passwordHashValue = sysUser.getPwdHashValue();

		// 解密密码（这里是前端传来的，如果不需要可将其干掉，这里不做开关）
        password = CryptogramUtil.doSm2Decrypt(password);

        //验证账号密码是否正确
        if (ObjectUtil.isEmpty(passwordHashValue) || !passwordHashValue.equals(CryptogramUtil.doHashValue(password))) {
            throw new AuthException(AuthExceptionEnum.ACCOUNT_PWD_ERROR);
        }

        return doLogin(sysUser);
    }

    @Override
    public String doLogin(SysUser sysUser) {

        Integer sysUserStatus = sysUser.getStatus();

        //验证账号是否被冻结
        if (CommonStatusEnum.DISABLE.getCode().equals(sysUserStatus)) {
            throw new AuthException(AuthExceptionEnum.ACCOUNT_FREEZE_ERROR);
        }

        //构造SysLoginUser
        SysLoginUser sysLoginUser = this.genSysLoginUser(sysUser);

        //构造jwtPayLoad
        JwtPayLoad jwtPayLoad = new JwtPayLoad(sysUser.getId(), sysUser.getAccount());

        //生成token
        String token = JwtTokenUtil.generateToken(jwtPayLoad);

        //缓存token与登录用户信息对应, 默认2个小时
        this.cacheLoginUser(jwtPayLoad, sysLoginUser);

        //设置最后登录ip和时间
        sysUser.setLastLoginIp(IpAddressUtil.getIp(HttpServletUtil.getRequest()));
        sysUser.setLastLoginTime(DateTime.now());

        //更新用户登录信息
        sysUserService.updateById(sysUser);

        //登录成功，记录登录日志

        //登录成功，设置SpringSecurityContext上下文，方便获取用户
        this.setSpringSecurityContextAuthentication(sysLoginUser);

        //如果开启限制单用户登陆，则踢掉原来的用户
        Boolean enableSingleLogin = ConstantContextHolder.getEnableSingleLogin();
        if (enableSingleLogin) {

            //获取所有的登陆用户
            Map<String, SysLoginUser> allLoginUsers = userCache.getAllKeyValues();
            for (Map.Entry<String, SysLoginUser> loginedUserEntry : allLoginUsers.entrySet()) {

                String loginedUserKey = loginedUserEntry.getKey();
                SysLoginUser loginedUser = loginedUserEntry.getValue();

                //如果账号名称相同，并且redis缓存key和刚刚生成的用户的uuid不一样，则清除以前登录的
                if (loginedUser.getName().equals(sysUser.getName())
                        && !loginedUserKey.equals(jwtPayLoad.getUuid())) {
                    this.clearUser(loginedUserKey, loginedUser.getAccount());
                }
            }
        }

        //返回token
        return token;
    }

    @Override
    public SysLoginUser genSysLoginUser(SysUser sysUser) {
        SysLoginUser sysLoginUser = new SysLoginUser();
        BeanUtil.copyProperties(sysUser, sysLoginUser);
        LoginUserFactory.fillLoginUserInfo(sysLoginUser);
        return sysLoginUser;
    }
}