package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

public class LoginDAO {

	private boolean logou = false;
	
	public LoginDAO(String login,String senha) {
		ConnectionFactory  conn = new ConnectionFactory();

		try {
			conn.ConnectionFactory();
			String resultado = "";
			String query = "select login,senha from usuarios where login = ? and senha = ?";

			PreparedStatement preparedStatement = conn.connection.prepareStatement(query);
			preparedStatement.setString(1,login);
			preparedStatement.setString(2,senha);
			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				logou = true;
			}
			
			conn.FecharConexao();

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Erro ao logar no sistema! " + e);
			
		}
	}
	
	public boolean getLogou() {
		return logou;
	}
}
