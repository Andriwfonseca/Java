package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;

public class AdicionaProdutoCarrinhoDAO {


	
	public List<Produto> adicionarProdutos(int id,int quantidade){
		
		List<Produto> lista = new ArrayList<>();
		
		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "select id,tipo,preco,quantidade from produtos where id = ? ";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				double valor = rs.getDouble("preco");
				
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("id"));
				produto.setTipo(rs.getString("tipo"));
				produto.setQuantidade(quantidade);
				produto.setPreco(valor * quantidade);
				
				
				lista.add(produto);
			}
			conn.FecharConexao();
			
			return lista;
			

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao adicionar produto! " + e);
			
			return null;
		}
		
		
		
	}
}
