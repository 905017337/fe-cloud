package com.jm.factory;


import com.jm.annotion.ExpEnumType;

/**
 * @author caozhenhao
 * @version 1.0
 * @date 2023/7/30 14:54
 */

public class ExpEnumCodeFactory {

    public static Integer getExpEnumCode(Class<?> clazz, int code) {

        // 默认的异常响应码
        Integer defaultCode = Integer.valueOf("" + 99 + 9999 + 9);

        if (clazz == null) {
            return defaultCode;
        } else {
            ExpEnumType expEnumType = clazz.getAnnotation(ExpEnumType.class);
            if (expEnumType == null) {
                return defaultCode;
            }
            return Integer.valueOf("" + expEnumType.module() + expEnumType.kind() + code);
        }

    }

}
