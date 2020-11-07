package dao;

import java.sql.PreparedStatement;

import javax.swing.JOptionPane;



public class AdicionarProdutoDAO  {
	
	
	public AdicionarProdutoDAO(String genero,String cor,int tamanho,double preco,int quantidade,String tipo) {
		


		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "INSERT INTO produtos(genero, cor, tamanho,preco,quantidade,tipo) VALUES(?,?,?,?,?,?)";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1, genero);
			preparedStatement.setString(2, cor);
			preparedStatement.setInt(3, tamanho);
			preparedStatement.setDouble(4, preco);
			preparedStatement.setInt(5, quantidade);
			preparedStatement.setString(6,tipo);

			preparedStatement.executeUpdate();

			conn.FecharConexao();
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao inserir produto!");
			JOptionPane.showMessageDialog(null, e);
		}




	}


}
