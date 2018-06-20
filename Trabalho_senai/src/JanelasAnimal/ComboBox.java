package JanelasAnimal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import JanelasComtabil.NovaVenda;
import banco.Conexao;



public class ComboBox extends CadastrarAnimais{
		
	public static void comboBoxEspecie() {
		ResultSet dados1=null;
		String sql = "SELECT (nome_es) FROM especie";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			dados1 = stmt.executeQuery();
			stmt.execute();
			stmt.close();

			while(dados1.next()) {
					cbEspecie.addItem(dados1.getString("nome_es"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("foi nao");
		}
	}
	
	public static int pegaIdEspecie(String nomeEspecie) {
		ResultSet dados1=null;
		int id=0;
		String sql = "SELECT idespecie FROM especie where nome_es=?";
		try {
			PreparedStatement st = Conexao.getConexao().prepareStatement(sql);
			st.setString(1, nomeEspecie);
			dados1 = st.executeQuery();
			st.execute();
			st.close();
			if(dados1.next()) {
				id = dados1.getInt("idespecie");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("foi nao");
		}
		return id;
	}
	
	public static void comboBoxRaca(int idEspecie) {
		ResultSet dados1=null;
		String sql = "SELECT * FROM raca where id_especie = ?";
		try {
			PreparedStatement st = Conexao.getConexao().prepareStatement(sql);
			st.setInt(1, idEspecie);
			dados1 = st.executeQuery();
			st.execute();
			st.close();
			while(dados1.next()) {
				  cbRaca.addItem(dados1.getString("nome_ra"));
				}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("foi nao");
		}
	}
	
	public static int pegaIdRaca(String raca) {
		ResultSet dados1=null;
		int id = 0;
		String sql = "SELECT (idraca) FROM raca where nome_ra = ?";
		try {
			PreparedStatement st = Conexao.getConexao().prepareStatement(sql);
			st.setString(1, raca);
			dados1 = st.executeQuery();
			st.execute();
			st.close();
			if(dados1.next()) {
				 id = dados1.getInt("idraca");
				}
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
			System.out.println("foi nao");
		}
		return id;
	}
}
