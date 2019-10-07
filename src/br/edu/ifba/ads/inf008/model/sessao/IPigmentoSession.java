package br.edu.ifba.ads.inf008.model.sessao;

import java.sql.SQLException;

import br.edu.ifba.ads.inf008.model.negocios.Pigmento;
import br.edu.ifba.ads.inf008.model.negocios.PigmentoRGB;

public interface IPigmentoSession {
	
	public PigmentoRGB getPigmentoRGB(String hexa);
	public Pigmento menor_distancia(int quantidade, PigmentoRGB pigmentoRGB) throws Exception;
	public void atualizarEstoque(int quantidade, String id) throws SQLException;

}
