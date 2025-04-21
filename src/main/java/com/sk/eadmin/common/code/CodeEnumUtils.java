package com.sk.eadmin.common.code;

public class CodeEnumUtils {
    public static <E extends Enum<E> & CodeEnum> E fromCode(Class<E> enumClass, String code) {
        for (E e : enumClass.getEnumConstants()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }
        throw new IllegalArgumentException("Invalid code: " + code);
    }

}
