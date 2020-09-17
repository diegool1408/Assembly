package br.com.sicredi.assembly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Votacao {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id; 
	
	@Column
	private String conta; 
		
	@Column(nullable = false)
	private String agencia;
	
	@Column(nullable = false)
	private long idPauta; 
	
	@Column(nullable = false)
	private int idSessao; 
	
	@Column( nullable = true )
	private String voto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public int getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}
	
	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(long idPauta) {
		this.idPauta = idPauta;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
	
	
}
