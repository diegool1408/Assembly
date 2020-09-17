package br.com.sicredi.assembly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import br.com.sicredi.assembly.entity.Pauta;
import br.com.sicredi.assembly.repository.PautaRepository;
import br.com.sicredi.assembly.service.PautaService;

@RestController
public class PautaController {
	
	@Autowired
    private PautaService pautaService;
    
    @RequestMapping(value = "/pauta", method = RequestMethod.GET)
    public List<Pauta> Get() {
        return pautaService.Get();
    }
    
    @RequestMapping(value = "/pauta/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pauta> GetById(@PathVariable(value = "id") long id)
    {
    	return pautaService.GetById(id);
    }
    
    
    @RequestMapping(value = "/pauta", method =  RequestMethod.POST)
    public Pauta Post(@Validated @RequestBody Pauta pauta)
    {
        return pautaService.Post(pauta);
    }

    @RequestMapping(value = "/pauta/{id}", method =  RequestMethod.PUT)
    public ResponseEntity<Pauta> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Pauta newPauta)
    {
    	return pautaService.Put(id, newPauta);
    }

    @RequestMapping(value = "/pauta/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
    {
    	return pautaService.Delete(id);
    }
}
