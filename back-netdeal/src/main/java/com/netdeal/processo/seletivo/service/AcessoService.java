package com.netdeal.processo.seletivo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder.BCryptVersion;
import org.springframework.stereotype.Service;

import com.netdeal.processo.seletivo.entity.Acesso;
import com.netdeal.processo.seletivo.infra.security.ForcaSenha;
import com.netdeal.processo.seletivo.repository.AcessoRepository;

@Service
public class AcessoService {
    @Autowired
    private AcessoRepository repository;

    public Acesso saveAcesso(Acesso acesso) {
    	
    	acesso.setScore(new ForcaSenha().scoreAcesso(acesso.getAcesso()));
    	
		acesso.setAcesso(new BCryptPasswordEncoder(BCryptVersion.$2A, 10).
				encode(acesso.getAcesso()));

		
		return repository.save(acesso);
    }

    public List<Acesso> saveAcessos(List<Acesso> acessos) {
        return repository.saveAll(acessos);
    }

    public List<Acesso> getAcessos() {
        return repository.findAll();
    }

    public Acesso getAcessoById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Acesso getAcessoByLogin(String login) {
        return repository.findByLogin(login);
    }

    public Acesso deleteAcesso(int id) {
        repository.deleteById(id);

        //TODO: retornando payload sem mensagem, erro pendente ser corrigido no response no front.
        Acesso acesso = new Acesso();
        acesso.setLogin("Acesso Removido com sucesso!");
        //return "acesso removed !! " + id;
        return acesso;
    }

    public Acesso updateAcesso(Acesso acesso) {
        Acesso existingAcesso = repository.findById(acesso.getId()).orElse(null);
        existingAcesso.setLogin(acesso.getLogin());
		existingAcesso.setAcesso(acesso.getAcesso());
        return repository.save(existingAcesso);
    }


}
