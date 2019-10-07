package br.edu.ifba.ads.inf008.model.sessao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifba.ads.inf008.model.negocios.Pigmento;
import br.edu.ifba.ads.inf008.model.negocios.PigmentoRGB;
import br.edu.ifba.ads.inf008.model.persistencia.PigmentoDAO;

public class PigmentoSession implements IPigmentoSession {
	
	private  PigmentoDAO pigmentoDAO; 
	
	public PigmentoSession() throws ClassNotFoundException, SQLException, IOException{
		
		this.pigmentoDAO = new PigmentoDAO();
		
	}
	
	@Override
	public PigmentoRGB getPigmentoRGB(String hexa) {
		
        hexa.replaceAll("#", "");
		
		PigmentoRGB pigmentoRGB = new PigmentoRGB("ex", "example", 0, 0, Integer.valueOf(hexa.substring(0, 2), 16), Integer.valueOf(hexa.substring(2, 4), 16), Integer.valueOf(hexa.substring(4, 6), 16)); 
		
		return pigmentoRGB;
	}

	@Override
	public Pigmento menor_distancia(int quantidade, PigmentoRGB pigmentoRGB) throws  SQLException, Exception{
		
		ArrayList<Pigmento> pigmentos = new ArrayList<Pigmento>();
        pigmentos = this.pigmentoDAO.findByQuantidade(quantidade);
        Pigmento menor = pigmentos.get(0);
        Pigmento pig = null;
        
        for(int i = pigmentos.size() - 1; i >= 0; i--) {
        	 if(pigmentos.get(i).getDistancia(pigmentoRGB) < menor.getDistancia(pigmentoRGB)) {
        		 menor = pigmentos.get(i);
        	 }
        }
        
	    return menor;
        
	}
	 
	public void atualizarEstoque(int quantidade, String id) throws SQLException{
		this.pigmentoDAO.updateEstoque(quantidade, id);
	} 
	
 
	
	
	

}
