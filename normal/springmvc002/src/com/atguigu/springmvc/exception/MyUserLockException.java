package com.atguigu.springmvc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.LOCKED,reason="账户被锁定，请拨打0607")
public class MyUserLockException extends RuntimeException
{
	private static final long serialVersionUID = 1L;
}
