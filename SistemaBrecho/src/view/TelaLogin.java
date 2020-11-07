package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.LoginDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsurio;
	private JPasswordField pwdSenha;

	
	public TelaLogin() {
		
		getContentPane().setBackground(SystemColor.textHighlight);
		setBounds(100, 100, 754, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(187, 125, 336, 257);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/senhaUsuario.png")));
		lblNewLabel.setBounds(51, 109, 91, 64);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/images/userLogin.png")));
		lblNewLabel_1.setBounds(51, 22, 91, 64);
		panel.add(lblNewLabel_1);
		
		txtUsurio = new JTextField();
		txtUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtUsurio.setBounds(144, 52, 119, 34);
		panel.add(txtUsurio);
		txtUsurio.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pwdSenha.setBounds(144, 125, 119, 34);
		panel.add(pwdSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//deixa a tela de login invisivel e cria uma tela de menu
				String usuario = "";
				usuario = txtUsurio.getText();
				
				String senha = "";
				senha = new String(pwdSenha.getPassword());
				
				LoginDAO login = new LoginDAO(usuario,senha );
				
				if (login.getLogou()) {
					setVisible(false);
					new TelaMenu().setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Login ou senha incorretos!");
				}
				
			}
		});
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(0, 0, 139));
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEntrar.setBounds(123, 198, 97, 34);
		panel.add(btnEntrar);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUsurio.setForeground(new Color(255, 255, 255));
		lblUsurio.setBounds(144, 32, 76, 13);
		panel.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setBounds(144, 109, 76, 13);
		panel.add(lblSenha);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 139));
		panel_1.setBounds(0, 0, 761, 84);
		getContentPane().add(panel_1);
		
		JLabel lblSbtsoft = new JLabel("SdbSoft");
		lblSbtsoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblSbtsoft.setForeground(Color.WHITE);
		lblSbtsoft.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSbtsoft.setBounds(134, 10, 483, 49);
		panel_1.add(lblSbtsoft);
		setLocationRelativeTo(null);
		setResizable(false);
		
		focarTxt(txtUsurio);
		getRootPane().setDefaultButton(btnEntrar); //entra com o botao enter
	}
	
	public void focarTxt(JTextField txt) {
		final JTextField ftf = txt;
		javax.swing.SwingUtilities.invokeLater(new Runnable() { 
			public void run() { 
				ftf.requestFocusInWindow(); 
			} });
	}
}
