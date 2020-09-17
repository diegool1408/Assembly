package br.com.sicredi.assembly.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;


import br.com.sicredi.assembly.entity.Sessao;
import br.com.sicredi.assembly.repository.SessaoRepository;

@Service
public class SessaoService implements ISessaoService {
	
    
	@Autowired
	private SessaoRepository _sessaoRepository;

	@Autowired
	private ISessaoService sessaoService;
	    
	public ResponseEntity<Sessao> GetById(int id)
	{
		Optional<Sessao> sessao = _sessaoRepository.findById(id);
		if(sessao.isPresent())

            return new ResponseEntity<Sessao>(sessao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    public List<Sessao> Get() {
        return _sessaoRepository.findAll();
    }   
    
    public Sessao Post(@Validated @RequestBody Sessao sessao)
    {
        return _sessaoRepository.save(sessao);
    }

    public ResponseEntity<Sessao> Put(int id, Sessao newSessao)
    {
        Optional<Sessao> oldSessao = _sessaoRepository.findById(id);
        if(oldSessao.isPresent()){
            Sessao sessao = oldSessao.get();
            sessao.setDataHoraInicio(newSessao.getDataHoraInicio());
            sessao.setDataHoraFim(newSessao.getDataHoraFim());
            sessao.setDataHoraFim(newSessao.getDataHoraFim());
            sessao.setIdPauta(newSessao.getIdPauta());
            sessao.setAgencia(newSessao.getAgencia());
            _sessaoRepository.save(sessao);
            return new ResponseEntity<Sessao>(sessao, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> Delete(int id)
    {
        Optional<Sessao> sessao = _sessaoRepository.findById(id);
        if(sessao.isPresent()){
        	_sessaoRepository.delete(sessao.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    public void ValidaSessaoAberta( int id ) throws Exception {
				
		Optional<Sessao> s = sessaoService.findById(id);
						
		// Valida se Horario eh valido para votacao na sessao
		if ( LocalDateTime.now().isBefore(s.get().getDataHoraInicio()) ||
			 LocalDateTime.now().isAfter(s.get().getDataHoraFim())) {
			
			throw new Exception();
			
		}
		
	}
    
	@Override
    public Optional<Sessao> findById(int id) {

        return _sessaoRepository.findById(id);
    }


}
