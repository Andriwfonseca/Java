package dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class EditarClienteDAO {
	
	
	public EditarClienteDAO(int codigo,String nome,String email,String cpf,String rg,String dataNascimento,String rua, String bairro, int numero) {
		


		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "UPDATE clientes set nome = ?, email = ?, cpf = ?, rg = ?, dataNascimento = ?,rua = ? , bairro = ?, numero = ? where id = ?";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1,nome );
			preparedStatement.setString(2, email);
			preparedStatement.setString(3,cpf );
			preparedStatement.setString(4, rg);
			preparedStatement.setString(5, dataNascimento);
			preparedStatement.setString(6, rua);
			preparedStatement.setString(7, bairro);
			preparedStatement.setInt(8, numero);
			preparedStatement.setInt(9, codigo);
			
			preparedStatement.executeUpdate();

			conn.FecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao editar cliente!");
			JOptionPane.showMessageDialog(null, e);
		}




	}
	

}
