package com.netdeal.processo.seletivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netdeal.processo.seletivo.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
    Usuario findByNome(String nome);
}

