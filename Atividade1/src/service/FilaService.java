package service;

import java.io.IOException;
import java.util.ArrayList;

import dao.FilaDAO;
import model.Fila;

public class FilaService {
	FilaDAO dao = new FilaDAO();
	
	public ArrayList<Fila> listarVoluntarios() throws IOException {
		return dao.listarFila();
	}

}
