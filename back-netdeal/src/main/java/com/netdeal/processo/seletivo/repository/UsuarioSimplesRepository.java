package com.netdeal.processo.seletivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netdeal.processo.seletivo.entity.UsuarioSimples;

public interface UsuarioSimplesRepository extends JpaRepository<UsuarioSimples,Integer> {
    UsuarioSimples findByName(String name);
}

