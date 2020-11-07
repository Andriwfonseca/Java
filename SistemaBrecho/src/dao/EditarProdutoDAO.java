package dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class EditarProdutoDAO {
	
	
	public EditarProdutoDAO(int codigo,String genero,String cor,int tamanho,double preco,int quantidade,String tipo) {
		


		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "UPDATE produtos set tamanho = ?, genero = ?, cor = ?, preco = ?, quantidade = ?,tipo = ? where id = ?";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setInt(1, tamanho);
			preparedStatement.setString(2, genero);
			preparedStatement.setString(3, cor);
			preparedStatement.setDouble(4,preco);
			preparedStatement.setInt(5, quantidade);
			preparedStatement.setString(6, tipo);
			preparedStatement.setInt(7, codigo);


			preparedStatement.executeUpdate();

			conn.FecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao inserir produto!");
			JOptionPane.showMessageDialog(null, e);
		}




	}
	public EditarProdutoDAO(int quantidade, int codigo) {

		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "UPDATE produtos set quantidade = ? where id = ?";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setInt(1, quantidade);		
			preparedStatement.setInt(2, codigo);


			preparedStatement.executeUpdate();

			conn.FecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao inserir produto!");
			JOptionPane.showMessageDialog(null, e);
		}
	}

}
