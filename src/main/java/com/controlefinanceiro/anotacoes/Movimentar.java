package com.controlefinanceiro.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.controlefinanceiro.enums.MovimentacaoTipo;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Movimentar {

    MovimentacaoTipo movimentacaoType() default MovimentacaoTipo.UNKNOW;

   
}
