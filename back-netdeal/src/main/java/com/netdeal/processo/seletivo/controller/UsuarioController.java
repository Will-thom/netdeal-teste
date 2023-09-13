package com.netdeal.processo.seletivo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netdeal.processo.seletivo.entity.Usuario;
import com.netdeal.processo.seletivo.service.UsuarioService;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/addUsuario")
    public Usuario addUsuario(@RequestBody Usuario usuario) {
        return service.saveUsuario(usuario);
    }

    @PostMapping("/addUsuarios")
    public List<Usuario> addUsuarios(@RequestBody List<Usuario> usuarios) {
        return service.saveUsuarios(usuarios);
    }

    @GetMapping("/usuarios")
    public List<Usuario> findAllUsuarios() {
    	
    	List<Usuario> listaUsuarios = service.getUsuarios();
		Set<Usuario> set = new HashSet<Usuario>(listaUsuarios);
    	listaUsuarios.clear();
    	listaUsuarios.addAll(set);
    	
        return listaUsuarios;
    }

    @GetMapping("/usuarioById/{id}")
    public Usuario findUsuarioById(@PathVariable int id) {
        return service.getUsuarioById(id);
    }

    @GetMapping("/usuario/{nome}")
    public Usuario findUsuarioByNome(@PathVariable String nome) {
        return service.getUsuarioByNome(nome);
    }

    @PutMapping("/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return service.updateUsuario(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUsuario(@PathVariable int id) {
        return service.deleteUsuario(id);
    }
}
