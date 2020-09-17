package br.com.sicredi.assembly.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.sicredi.assembly.entity.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long> {}
