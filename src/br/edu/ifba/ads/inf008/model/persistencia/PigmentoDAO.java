package br.edu.ifba.ads.inf008.model.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.edu.ifba.ads.inf008.model.negocios.Pigmento;
import br.edu.ifba.ads.inf008.model.negocios.PigmentoCMYK;
import br.edu.ifba.ads.inf008.model.negocios.PigmentoRGB;


 // CREATE TABLE PIGMENTO( matricula varchar(6) not null, nome varchar(40) not null, estoque integer not null, preco float not null, q1 integer not null, q2 integer not null, q3 integer not null, q4 integer not null, tipo integer not null, primary key(matricula))
   

public class PigmentoDAO implements IPigmentoDAO{
	
	private static final String DRIVER = "org.hsqldb.jdbc.JDBCDriver";
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	private static final String INSERIR = "INSERT INTO PIGMENTO (matricula, nome, estoque, preco, q1, q2, q3, q4, tipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String BUSCA_ESTOQUE = "SELECT*FROM PIGMENTO WHERE estoque >= ?";
	private static final String UPDATE_ESTOQUE = "UPDATE PIGMENTO SET estoque = ? WHERE matricula = ?";
	
	public PigmentoDAO() throws SQLException, ClassNotFoundException{
		Class.forName(PigmentoDAO.DRIVER);
	};
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(PigmentoDAO.URI, PigmentoDAO.USER, PigmentoDAO.PWD);
	};

	@Override
	public void inserir(Pigmento pigmento) throws Exception {
		 PreparedStatement stm = this.getConnection().prepareStatement(PigmentoDAO.INSERIR);
		 stm.setString(1, pigmento.getId());
		 stm.setString(2, pigmento.getNome());
		 stm.setInt(3, pigmento.getQuantidade());
		 stm.setDouble(4, pigmento.getPreco());
		        if(pigmento instanceof PigmentoRGB) {
		        	PigmentoRGB pigRGB = (PigmentoRGB) pigmento;
		        	stm.setInt(5, pigRGB.getRed());
		        	stm.setInt(6, pigRGB.getGreen());
		        	stm.setInt(7, pigRGB.getBlue());
		        	stm.setInt(8, 0);
		        	stm.setInt(9, 0);

		        }else {
		        	PigmentoCMYK pigCMYK = (PigmentoCMYK) pigmento;
		        	stm.setInt(5, pigCMYK.getCyan());
		        	stm.setInt(6, pigCMYK.getMagenta());
		        	stm.setInt(7, pigCMYK.getYellow());
		        	stm.setInt(8, pigCMYK.getKey());
		        	stm.setInt(9, 1);

		        }
		 
		 stm.executeUpdate();
		 stm.close();
		        
    };

	@Override
	public ArrayList<Pigmento> findByQuantidade(int quantidade) throws SQLException {
		 
		PreparedStatement stm = this.getConnection().prepareStatement(PigmentoDAO.BUSCA_ESTOQUE);
		stm.setInt(1, quantidade);
		stm.execute();
		ResultSet result = stm.executeQuery();
		ArrayList<Pigmento> pigmentos = new ArrayList<Pigmento>();
		
		Pigmento pigmento = null;
		
		while(result.next()) {
			
			String id = result.getString("matricula");
			String nome = result.getString("nome");
			int estoque = result.getInt("estoque");
			float preco = result.getFloat("preco");
			int q1 = result.getInt("q1");
			int q2 = result.getInt("q2");
			int q3 = result.getInt("q3");
			int q4 = result.getInt("q4");
			int tipo = result.getInt("tipo");

			if(tipo == 1) {
				pigmento = new PigmentoRGB(id, nome, estoque, preco, q1, q2, q3);
			}
			else {
				pigmento = new PigmentoCMYK(id, nome, estoque, preco, q1, q2, q3, q4);
			}
		    pigmentos.add(pigmento);
		}
		
		return pigmentos;
	};

	@Override
	public void updateEstoque(int quantidade, String id) throws SQLException{
		 
		PreparedStatement stm = this.getConnection().prepareStatement(PigmentoDAO.UPDATE_ESTOQUE);
		
		stm.setInt(1, quantidade);
		stm.setString(2, id);
		
		stm.executeUpdate();
		
	};
 

	
	
}
