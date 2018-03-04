package model;

import java.sql.Date;

public class Chamado {
	private int idChamado;
	private String descricao;
	private String status;
	private Date dataAbertura;
	private Date dataFechamento;
	private int idFila;
	
	public int getIdChamado() {
		return idChamado;
	}
	public void setIdChamado(int idChamado) {
		this.idChamado = idChamado;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(Date dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public Date getDataFechamento() {
		return dataFechamento;
	}
	public void setDataFechamento(Date dataFechamento) {
		this.dataFechamento = dataFechamento;
	}
	public int getIdFila() {
		return idFila;
	}
	public void setIdFila(int idFila) {
		this.idFila = idFila;
	}
	
}
