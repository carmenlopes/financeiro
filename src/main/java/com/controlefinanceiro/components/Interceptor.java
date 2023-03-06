package com.controlefinanceiro.components;

import java.lang.reflect.Method;
import java.time.LocalDate;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.controlefinanceiro.anotacoes.Movimentar;
import com.controlefinanceiro.enums.MovimentacaoTipo;
import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.model.Movimentacao;
import com.controlefinanceiro.repository.MovimentarRepository;
import com.controlefinanceiro.utils.LoggingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@ControllerAdvice
public class Interceptor implements ResponseBodyAdvice<Object> {
    // private static final org.slf4j.Logger log =
    // org.slf4j.LoggerFactory.getLogger(Interceptor.class);

    @Autowired
    LoggingService loggingService;

    @Autowired
    private MovimentarRepository repository;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType,
            Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest,
            ServerHttpResponse serverHttpResponse) {

        loggingService.logResponse(((ServletServerHttpRequest) serverHttpRequest).getServletRequest(),
                ((ServletServerHttpResponse) serverHttpResponse).getServletResponse(), o);

        Method methodName = methodParameter.getMethod();
        String classe = methodName.getReturnType().getSimpleName();

        try {
            Movimentacao mv = new Movimentacao();
            System.out.println("OBJ> " + o.toString());
            JSONObject j = new JSONObject(o);
            System.out.println(j);
            if (methodName.isAnnotationPresent(Movimentar.class)) {

                if ("Receita".equalsIgnoreCase(classe)) {
                    mv.setNome(j.getString("nome"));
                    mv.setIdMovimentacao(j.getLong("id"));
                    mv.setValor(j.getDouble("valor"));
                    mv.setTipoMovimentacao(MovimentacaoTipo.RECEITA.getValue());
                    mv.setDtEntrada(LocalDate.parse(j.getString("dtEntrada")));

                    mv.setContaTransacao(getContaDestino(j));

                }if ("Despesa".equalsIgnoreCase(classe) && j.getBoolean("paga")) {
                    mv.setNome(j.getString("nome"));
                    mv.setIdMovimentacao(j.getLong("id"));
                    mv.setValor(j.getDouble("valor"));
                    mv.setTipoMovimentacao(MovimentacaoTipo.DESPESA.getValue());
                    mv.setDtEntrada(LocalDate.parse(j.getString("dtVencimento")));

                   
                    mv.setContaTransacao(getContaDestino(j));

                }
                System.out.println("Mov a gravar ---> "+mv.toString());
                repository.save(mv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return o;
    }

    private Conta getContaDestino(JSONObject j) throws JsonMappingException, JsonProcessingException, JSONException{
        final var objectMapper = new ObjectMapper();
       return objectMapper.readValue(j.get("contaDestino").toString(), Conta.class);
    }

}