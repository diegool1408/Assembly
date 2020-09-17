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

import br.com.sicredi.assembly.entity.Associados;
import br.com.sicredi.assembly.repository.AssociadosRepository;

@Service
public class AssociadosService {
	
	@Autowired
	private AssociadosRepository _associadosRepository;
	    
	public List<Associados> Get() {
	    return _associadosRepository.findAll();
	}
	 
	    
	public ResponseEntity<Associados> GetById(long id)
	{
	    Optional<Associados> associados = _associadosRepository.findById(id);
	    if(associados.isPresent())
	        return new ResponseEntity<Associados>(associados.get(), HttpStatus.OK);
	    else
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	    
	    
	public Associados Post(Associados associados)
	{
	    return _associadosRepository.save(associados);
	}

	public ResponseEntity<Associados> Put( long id, Associados newAssociado)
	{
	    Optional<Associados> oldAssociado = _associadosRepository.findById(id);
	    if(oldAssociado.isPresent()){
	        Associados associado = oldAssociado.get();
	        associado.setAgencia(newAssociado.getAgencia());
	        associado.setConta(newAssociado.getConta());
	        associado.setCpf(newAssociado.getCpf());
	        associado.setEndereco(newAssociado.getEndereco());
	        associado.setNome(newAssociado.getNome());
	        _associadosRepository.save(associado);
	        return new ResponseEntity<Associados>(associado, HttpStatus.OK);
	    }
	    else
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	public ResponseEntity<Object> Delete(long id)
	{
	    Optional<Associados> associado = _associadosRepository.findById(id);
	    if(associado.isPresent()){
	     	_associadosRepository.delete(associado.get());
	        return new ResponseEntity<>(HttpStatus.OK);
	     }
	     else
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
}
