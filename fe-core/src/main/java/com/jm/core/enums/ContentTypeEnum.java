package com.jm.core.enums;


import com.jm.Exception.enums.abs.AbstractBaseExceptionEnum;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2022/11/30 11:51
 */
public enum ContentTypeEnum implements AbstractBaseExceptionEnum {

    /**
     * 数据不存在
     */
    NOT_EXIST(1, "此数据不存在");

    private  Integer code;

    private  String message;

    ContentTypeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    ContentTypeEnum(Integer code) {
        this.code = code;
    }

    @Override
    public Integer getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }

}