package crud;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.Funcionario;
import banco.Conexao;

public class CrudFuncionarios {
	
	Conexao con = new Conexao();
	
	public boolean addFun(Funcionario funcionario) {
		String sql = "INSERT INTO funcionarios ( nome_fun, data_nasc, cpf_fun, rg_fun, fone_fun, email_fun,"
				+ " cargo, salario, descricao, img, idfazenda, sexo) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getDataDeNascimento());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getRg());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.getEmail());
			stmt.setString(7, funcionario.getCargo());
			stmt.setDouble(8, funcionario.getSalario());
			stmt.setString(9, funcionario.getDescricao());
			stmt.setBytes(10, funcionario.getImg());
			stmt.setInt(11, funcionario.getIdFazenda());
			stmt.setString(12, funcionario.getSexo());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("erro ao add");
			return false;
		}
	}
		
	public boolean updFun(Funcionario funcionario) {
		String sql = "UPDATE funcionarios SET nome_fun=?, data_nasc=?, cpf_fun=?, rg_fun=?, "
				+ "fone_fun=?, email_fun=?, cargo=?, salario=?, descricao=?, img=?, idfazenda=?, sexo=?"
				+ " where idfuncionarios=?";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getDataDeNascimento());
			stmt.setString(3, funcionario.getCpf());
			stmt.setString(4, funcionario.getRg());
			stmt.setString(5, funcionario.getTelefone());
			stmt.setString(6, funcionario.getEmail());
			stmt.setString(7, funcionario.getCargo());
			stmt.setDouble(8, funcionario.getSalario());
			stmt.setString(9, funcionario.getDescricao());
			stmt.setBytes(10, funcionario.getImg());
			stmt.setInt(11, funcionario.getIdFazenda());
			stmt.setString(12, funcionario.getSexo());
			stmt.setInt(13, funcionario.getIdFuncionario());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
		
	public ResultSet selecionaFuncionario(Funcionario funcionario) {
		ResultSet tabela = null;
		String sql = "SELECT * FROM funcionarios where idfazenda=?";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setInt(1, funcionario.getIdFazenda());
			tabela = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return tabela=null;
		}
		return tabela;
	}
	
	public ResultSet procurafuncionario(String letra, Funcionario funcionario) {
		ResultSet tabela = null;
		String sql = "SELECT*FROM funcionarios WHERE  nome_fun LIKE ? and idfazenda=?";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setString(1,"%"+letra+"%");
			stmt.setInt(2, funcionario.getIdFazenda());
			tabela = stmt.executeQuery();
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("ERRO");
		}
			return tabela;
	}
		
	public boolean removeFun(Funcionario funcionario) {
		String sql = "DELETE FROM funcionarios WHERE idfuncionarios=?";
		try {
			PreparedStatement stmt = Conexao.getConexao().prepareStatement(sql);
			stmt.setInt(1, funcionario.getIdFuncionario());
			stmt.execute();
			stmt.close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
