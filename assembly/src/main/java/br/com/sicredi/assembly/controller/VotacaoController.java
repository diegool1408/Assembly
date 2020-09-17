package br.com.sicredi.assembly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembly.entity.Votacao;
import br.com.sicredi.assembly.repository.VotacaoRepository;
import br.com.sicredi.assembly.service.CountByAgenciaPauta;
import br.com.sicredi.assembly.service.SessaoService;
import br.com.sicredi.assembly.service.VotacaoService;
import br.com.sicredi.assembly.validation.ValidaSessao;


@RestController
public class VotacaoController {
     
    
	private VotacaoService votacaoService;
	
    @Autowired
    private SessaoService sessaoService;
    
    @RequestMapping(value = "/votacao", method = RequestMethod.GET)
    public List<Votacao> Get() {
        return votacaoService.Get();
    }   
    
    @RequestMapping(value = "/votacao/{id}", method = RequestMethod.GET)
    public ResponseEntity<Votacao> GetById(@PathVariable(value = "id") long id)
    {
    	return votacaoService.GetById(id);
    }
    
    
    @RequestMapping(value = "/votacao", method =  RequestMethod.POST)
    public Votacao Post(@Validated @RequestBody Votacao votacao) throws Exception
    {
    	
       	sessaoService.findById(votacao.getIdSessao());
       	
       	    	
        return votacaoService.Post(votacao);
        
    }

    @RequestMapping(value = "/votacao/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Votacao> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Votacao newVotacao)
    {
        return votacaoService.Put(id, newVotacao);
    }

    @RequestMapping(value = "/votacao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
        return votacaoService.Delete(id);
    }
    
  
        
}
