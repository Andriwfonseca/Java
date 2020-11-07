package dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class CadastrarClienteDAO {
	
	
	public CadastrarClienteDAO(String nome,String email,String cpf,String rg,String dataNascimento,String rua,String bairro,int numero) {
		


		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			
			String query = "INSERT INTO clientes(nome, email, cpf,rg,dataNascimento,rua,bairro,numero) VALUES(?,?,?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, email);
			preparedStatement.setString(3, cpf);
			preparedStatement.setString(4, rg);
			preparedStatement.setString(5, dataNascimento);
			preparedStatement.setString(6,rua);
			preparedStatement.setString(7,bairro);
			preparedStatement.setInt(8,numero);

			preparedStatement.executeUpdate();

			conn.FecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuario!");
			JOptionPane.showMessageDialog(null, e);
		}




	}

}
