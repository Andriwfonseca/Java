package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import bd.ConexaoMysql;



public class Main {

	public static void main(String[] args) {
		
		
		String[] opcoes = {"Buscar dados","Inserir dados","Apagar dados","Alterar dados"};
		boolean menu = true;
		//buscar();
		//buscar(50,"adiel");
		int escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, opcoes, opcoes[0]);


		while(menu) {

			if (escolha == 0) {
				buscarDados();
			}else if (escolha == 1) {

				String nome = JOptionPane.showInputDialog("Insira o nome");
				String email = JOptionPane.showInputDialog("Insira um email");
				String senha = JOptionPane.showInputDialog("Insira uma senha");

				inserirDados(nome, email, senha);
			}else if (escolha == 2) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Qual é a id que você deseja apagar?"));
				apagarDados(id);
			}else if (escolha == -1) {
				menu = false;
			}else if (escolha == 3) {
				int id = Integer.parseInt(JOptionPane.showInputDialog("Qual é a id que você deseja alterar?"));
				alterarDados(id);
			}

			if (escolha != -1 ) {
				escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.YES_NO_CANCEL_OPTION, null, opcoes, opcoes[0]);
			}

		}



	}

	public static void buscarDados() {

		try {
			ConexaoMysql conn = new ConexaoMysql();
			conn.conectarMySQL();
			String resultado = "";			
			String query = "select * from usuarios";
			ResultSet rs = conn.execute(query);
			while (rs.next()) {
				resultado += String.format("%d - %s%n", rs.getInt("id"), rs.getString("nome"));
			}
			conn.FecharConexao();

			JOptionPane.showMessageDialog(null, resultado);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void buscar(int id) {

		try {
			ConexaoMysql conn = new ConexaoMysql();
			conn.conectarMySQL();
			String resultado = "";
			String query = "select * from usuarios WHERE id > ?";
			int user = 2;
			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setInt(1, user);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				resultado += String.format("%d - %s%n", rs.getInt("id"), rs.getString("apelido"));
			}

			conn.FecharConexao();
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}


	}
	public static void buscar(String email) {
		try {
			ConexaoMysql  conn = new ConexaoMysql();
			conn.conectarMySQL();
			String resultado = "";
			String query = "select * from usuarios WHERE email LIKE ?";


			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1, "%"+email+"%");
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				resultado += String.format("%d - %s%n", rs.getString("nome"), rs.getString("email"));
			}
			conn.FecharConexao();

			System.out.println(resultado);
		}catch (Exception e) {
			// TODO: handle exception
		}

	}
	public static void inserirDados(String nome,String email,String senha) {
		try {
			ConexaoMysql  conn = new ConexaoMysql();
			conn.conectarMySQL();
			String resultado = "";
			String query = "INSERT INTO usuarios(nome, senha, email) VALUES(?,?,?)";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1, nome);
			preparedStatement.setString(2, senha);
			preparedStatement.setString(3, email);

			int count = preparedStatement.executeUpdate(); 

			System.out.println(count);

			conn.FecharConexao();

			System.out.println(resultado);




		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public static void apagarDados(int id) {

		try {
			ConexaoMysql conn = new ConexaoMysql();
			conn.conectarMySQL();

			String query = "delete from usuarios WHERE id ="+id;

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Registro apagado com sucesso!");


			conn.FecharConexao();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao tentar apagar registro!");
		}


	}
	public static void alterarDados(int id) {
		
		try {
			ConexaoMysql conn = new ConexaoMysql();
			conn.conectarMySQL();
			String nomeNovo = JOptionPane.showInputDialog("Qual será o novo nome para o id "+id+"?");
			String apelidoNovo = JOptionPane.showInputDialog("Qual será o novo email para o id "+id+"?");

			String query = "update usuarios set nome = ?, email = ? where id ="+id;

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1, nomeNovo);
			preparedStatement.setString(2, apelidoNovo);
			preparedStatement.execute();
			JOptionPane.showMessageDialog(null, "Registro alterado com sucesso!");


			conn.FecharConexao();
		}catch(Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Erro ao tentar alterar registro!");
		}

	}
}	