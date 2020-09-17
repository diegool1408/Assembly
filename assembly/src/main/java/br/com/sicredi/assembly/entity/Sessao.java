package br.com.sicredi.assembly.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;


@Entity	
public class Sessao {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id; 
	
	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime dataHoraInicio;
	
	@Column(nullable = false)
	private LocalDateTime dataHoraFim = LocalDateTime.now().plusMinutes(1);
	
	@Column(nullable = false)
	private Long idPauta;
	
	@Column(nullable = false)
	private String agencia;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraInicio() {
		return dataHoraInicio;
	}

	public void setDataHoraInicio(LocalDateTime dataHoraInicio) {
		this.dataHoraInicio = dataHoraInicio;
	}

	public LocalDateTime getDataHoraFim() {
		return dataHoraFim;
	}

	public void setDataHoraFim(LocalDateTime dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}

	public long getIdPauta() {
		return idPauta;
	}

	public void setIdPauta(long idPauta) {
		this.idPauta = idPauta;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

}
