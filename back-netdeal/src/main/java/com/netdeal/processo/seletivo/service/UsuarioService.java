package com.netdeal.processo.seletivo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netdeal.processo.seletivo.entity.Usuario;
import com.netdeal.processo.seletivo.repository.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Usuario saveUsuario(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> saveUsuarios(List<Usuario> usuarios) {
        return repository.saveAll(usuarios);
    }

    public List<Usuario> getUsuarios() {
        return repository.findAll();
    }

    public Usuario getUsuarioById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Usuario getUsuarioByNome(String nome) {
        return repository.findByNome(nome);
    }

    public String deleteUsuario(int id) {
        repository.deleteById(id);
        return "usuario removed !! " + id;
    }

    public Usuario updateUsuario(Usuario usuario) {
        Usuario existingUsuario = repository.findById(usuario.getId()).orElse(null);
        existingUsuario.setNome(usuario.getNome());
        return repository.save(existingUsuario);
    }


}
