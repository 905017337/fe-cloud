package com.jm.controller;

import com.jm.core.controller.AbstractController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.jm.service.ISysUserService;
import com.jm.entity.SysUser;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * <p>
 * 系统用户表 前端控制器
 * </p>
 *
 * @author caozhenhao
 * @since 2023-07-30
 * @version v1.0
 */
@RestController
@RequestMapping("//api/v1/sys-user")
public class SysUserController extends AbstractController<SysUser, ISysUserService> {

    @Resource
    private ISysUserService iSysUserService;


}
