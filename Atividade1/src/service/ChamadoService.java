package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.ChamadoDAO;
import model.Chamado;

public class ChamadoService {
	ChamadoDAO dao = new ChamadoDAO();
	
	public int abrirChamado(Chamado chamado) {
		return dao.criar(chamado);
	}
	public void consultarChamado(Chamado chamado){
		dao.atualizar(chamado);
	}
	
	public Chamado carregarChamado(int id){
		return dao.carregar(id);
	}
	
	public void fecharChamado(int id){
		dao.excluir(id);
	}
	
	public ArrayList<Chamado> listarVoluntarios() throws IOException {
		return dao.listarChamado();
	}
}
