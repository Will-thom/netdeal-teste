package com.netdeal.processo.seletivo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    private int id;
    private String nome;
	
    @OneToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario_subordinacao", referencedColumnName = "id")
	private List<Usuario> usuariosSubordinados;	

}
