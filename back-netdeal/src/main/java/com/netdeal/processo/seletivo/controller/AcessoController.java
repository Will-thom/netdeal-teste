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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netdeal.processo.seletivo.entity.Acesso;
import com.netdeal.processo.seletivo.service.AcessoService;

@RestController
@RequestMapping("acesso")
public class AcessoController {

    @Autowired
    private AcessoService service;

    @PostMapping("/add")
    public Acesso addAcesso(@RequestBody Acesso acesso) {
        return service.saveAcesso(acesso);
    }

    @PostMapping("/addList")
    public List<Acesso> addAcessos(@RequestBody List<Acesso> acessos) {
        return service.saveAcessos(acessos);
    }

    @GetMapping("/getList")
    public List<Acesso> findAllAcessos() {
    	
    	List<Acesso> listaAcessos = service.getAcessos();
		Set<Acesso> set = new HashSet<Acesso>(listaAcessos);
    	listaAcessos.clear();
    	listaAcessos.addAll(set);
    	
        return listaAcessos;
    }

    @GetMapping("/byId/{id}")
    public Acesso findAcessoById(@PathVariable int id) {
        return service.getAcessoById(id);
    }

    @GetMapping("/byLogin/{login}")
    public Acesso findAcessoByLogin(@PathVariable String login) {
        return service.getAcessoByLogin(login);
    }

    @PutMapping("/update")
    public Acesso updateAcesso(@RequestBody Acesso acesso) {
        return service.updateAcesso(acesso);
    }

    //TODO: bug de cors ao usar o @DeleteMapping("/delete/{id}"). usando o GET por enquanto...
    @GetMapping("/delete/{id}")
    public Acesso deleteAcesso(@PathVariable int id) {
        return service.deleteAcesso(id);
    }
}
