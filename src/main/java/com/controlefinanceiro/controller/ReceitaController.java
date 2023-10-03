package com.controlefinanceiro.controller;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.controlefinanceiro.utils.DataUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.controlefinanceiro.model.Receita;
import com.controlefinanceiro.model.types.TipoReceita;
import com.controlefinanceiro.service.ReceitaService;

import jakarta.validation.Valid;

import javax.xml.crypto.Data;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    private final ReceitaService service;

    public ReceitaController(ReceitaService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita cadastrarReceita(@RequestBody @Valid Receita receita) throws Throwable {
        return service.createReceita(receita);
    }

    @PostMapping(value = "/tiporeceita")
    @ResponseStatus(code = HttpStatus.CREATED)
    public TipoReceita cadastrarTipoReceita(@RequestBody @Valid TipoReceita tipoReceita) throws Throwable {
        return service.createTipoReceita(tipoReceita);
    }

    @GetMapping
    public List<Receita> list(){
        return service.listReceitas();
    }

    @GetMapping(value="/tiporeceita")
    public List<TipoReceita> listTipos(){
        return service.listTipos();
    }

    @GetMapping("/{data}")
    public List<Receita> listReceitasByMes(@PathVariable String data){
        var aux = DataUtils.convertStringToDate(data);
        var dtInicial = LocalDate.of(aux.getYear(),aux.getMonth(), 1);
        var dtFinal = DataUtils.getLastDayofMonth(data);
        System.out.println(dtInicial + " "+dtFinal);
        return service.listReceitasByMes(dtInicial,dtFinal);
    }

    @GetMapping("/anual/{ano}")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Double> listSomaReceitasByMesAno(@PathVariable int ano) {
        Map<String, Double> soma = new LinkedHashMap<>();
        int mes = 1;
        do{
            var dtInicial = LocalDate.of(ano,mes,1);
            var dtFinal = LocalDate.of(ano,mes,dtInicial.lengthOfMonth());
            String nomeMes = dtInicial.getMonth().getDisplayName(TextStyle.FULL,new Locale("pt", "BR"));
            System.out.println("Nome dom mes: "+nomeMes);
            soma.put(nomeMes.toUpperCase(),service.listSomaReceitasByMes(dtInicial, dtFinal));
            mes++;
        }while (mes <= 12);
        return soma;
    }
    //TODO: Agrupar a soma de receitas por tipo e mes
}
