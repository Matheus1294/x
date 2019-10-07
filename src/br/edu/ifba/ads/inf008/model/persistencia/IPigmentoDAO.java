package br.edu.ifba.ads.inf008.model.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifba.ads.inf008.model.negocios.Pigmento;

public interface IPigmentoDAO {
	
	public void inserir(Pigmento pigmento) throws Exception;
	public ArrayList<Pigmento> findByQuantidade(int quantidade) throws Exception;
	public void updateEstoque(int quantidade, String id) throws SQLException;

}
