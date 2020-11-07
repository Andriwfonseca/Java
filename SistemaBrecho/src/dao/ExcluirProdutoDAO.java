package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.Produto;

public class ExcluirProdutoDAO {
	
	public ExcluirProdutoDAO(int id) {
		
		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "delete from produtos where id = "+ id;

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.execute();

			conn.FecharConexao();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao excluir produto! " + e);
			
		}
	}

}
