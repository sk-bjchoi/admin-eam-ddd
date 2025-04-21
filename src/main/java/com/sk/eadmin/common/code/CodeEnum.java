package com.sk.eadmin.common.code;

public interface CodeEnum {
	String getCode();
	String getDesc();
	
	static <T extends CodeEnum> T fromCode(Class<T> enumType, String code) {
        for (T constant : enumType.getEnumConstants()) {
            if (constant.getCode().equals(code)) {
                return constant;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }
}
