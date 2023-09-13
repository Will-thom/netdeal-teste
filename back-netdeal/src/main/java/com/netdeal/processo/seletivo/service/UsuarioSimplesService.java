package com.netdeal.processo.seletivo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netdeal.processo.seletivo.entity.UsuarioSimples;
import com.netdeal.processo.seletivo.repository.UsuarioSimplesRepository;

import java.util.List;

@Service
public class UsuarioSimplesService {
    @Autowired
    private UsuarioSimplesRepository repository;

    public UsuarioSimples saveUsuarioSimples(UsuarioSimples usuarioSimples) {
        return repository.save(usuarioSimples);
    }

    public List<UsuarioSimples> saveUsuarioSimples(List<UsuarioSimples> usuarioSimples) {
        return repository.saveAll(usuarioSimples);
    }

    public List<UsuarioSimples> getUsuarioSimples() {
        return repository.findAll();
    }

    public UsuarioSimples getUsuarioSimplesById(int id) {
        return repository.findById(id).orElse(null);
    }

    public UsuarioSimples getUsuarioSimplesByName(String name) {
        return repository.findByName(name);
    }

    public String deleteUsuarioSimples(int id) {
        repository.deleteById(id);
        return "usuarioSimples removed !! " + id;
    }

    public UsuarioSimples updateUsuarioSimples(UsuarioSimples usuarioSimples) {
        UsuarioSimples existingUsuarioSimples = repository.findByName(usuarioSimples.getName());
        existingUsuarioSimples.setName(usuarioSimples.getName());
        return repository.save(existingUsuarioSimples);
    }


}
