package br.com.fiap.ejb.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name="chamado")
//@SequenceGenerator(name = "chamado_sequence", sequenceName = "chamado_id_seq")
//@TableGenerator(name = "chamado_id", table = "primary_keys", pkColumnName = "key", pkColumnValue = "chamado", valueColumnName = "value")
@EntityListeners(ChamadoListener.class)
public class Chamado implements Serializable {

	private Integer id;
	private String descricao;

	@Override
	public String toString() {
		return "Chamado: " + getId();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)																																			//@Column(name="codigo")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	@PrePersist
	public void preInsert() {
		System.out.println("Inserindo chamado no banco de dados.");
	}
	
}
