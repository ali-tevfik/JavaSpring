package com.ali.db.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ali.db.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError> handlerBaseException(BaseException baseException,WebRequest request){
        return ResponseEntity.badRequest().body(creatApiError(baseException.getMessage(), request));
    }

    private String getHostName(){
        try{
            return InetAddress.getLocalHost().getHostAddress();
        }catch(UnknownHostException e ){
            System.out.println("Error " + e.getMessage());
            return null;
        }

    }
    public <E> ApiError<E> creatApiError(E message , WebRequest request){
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception<E> exception = new Exception<>();
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());
        exception.setPath(request.getDescription(false).substring(4));
        exception.setMessage(message);

        apiError.setException(exception);
        return  apiError;
    }
}
