package com.netdeal.processo.seletivo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acesso")
public class Acesso {

    @Id
    private int id;
    
	private String login;
	private String acesso;
	private Integer score;

}
