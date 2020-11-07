package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


import dao.AdicionarProdutoDAO;
import dao.BuscarProdutoDAO;
import dao.EditarProdutoDAO;
import model.Produto;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.DefaultComboBoxModel;

public class TelaCadastroProduto extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtCodigoProduto;
	private JTextField txtTamanhoProduto;
	private JTextField txtPreco;
	private JTextField txtQuantidade;
	private JComboBox comboBoxCor;
	JRadioButton rdbtnMasculino;
	JRadioButton rdbtnFeminino;
	JComboBox comboBoxTipo;
	private boolean editando;
	private int codigo;



	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	//Construtor normal
	public TelaCadastroProduto() {
		iniciarComponentes();
		editando = false;
		limparFormulario(buttonGroup, comboBoxCor, txtTamanhoProduto, txtPreco, txtQuantidade);

	}

	//Construtor da edição do produto
	public TelaCadastroProduto(int id) {
		iniciarComponentes();
		editando = true;
		BuscarProdutoDAO buscarProduto = new BuscarProdutoDAO();
		List<Produto> lista = buscarProduto.listarProdutos();

		//preenche os dados recuperado pela id selecionada na tela buscar produtos
		for(Produto produto:lista) {
			if (produto.getCodigo() == id) {


				if (produto.getGenero().equals("Masculino")) {
					rdbtnMasculino.setSelected(true);
				}else if (produto.getGenero().equals("Feminino")) {
					rdbtnFeminino.setSelected(true);
				}
				codigo = id;
				txtCodigoProduto.setText(Integer.toString(produto.getCodigo()));
				txtPreco.setText(Double.toString(produto.getPreco()));
				txtQuantidade.setText(Integer.toString(produto.getQuantidade()));
				txtTamanhoProduto.setText(Integer.toString(produto.getTamanho()));
				comboBoxCor.setSelectedItem(produto.getCor());
				comboBoxTipo.setSelectedItem(produto.getTipo());
			}
		}




	}
	public void iniciarComponentes() {
		getContentPane().setBackground(SystemColor.textHighlight);
		setBounds(100, 100, 754, 505);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

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

		JPanel panel = new JPanel();
		panel.setBackground(new Color(245, 245, 245));
		panel.setBounds(44, 124, 661, 219);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo.setBounds(10, 10, 62, 26);
		panel.add(lblCdigo);

		JLabel lblGnero = new JLabel("G\u00EAnero:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGnero.setBounds(10, 51, 62, 13);
		panel.add(lblGnero);

		rdbtnMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnMasculino.setBounds(96, 48, 87, 21);
		panel.add(rdbtnMasculino);

		rdbtnFeminino = new JRadioButton("Feminino");
		buttonGroup.add(rdbtnFeminino);
		rdbtnFeminino.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtnFeminino.setBounds(180, 47, 87, 21);
		panel.add(rdbtnFeminino);

		JLabel lblCdigo_1 = new JLabel("Tamanho:");
		lblCdigo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1.setBounds(10, 73, 80, 26);
		panel.add(lblCdigo_1);

		JLabel lblCdigo_1_1 = new JLabel("Cor:");
		lblCdigo_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_1.setBounds(273, 44, 42, 26);
		panel.add(lblCdigo_1_1);

		comboBoxCor = new JComboBox();
		comboBoxCor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxCor.setModel(new DefaultComboBoxModel(new String[] {"Branco", "Rosa", "Preto", "Azul", "Verde", "Amarelo", "Roxo", "Marrom", "Cinza", "Laranja", "Violeta", "Outros"}));
		comboBoxCor.setBounds(305, 47, 80, 21);
		panel.add(comboBoxCor);

		txtCodigoProduto = new JTextField();
		txtCodigoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoProduto.setBounds(96, 17, 96, 19);
		panel.add(txtCodigoProduto);
		txtCodigoProduto.setColumns(10);
		txtCodigoProduto.setEditable(false);

		txtTamanhoProduto = new JTextField();
		txtTamanhoProduto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtTamanhoProduto.setColumns(10);
		txtTamanhoProduto.setBounds(96, 80, 96, 19);
		panel.add(txtTamanhoProduto);

		JLabel lblCdigo_1_2 = new JLabel("Pre\u00E7o:");
		lblCdigo_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_2.setBounds(10, 109, 80, 26);
		panel.add(lblCdigo_1_2);

		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtPreco.setColumns(10);
		txtPreco.setBounds(96, 116, 96, 19);
		panel.add(txtPreco);

		JLabel lblCdigo_1_3 = new JLabel("Quantidade:");
		lblCdigo_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_3.setBounds(10, 145, 80, 26);
		panel.add(lblCdigo_1_3);

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(96, 152, 96, 19);
		panel.add(txtQuantidade);

		JLabel lblCdigo_1_2_1 = new JLabel("R$");
		lblCdigo_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_2_1.setBounds(76, 109, 50, 26);
		panel.add(lblCdigo_1_2_1);

		comboBoxTipo = new JComboBox();
		comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Blusa", "Cal\u00E7a", "Saia", "Cal\u00E7ado", "Vestido"}));
		comboBoxTipo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBoxTipo.setBounds(243, 13, 80, 21);
		panel.add(comboBoxTipo);

		JLabel lblCdigo_1_1_1 = new JLabel("Tipo:");
		lblCdigo_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_1_1.setBounds(203, 10, 42, 26);
		panel.add(lblCdigo_1_1_1);


		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE PRODUTOS");
		lblCadastroDeProdutos.setForeground(new Color(255, 255, 255));
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDeProdutos.setBounds(219, 81, 301, 44);
		getContentPane().add(lblCadastroDeProdutos);

		JButton btnSalvar = new JButton("");
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chama o metodo do botaoSalvar
				botaoSalvar();

			}
		});
		btnSalvar.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/images/disquete.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(203, 380, 85, 72);
		getContentPane().add(btnSalvar);

		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				limparFormulario(buttonGroup, comboBoxCor, txtTamanhoProduto, txtPreco, txtQuantidade);
			}
		});
		btnLimpar.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/images/vassoura.png")));
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(353, 380, 85, 72);
		getContentPane().add(btnLimpar);

		JButton btnVoltar = new JButton("");
		btnVoltar.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/images/voltar-seta.png")));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaMenu().setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVoltar.setBounds(493, 380, 85, 72);
		getContentPane().add(btnVoltar);

		JLabel lblSalvar = new JLabel("SALVAR");
		lblSalvar.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar.setForeground(Color.WHITE);
		lblSalvar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalvar.setBounds(203, 353, 85, 26);
		getContentPane().add(lblSalvar);

		JLabel lblSalvar_1 = new JLabel("LIMPAR");
		lblSalvar_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblSalvar_1.setForeground(Color.WHITE);
		lblSalvar_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSalvar_1.setBounds(353, 353, 85, 26);
		getContentPane().add(lblSalvar_1);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVoltar.setBounds(493, 353, 85, 26);
		getContentPane().add(lblVoltar);
		setLocationRelativeTo(null);
		setResizable(false);
		getRootPane().setDefaultButton(btnSalvar);
	}

	public void setEditando(boolean editando) {
		this.editando = editando;
	}

	public void limparFormulario(ButtonGroup buttonGroup,JComboBox comboBoxCor, JTextField txtTamanhoProduto,JTextField txtPreco,JTextField txtQuantidade) {

		buttonGroup.clearSelection();
		comboBoxCor.setSelectedIndex(0);
		txtTamanhoProduto.setText("");
		txtPreco.setText("");
		txtQuantidade.setText("");
		txtCodigoProduto.setText(Integer.toString(pegarProximaId()));



	}

	public int pegarProximaId() {
		BuscarProdutoDAO buscarProduto = new BuscarProdutoDAO();

		
		List<Produto> lista = buscarProduto.listarProdutos();
		Produto prod = new Produto();
		prod = lista.get(lista.size() -1); //recupera o ultimo valor da lista
	
		int id = prod.getCodigo() +1;	//pega o codigo do ultimo valor da lista e acrescenta 1, porq sera o proximo id
	
		return id;
	}
	
	private void botaoSalvar() {
		// TODO Auto-generated method stub
		boolean podeSalvar = true;
		String genero = "";

		if (rdbtnFeminino.isSelected()) {
			genero = "Feminino";
		}else if(rdbtnMasculino.isSelected()) {
			genero = "Masculino";
		}else {
			podeSalvar = false;
			JOptionPane.showMessageDialog(null, "Você não selecionou um genêro!");
		}
		String cor = comboBoxCor.getSelectedItem().toString();
		String tipo = comboBoxTipo.getSelectedItem().toString();
		
		int tamanho = 0;
		if (podeSalvar)
		try {
			tamanho = Integer.parseInt(txtTamanhoProduto.getText());
		} catch (Exception e2) {
			podeSalvar = false;
			JOptionPane.showMessageDialog(null, "Por favor, insira um tamanho válido!");
		}
		
		double preco = 0;
		if (podeSalvar)
		try {
			preco = Double.parseDouble(txtPreco.getText());
		} catch (Exception e2) {
			podeSalvar = false;
			JOptionPane.showMessageDialog(null, "Por favor, insira um preço válido!");
		}
		int quantidade = 0;
		if (podeSalvar)
		try {
			quantidade = Integer.parseInt(txtQuantidade.getText());
		} catch (Exception e2) {
			podeSalvar = false;
			JOptionPane.showMessageDialog(null, "Por favor, insira uma quantidade válida!");
		}
	

		if(!editando && podeSalvar) {

			AdicionarProdutoDAO add = new AdicionarProdutoDAO(genero,cor,tamanho,preco,quantidade,tipo);		
				
		}else if (editando && podeSalvar){

			EditarProdutoDAO editar = new EditarProdutoDAO(codigo,genero,cor,tamanho,preco,quantidade,tipo);
		}


		if (podeSalvar) {
			limparFormulario(buttonGroup, comboBoxCor, txtTamanhoProduto, txtPreco, txtQuantidade);
		}
			
		
	}
}
