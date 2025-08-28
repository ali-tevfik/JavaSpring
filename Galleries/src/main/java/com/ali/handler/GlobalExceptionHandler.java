package com.ali.handler;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.ali.exception.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {BaseException.class})
    public ResponseEntity<ApiError<?>> handlerException(BaseException ex,WebRequest request){
        return ResponseEntity.badRequest().body(createApiError(ex.getMessage(), request));
    }


    private List<String> addValue (List<String> list, String newValue){
        list.add(newValue);
        return list;
    }

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<ApiError<Map<String, List<String>>>> HandlerMethodArgumentNotValidException(MethodArgumentNotValidException ex,WebRequest request){
        Map<String, List<String>> map = new HashMap<>();
        for(ObjectError objectError:ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objectError).getField(); 

            if(map.containsKey(fieldName)){
                map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
            }else{
                map.put(fieldName,addValue(new ArrayList<>(),objectError.getDefaultMessage()));
            }
            
        }
        
        return ResponseEntity.badRequest().body(createApiError(map, request));
    }

    private String getHostName() {
        try{
        return Inet4Address.getLocalHost().getHostName();
        }catch(UnknownHostException e){
            return "";
        }
    }

    public <E> ApiError<E> createApiError(E message, WebRequest request){
        ApiError<E> apiError = new ApiError<>();
        apiError.setStatus(HttpStatus.BAD_REQUEST.value());

        Exception <E> exception = new Exception<>();
        exception.setPath(request.getDescription(false));
        exception.setCreateTime(new Date());
        exception.setHostName(getHostName());

        apiError.setException(exception);
        return null;
    }

}
