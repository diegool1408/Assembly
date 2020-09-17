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

import br.com.sicredi.assembly.entity.Associados;
import br.com.sicredi.assembly.repository.AssociadosRepository;
import br.com.sicredi.assembly.service.AssociadosService;


@RestController
public class AssociadosController {
	
	@Autowired
	private AssociadosService associadosService; 
	
	@RequestMapping(value = "/associados", method = RequestMethod.GET)
	public List<Associados> Get() {
		
		return associadosService.Get();
	}
	
	@RequestMapping(value = "/associados/{id}", method = RequestMethod.GET)
	public ResponseEntity<Associados> GetById(@PathVariable(value = "id") long id)
	{
	    return associadosService.GetById(id);
		
	}
	
	@RequestMapping(value = "/associados", method =  RequestMethod.POST)
	public Associados Post(@Validated @RequestBody Associados associados)
	{
	    return associadosService.Post(associados);
	}
	
	@RequestMapping(value = "/associados/{id}", method =  RequestMethod.PUT)
	public ResponseEntity<Associados> Put(@PathVariable(value = "id") long id, @Validated @RequestBody Associados newAssociado)
	{
	    return associadosService.Put(id, newAssociado);
	    
	}
	
	@RequestMapping(value = "/associados/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id)
	{
	    return associadosService.Delete(id);
	}
	
}
