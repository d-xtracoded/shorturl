package com.prime.shorturl.execption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundExecption extends RuntimeException{
    public NotFoundExecption(String msg){
        super(msg);
    }

    public NotFoundExecption(String msg, Throwable cause){
        super(msg,cause);
    }
}
