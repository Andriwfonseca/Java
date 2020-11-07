package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Cliente;
import model.Produto;

public class BuscarClienteDAO {



	public List<Cliente> listarClientes(){

		List<Cliente> lista = new ArrayList<>();

		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "select id,nome,email,cpf,rg,dataNascimento,rua,bairro,numero from clientes";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				
				Cliente cliente = new Cliente();
				cliente.setCodigo(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setEmail(rs.getString("email"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setRg(rs.getString("rg"));
				cliente.setDataNascimento(rs.getString("dataNascimento"));
				cliente.setRua(rs.getString("rua"));
				cliente.setBairro(rs.getString("bairro"));
				cliente.setNumero(rs.getInt("numero"));
				

				lista.add(cliente);

			}
			conn.FecharConexao();

			return lista;


		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao buscar cliente! " + e);

			return null;
		}


	}
}
