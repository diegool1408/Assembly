package br.com.sicredi.assembly.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.sicredi.assembly.entity.Votacao;
import br.com.sicredi.assembly.repository.VotacaoRepository;

@Service
public class VotacaoService {
	
    @Autowired
    private VotacaoRepository _votacaoRepository;
    
    @Autowired
    private SessaoService sessaoService;
    
    @RequestMapping(value = "/votacao", method = RequestMethod.GET)
    public List<Votacao> Get() {
        return _votacaoRepository.findAll();
    }   
	
    @RequestMapping(value = "/votacao/{id}", method = RequestMethod.GET)
    public ResponseEntity<Votacao> GetById(@PathVariable(value = "id") long id)
    {
        Optional<Votacao> votacao = _votacaoRepository.findById(id);
        if(votacao.isPresent())
            return new ResponseEntity<Votacao>(votacao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/votacao", method =  RequestMethod.POST)
    public Votacao Post(@Validated @RequestBody Votacao votacao) throws Exception
    {
    	
       	sessaoService.findById(votacao.getIdSessao());
       	
       	    	
        return _votacaoRepository.save(votacao);
    }

    @RequestMapping(value = "/votacao/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Votacao> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Votacao newVotacao)
    {
        Optional<Votacao> oldVotacao = _votacaoRepository.findById(id);
        if(oldVotacao.isPresent()){
            Votacao votacao = oldVotacao.get();
            votacao.setAgencia(newVotacao.getAgencia());
            votacao.setConta(newVotacao.getConta());
            votacao.setIdPauta(newVotacao.getIdPauta());
            votacao.setIdSessao(newVotacao.getIdSessao());
            votacao.setVoto(newVotacao.getVoto());
            _votacaoRepository.save(votacao);
            return new ResponseEntity<Votacao>(votacao, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/votacao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        Optional<Votacao> votacao = _votacaoRepository.findById(id);
        if(votacao.isPresent()){
        	_votacaoRepository.delete(votacao.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
