package com.prime.shorturl.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestExecption extends RuntimeException{
    public BadRequestExecption(String msg){
        super(msg);
    }

    public  BadRequestExecption(String msg, Throwable cause){
        super(msg,cause);
    }
}
