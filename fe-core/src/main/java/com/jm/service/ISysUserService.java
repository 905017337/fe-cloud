package com.jm.service;

import com.jm.core.service.AbstractService;
import com.jm.entity.SysUser;
/**
* <p>
* 系统用户表 服务类
* </p>
*
* @author caozhenhao
* @since 2023-07-30
*/
public interface ISysUserService extends AbstractService<SysUser> {

    SysUser getUserByCount(String account);



}
