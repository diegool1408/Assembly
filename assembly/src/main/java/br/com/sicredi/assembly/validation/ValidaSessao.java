package br.com.sicredi.assembly.validation;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;

import br.com.sicredi.assembly.controller.SessaoController;

import br.com.sicredi.assembly.entity.Sessao;

public class ValidaSessao {
	

	public static void ValidaSessaoAberta( int idSessao ) throws Exception {
		
		
		SessaoController c = new SessaoController();
		
		ResponseEntity<Sessao> sessao = c.GetById(idSessao);

		
		// Valida se Horario eh valido para votacao na sessao
		/*if ( LocalDateTime.now().isBefore(sessao.getDataHoraInicio()) ||
			 LocalDateTime.now().isAfter(sessao.getDataHoraFim())) {
			
			throw new Exception();
			
		}*/
		
	}
	

}
