package com.controlefinanceiro.controller;

import com.controlefinanceiro.model.Conta;
import com.controlefinanceiro.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conta")
public class ContaController {

   private final ContaService service;

    public ContaController(ContaService service) {
    this.service = service;
}

    @Operation(summary = "Todas as contas bancárias")
    @GetMapping
    public List<Conta> list(){
        return service.listAll();
    }
    
    @Operation(summary = "Cadastrar uma nova conta bancária")
    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Conta cadastrar(@RequestBody @Valid Conta conta) throws Throwable {
        return service.create(conta);
    }

    @Operation(summary = "Editar o nome da conta")
    @PutMapping(value = "/{id}")
    public Conta update(@PathVariable @NotNull Long id,
            @RequestBody @Valid Conta conta) {
        return service.updateNome(id, conta);
    }

    //TODO: CONTA - Editar o saldo da conta
    //TODO: CONTA - Guardar receita na conta


}
