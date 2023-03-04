package com.controlefinanceiro.components;

import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;

import com.controlefinanceiro.anotacoes.Movimentar;
import com.controlefinanceiro.repository.MovimentarRepository;
import com.controlefinanceiro.utils.LoggingService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class Interceptor extends RequestBodyAdviceAdapter {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(Interceptor.class);

    private MovimentarRepository repository;

    @Autowired
    LoggingService loggingService;

    @Autowired
    HttpServletRequest httpServletRequest;

    @Autowired
    HttpServletResponse httpServletResponse;

    public Interceptor(MovimentarRepository repository) {
        this.repository = repository;
    }

    @Override
    public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
            Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
                log.info("eefefefe------> "+body.toString());
        loggingService.logResponse(httpServletRequest, httpServletResponse, body);
        System.out.println("wewereewtrte");

        log.info("configuração");

        Method methodName = parameter.getMethod();
        String classe = methodName.getReturnType().getSimpleName();
        if (StringUtils.isNotBlank(methodName.getName())
                && methodName.isAnnotationPresent(Movimentar.class)) {

            if ("Receita".equals(classe)) {
            }

        }
       

        return super.afterBodyRead(body, inputMessage, parameter, targetType, converterType);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Type type,
            Class<? extends HttpMessageConverter<?>> aClass) {
       
        return true;
    }

}