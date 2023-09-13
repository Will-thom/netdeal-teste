package com.netdeal.processo.seletivo.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario_simples")
public class UsuarioSimples {

    @Id
    private String name;
	
    @OneToMany
	@JoinColumn(name = "subordination", referencedColumnName = "name")
	@NotFound(action = NotFoundAction.IGNORE)
	private Set<UsuarioSimples> items;	

}
