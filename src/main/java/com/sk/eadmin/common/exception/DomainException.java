package com.sk.eadmin.common.exception;

import lombok.Getter;

@SuppressWarnings("serial")
@Getter
public class DomainException extends RuntimeException{
	
	private final ErrorCode errorCode;
	
	public DomainException(ErrorCode errorCode) {
        super("[" + errorCode.getCode() + "] " + errorCode.getMessage());
        this.errorCode = errorCode;
    }

}
