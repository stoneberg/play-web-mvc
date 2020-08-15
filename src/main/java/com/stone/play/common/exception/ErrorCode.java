package com.stone.play.common.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;

@Getter
public enum ErrorCode {

	USER_NOT_FOUND("AUTH_ERR001", "해당 사용자를 찾을 수 없습니다.", HttpStatus.NOT_FOUND.value()), 
	USER_EXISTS("AUTH_ERR002", "이미 등록된 사용자입니다.", HttpStatus.BAD_REQUEST.value()), 
	EMAIL_DUPLICATION("AUTH_ERR003", "사용 중인 이메일입니다.", HttpStatus.BAD_REQUEST.value()),
	AUTHENTICATION_FAILED("AUTH_ERR004", "이메일과 비밀번호가 정확하지 않습니다.", HttpStatus.UNAUTHORIZED.value()),
	JWT_TOKEN_INVALID("AUTH_ERR005", "토큰이 유효하지 않습니다.", HttpStatus.UNAUTHORIZED.value()),
	INPUT_VALUE_INVALID("INVALID_ERR001", "입력 값이 올바르지 않습니다.", HttpStatus.BAD_REQUEST.value()),
	METHOD_NOT_ALLOWED("INVALID_ERR002","지원되지 않는 메서드 요청입니다.", HttpStatus.METHOD_NOT_ALLOWED.value()),
	RESOURCE_NOT_FOUND("INVALID_ERR003","해당 자원을 찾을 수 없습니다.", HttpStatus.NOT_FOUND.value()),
	UNKNOWN_EXCEPTION("UNKNOWN_ERR000","알 수 없는 오류가 발생했습니다.", HttpStatus.INTERNAL_SERVER_ERROR.value());
	
	private final String code;
	private final String message;
	private final int status;

	ErrorCode(String code, String message, int status) {
		this.code = code;
		this.message = message;
		this.status = status;
	}

}
