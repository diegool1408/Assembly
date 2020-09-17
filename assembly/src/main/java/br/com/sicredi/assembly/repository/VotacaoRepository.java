package br.com.sicredi.assembly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.assembly.entity.Votacao;

@Repository
public interface VotacaoRepository extends JpaRepository<Votacao, Long>{}
