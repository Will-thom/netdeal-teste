package com.netdeal.processo.seletivo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.netdeal.processo.seletivo.entity.Acesso;

public interface AcessoRepository extends JpaRepository<Acesso,Integer> {
    Acesso findByLogin(String login);
}

