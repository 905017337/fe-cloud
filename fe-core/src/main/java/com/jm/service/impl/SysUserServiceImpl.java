package com.jm.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jm.core.service.impl.AbstractServiceImpl;
import com.jm.entity.SysUser;
import com.jm.enums.CommonStatusEnum;
import com.jm.mapper.SysUserMapper;
import com.jm.service.ISysUserService;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

/**
* <p>
* 系统用户表 服务实现类
* </p>
*
* @author caozhenhao
* @since 2023-07-30
*/
@Slf4j
@Service
public class SysUserServiceImpl extends AbstractServiceImpl<SysUser> implements ISysUserService{

    @Resource
    SysUserMapper sysUserMapper;


    @Override
    public SysUser getUserByCount(String account) {
        LambdaQueryWrapper<SysUser> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SysUser::getAccount, account);
        queryWrapper.ne(SysUser::getStatus, CommonStatusEnum.DELETED.getCode());
        return this.sysUserMapper.selectOne(queryWrapper);
    }


}
