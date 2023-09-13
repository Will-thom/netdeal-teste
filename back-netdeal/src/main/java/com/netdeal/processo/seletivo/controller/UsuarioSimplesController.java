package com.netdeal.processo.seletivo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netdeal.processo.seletivo.entity.UsuarioSimples;
import com.netdeal.processo.seletivo.service.UsuarioSimplesService;

@RestController
public class UsuarioSimplesController {

    @Autowired
    private UsuarioSimplesService service;

    @PostMapping("/addUsuarioSimples")
    public UsuarioSimples addUsuarioSimples(@RequestBody UsuarioSimples usuarioSimples) {
        return service.saveUsuarioSimples(usuarioSimples);
    }

    @PostMapping("/addUsuarioSimplesList")
    public List<UsuarioSimples> addUsuarioSimples(@RequestBody List<UsuarioSimples> usuarioSimples) {
        return service.saveUsuarioSimples(usuarioSimples);
    }

    @GetMapping("/usuarioSimples")
    public List<UsuarioSimples> findAllUsuarioSimples() {
    	
        return service.getUsuarioSimples();
    }

    @GetMapping("/usuarioSimplesById/{id}")
    public UsuarioSimples findUsuarioSimplesById(@PathVariable int id) {
        return service.getUsuarioSimplesById(id);
    }

    @GetMapping("/usuarioSimples/{name}")
    public UsuarioSimples findUsuarioSimplesByName(@PathVariable String name) {
        return service.getUsuarioSimplesByName(name);
    }

    @PutMapping("/updateUsuarioSimples")
    public UsuarioSimples updateUsuarioSimples(@RequestBody UsuarioSimples usuarioSimples) {
        return service.updateUsuarioSimples(usuarioSimples);
    }

    @DeleteMapping("/deleteUsuarioSimples/{id}")
    public String deleteUsuarioSimples(@PathVariable int id) {
        return service.deleteUsuarioSimples(id);
    }
}
