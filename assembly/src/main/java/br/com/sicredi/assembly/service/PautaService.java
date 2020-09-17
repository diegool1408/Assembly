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

import br.com.sicredi.assembly.entity.Pauta;
import br.com.sicredi.assembly.repository.PautaRepository;

@Service
public class PautaService {
	
    @Autowired
    private PautaRepository _pautaRepository;
    
    public List<Pauta> Get() {
        return _pautaRepository.findAll();
    }
    
    public ResponseEntity<Pauta> GetById(long id)
    {
        Optional<Pauta> pauta = _pautaRepository.findById(id);
        if(pauta.isPresent())
            return new ResponseEntity<Pauta>(pauta.get(), HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    public Pauta Post(Pauta pauta)
    {
        return _pautaRepository.save(pauta);
    }

    public ResponseEntity<Pauta> Put(long id, Pauta newPauta)
    {
        Optional<Pauta> oldPauta = _pautaRepository.findById(id);
        if(oldPauta.isPresent()){
            Pauta pauta = oldPauta.get();
            pauta.setDescricao(newPauta.getDescricao());
            _pautaRepository.save(pauta);
            return new ResponseEntity<Pauta>(pauta, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> Delete(long id)
    {
        Optional<Pauta> pauta = _pautaRepository.findById(id);
        if(pauta.isPresent()){
        	_pautaRepository.delete(pauta.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
