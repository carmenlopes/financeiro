package com.controlefinanceiro.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class RelatorioController {

    @GetMapping("{mes}")
    public List<Optional> list(){
        return null;
    }
}
