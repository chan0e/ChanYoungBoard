package com.nhnacademy.chanyoungboard.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.NoHandlerFoundException;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

    @InitBinder
    void intBinder(WebDataBinder webDataBinder){
        webDataBinder.initDirectFieldAccess();
    }


}
