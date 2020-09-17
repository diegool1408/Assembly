package br.com.sicredi.assembly.service;

import java.util.Optional;

import br.com.sicredi.assembly.entity.Sessao;

public interface ISessaoService {

	Optional<Sessao> findById(int id);
	
}
