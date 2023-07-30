package com.jm.Exception.enums.abs;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 14:51
 */

public interface AbstractBaseExceptionEnum {

    /**
     * 获取异常的状态码
     *
     * @return 状态码
     * @author yubaoshan
     * @date 2020/7/9 14:28
     */
    Integer getCode();

    /**
     * 获取异常的提示信息
     *
     * @return 提示信息
     * @author yubaoshan
     * @date 2020/7/9 14:28
     */
    String getMessage();

}
