package com.jm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录用户和ID
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginUserInfo {

    /** 用户 id */
    private Long id;

    /** 用户名 */
    private String username;
}
