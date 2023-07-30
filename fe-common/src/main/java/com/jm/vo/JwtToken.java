package com.jm.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 授权中心鉴权之后给客户端的 Token
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 12:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtToken {

    /** JWT */
    private String token;
}
