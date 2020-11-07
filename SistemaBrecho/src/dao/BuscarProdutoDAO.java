package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Produto;

public class BuscarProdutoDAO {



	public List<Produto> listarProdutos(){

		List<Produto> lista = new ArrayList<>();

		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "select id,genero,cor,tamanho,preco,quantidade,tipo from produtos";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				Produto produto = new Produto();
				produto.setCodigo(rs.getInt("id"));
				produto.setTipo(rs.getString("tipo"));				
				produto.setCor(rs.getString("cor"));
				produto.setTamanho(rs.getInt("tamanho"));
				produto.setPreco(rs.getDouble("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setGenero(rs.getString("genero"));

				lista.add(produto);

			}
			conn.FecharConexao();

			return lista;


		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao buscar produto! " + e);

			return null;
		}


	}
}
