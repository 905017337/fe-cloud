package com.jm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户名和密码
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:53
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsernameAndPassword {

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;
}