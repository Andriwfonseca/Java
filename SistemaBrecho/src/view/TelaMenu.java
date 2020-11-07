package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TelaMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaMenu() {
		
		getContentPane().setBackground(SystemColor.textHighlight);
		setBounds(100, 100, 754, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 139));
		panel.setBounds(0, 0, 761, 84);
		this.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblSbtsoft = new JLabel("SdbSoft");
		lblSbtsoft.setForeground(Color.WHITE);
		lblSbtsoft.setFont(new Font("Tahoma", Font.PLAIN, 36));
		lblSbtsoft.setHorizontalAlignment(SwingConstants.CENTER);
		lblSbtsoft.setBounds(134, 10, 483, 49);
		panel.add(lblSbtsoft);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 105, 720, 293);
		this.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCadastrarProduto = new JButton("Cadastrar produto");
		btnCadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//deixa tela menu invisivel e abre a tela de cadastro de produto
				setVisible(false);
				new TelaCadastroProduto().setVisible(true);
			}
		});
		btnCadastrarProduto.setForeground(SystemColor.text);
		btnCadastrarProduto.setBackground(SystemColor.textInactiveText);
		btnCadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarProduto.setBounds(112, 26, 198, 46);
		panel_1.add(btnCadastrarProduto);
		
		JButton btnCadastrarCliente = new JButton("Cadastrar cliente");
		btnCadastrarCliente.setForeground(SystemColor.text);
		btnCadastrarCliente.setBackground(SystemColor.textInactiveText);
		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//abre tela cadastro cliente
				setVisible(false);
				new TelaCadastroCliente().setVisible(true);
			}
		});
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarCliente.setBounds(112, 125, 198, 46);
		panel_1.add(btnCadastrarCliente);
		
		JButton btnBuscarProduto = new JButton("Buscar produto");
		btnBuscarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaBuscarProduto().setVisible(true);
			}
		});
		btnBuscarProduto.setForeground(SystemColor.text);
		btnBuscarProduto.setBackground(SystemColor.textInactiveText);
		btnBuscarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarProduto.setBounds(112, 218, 198, 46);
		panel_1.add(btnBuscarProduto);
		
		JButton btnBuscarCliente = new JButton("Buscar cliente");
		btnBuscarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaBuscarCliente().setVisible(true);
				setVisible(false);
			}
		});
		btnBuscarCliente.setForeground(SystemColor.text);
		btnBuscarCliente.setBackground(SystemColor.textInactiveText);
		btnBuscarCliente.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBuscarCliente.setBounds(467, 26, 198, 46);
		panel_1.add(btnBuscarCliente);
		
		JButton btnCarrinhoDeCompras = new JButton("Carrinho de compras");
		btnCarrinhoDeCompras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaCarrinhoDeCompras().setVisible(true);
			}
		});
		btnCarrinhoDeCompras.setForeground(SystemColor.text);
		btnCarrinhoDeCompras.setBackground(SystemColor.textInactiveText);
		btnCarrinhoDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCarrinhoDeCompras.setBounds(467, 125, 198, 46);
		panel_1.add(btnCarrinhoDeCompras);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/shopping-basket-add256_24909.png")));
		lblNewLabel.setBounds(32, 10, 95, 75);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/addUsuario.png")));
		label.setBounds(42, 95, 73, 81);
		panel_1.add(label);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//sair
				System.exit(0);
			}
		});
		btnSair.setForeground(SystemColor.text);
		btnSair.setBackground(SystemColor.textInactiveText);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSair.setBounds(467, 218, 198, 46);
		panel_1.add(btnSair);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/checklist256_24933.png")));
		label_1.setBounds(42, 202, 73, 81);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/listarUsuarios.png")));
		label_2.setBounds(394, 0, 73, 81);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/US-dollar256_24937.png")));
		label_3.setBounds(394, 103, 73, 81);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(TelaMenu.class.getResource("/images/logout256_24927.png")));
		label_4.setBounds(384, 194, 73, 81);
		panel_1.add(label_4);
	}

}
