package br.com.sicredi.assembly.controller;

import java.time.LocalDateTime;
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

import br.com.sicredi.assembly.entity.Sessao;
import br.com.sicredi.assembly.repository.SessaoRepository;
import br.com.sicredi.assembly.service.ISessaoService;
import br.com.sicredi.assembly.service.SessaoService;



@RestController
public class SessaoController {
	
	@Autowired
	private SessaoRepository _sessaoRepository;
	
	//@Autowired
	//private ISessaoService sessaoService;
	
	@Autowired
	private SessaoService sessaoService;
	
	@RequestMapping(value = "/sessao/{id}", method = RequestMethod.GET)
	public ResponseEntity<Sessao> GetById(@PathVariable(value = "id") int id)
	{
		Optional<Sessao> sessao = _sessaoRepository.findById(id);
		if(sessao.isPresent())

            return new ResponseEntity<Sessao>(sessao.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    
    @RequestMapping(value = "/sessao", method = RequestMethod.GET)
    public List<Sessao> Get() {
        return sessaoService.Get();
    }   
    
    
    @RequestMapping(value = "/sessao", method =  RequestMethod.POST)
    public Sessao Post(@Validated @RequestBody Sessao sessao)
    {
        return sessaoService.Post(sessao);
    }

    @RequestMapping(value = "/sessao/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Sessao> Put(@PathVariable(value = "id") int id, @Validated @RequestBody Sessao newSessao)
    {
        return sessaoService.Put(id, newSessao);
    }

    @RequestMapping(value = "/sessao/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") int id)
    {
        return sessaoService.Delete(id);
    }

}
