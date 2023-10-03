package com.controlefinanceiro.controller;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

import com.controlefinanceiro.utils.DataUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.controlefinanceiro.model.Despesa;
import com.controlefinanceiro.service.DespesaService;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    private final DespesaService service;

    public DespesaController(DespesaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Despesa> list() {
        return service.listAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<List<Despesa>> gravar(@RequestBody Despesa despesa) throws Throwable {
        List<Despesa> saved = new ArrayList<>();

        if (!despesa.isDespesaFixa()) {
            return ResponseEntity.ok(Arrays.asList(service.create(despesa)));
        } else {
            for (int i = 0; i < despesa.getQtdRepeticao(); i++) {
                Despesa d = new Despesa();
                d.setNome(despesa.getNome());
                d.setValor(despesa.getValor());
                d.setDtVencimento(despesa.getDtVencimento().plusMonths(i));
                d.setDespesaFixa(despesa.isDespesaFixa());
                //se não encontrar o tipo de despesa, cria uma nova
                d.setTipoDespesa(despesa.getTipoDespesa());
                saved.add(d);
            }
            service.createAll(saved);
            return ResponseEntity.ok(saved);
        }
    }

    @GetMapping("/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Despesa> getDespesasByMes(String data) {
        var aux = DataUtils.convertStringToDate(data);
        var dtInicial = LocalDate.of(aux.getYear(), aux.getMonth(), 1);
        var dtFinal = DataUtils.getLastDayofMonth(data);
        return service.listAllDespesasByMes(dtInicial, dtFinal);
    }

    @GetMapping("/totalmensal/{data}")
    @ResponseStatus(code = HttpStatus.OK)
    public Double getSomaDespesasByMes(String data) {
        var dtInicial = DataUtils.convertStringToDate(data);
        var dtFinal = DataUtils.getLastDayofMonth(data);
        System.out.println(dtInicial + " " + dtFinal);
        return service.listSomaDespesasByMes(dtInicial, dtFinal);
    }

    @GetMapping("/anual/{ano}")
    @ResponseStatus(code = HttpStatus.OK)
    public Map<String, Double> getSomaDespesasByMesAno(@PathVariable int ano) {
        Map<String, Double> soma = new LinkedHashMap<>();
        int mes = 1;
        do{
            var dtInicial = LocalDate.of(ano,mes,1);
            var dtFinal = LocalDate.of(ano,mes,dtInicial.lengthOfMonth());
            String nomeMes = dtInicial.getMonth().getDisplayName(TextStyle.FULL,new Locale("pt", "BR"));
            System.out.println("Nome dom mes: "+nomeMes);
            soma.put(nomeMes.toUpperCase(),service.listSomaDespesasByMes(dtInicial, dtFinal));
            mes++;
        }while (mes <= 12);
        return soma;
    }
}
