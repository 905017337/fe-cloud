package com.jm.mapper;

import com.jm.entity.SysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
* <p>
* 系统用户表 Mapper 接口
* </p>
*
* @author caozhenhao
* @since 2023-07-30
*/
@Mapper
@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

}
