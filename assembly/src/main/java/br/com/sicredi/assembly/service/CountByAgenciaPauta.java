package br.com.sicredi.assembly.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.sicredi.assembly.validation.ValidaSessao;


@RestController
@Service
public class CountByAgenciaPauta  {
	
	/**
	 * 
	 */
	
	@PersistenceContext
    private EntityManager em;
	
    public String contador(ResultVotacao classeteste, String option) {
    	   		
    	String sql = " select count(*) as totalSim from Votacao v where v.agencia = '" + classeteste.getAgencia()  + "' and v.idPauta = " + classeteste.getIdPauta() + " and ( v.voto = '" + option.toUpperCase() + "')";
    	
    	Object result = em.createQuery(sql).getSingleResult(); 	
    	
    	
		return result.toString();
    	
    }
    

   
    public Object resultadoSim( @RequestBody ResultVotacao classeteste )  {
    		   	
    	return contador(classeteste, "S");   
        
    } 
    
    
    public Object resultadoNao( @RequestBody ResultVotacao classeteste )  {
    	  	
    	return contador(classeteste, "N");	
    	       
    } 
    
    @RequestMapping(value = "/contador", method = RequestMethod.GET)
    public ResultVotacao resultadoCompleto( @RequestBody ResultVotacao resultVotacao )  {
	  	     	
    	Integer result = Integer.parseInt(contador(resultVotacao, "S"));
    	
    	ResultVotacao classeResult = new ResultVotacao(resultVotacao.getAgencia(), resultVotacao.getIdPauta(), result, 0);
    		  	
    	result = Integer.parseInt(contador(resultVotacao, "N"));
    	
    	classeResult.setTotalNao(result);
    	  	
    	return classeResult;
    	       
    } 

    
}
