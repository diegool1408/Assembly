package br.com.sicredi.assembly.service;

public class ResultVotacao {
	
	private String agencia;
	private int idPauta;

	//private int idSessao;
	
	private int totalSim;
	private int totalNao;
	
	
	public ResultVotacao( String agencia, int idPauta, int totalSim, int totalNao ) {
		
		super();
		this.agencia = agencia;
		this.idPauta = idPauta;
		//this.idSessao = idSessao;
		this.totalSim = totalSim;
		this.totalNao = totalNao;
		
	}
	
	/*public int getIdSessao() {
		return idSessao;
	}

	public void setIdSessao(int idSessao) {
		this.idSessao = idSessao;
	}*/
	
	public int getTotalSim() {
		return totalSim;
	}
	public void setTotalSim(int totalSim) {
		this.totalSim = totalSim;
	}
	public int getTotalNao() {
		return totalNao;
	}
	public void setTotalNao(int totalNao) {
		this.totalNao = totalNao;
	}

	public String getAgencia() {
		return agencia;
	}
	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}
	public int getIdPauta() {
		return idPauta;
	}
	public void setIdPauta(int idPauta) {
		this.idPauta = idPauta;
	}		

}
