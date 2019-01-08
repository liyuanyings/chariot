package com.example.demo;

import com.example.demo.common.CustomizeRuntimeException;
import com.example.demo.common.result.ECommonResult;
import com.example.demo.common.result.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class CustomizeGlobalExceptionAdvice {

    private static final Logger logger = LoggerFactory.getLogger(CustomizeGlobalExceptionAdvice.class);

    /**
     * 500
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseResult exceptionHandler(Exception e) {
        logger.error("system exception: ", e);
        return ResponseResult.error(ECommonResult.INTERNAL_SERVER_ERROR).build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    private ResponseResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        logger.error("invalid request: ", e);
        return ResponseResult.error().retmsg(e.getMessage()).build();
    }

    /**
     * 404
     * 需要先配置 spring.mvc.throw-exception-if-no-handler-found=true
     * @param e
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private ResponseResult noHandlerFoundExceptionHandler(NoHandlerFoundException e) {
        return ResponseResult.error(ECommonResult.PAGE_NOT_FOUND).retmsg(e.getMessage()).build();
    }

    @ExceptionHandler(CustomizeRuntimeException.class)
    @ResponseBody
    private ResponseResult customizeRuntimeExceptionHandler(CustomizeRuntimeException e) {
        return ResponseResult.error().retcode(e.getCode()).retmsg(e.getMessage()).build();
    }
}
