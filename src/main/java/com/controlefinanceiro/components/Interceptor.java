package com.controlefinanceiro.components;


import java.lang.constant.ClassDesc;
import java.lang.reflect.Method;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.aspectj.apache.bcel.generic.ObjectType;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import com.controlefinanceiro.anotacoes.Movimentar;
import com.controlefinanceiro.enums.MovimentacaoTipo;
import com.controlefinanceiro.model.Receita;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
     HandlerMethod hm;
      hm = (HandlerMethod) handler;
    
     Method method = hm.getMethod();
     String classe =  method.getReturnType().getSimpleName();
         if (method.isAnnotationPresent(Movimentar.class)) {
            if("Receita".equals(classe)){
              System.out.println("AAAAAAAAAAA>>>>>"+ IOUtils.toString(request.getReader()));
         }
          

          //    System.out.println(method.getAnnotation(Movimentar.class).movimentacaoType().getValue());
        }
    }

}