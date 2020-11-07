package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import dao.BuscarProdutoDAO;
import dao.ExcluirProdutoDAO;
import listener.TelaBuscarProdutoBotaoListener;
import model.Produto;

import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaBuscarProduto extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaNome;
	
	private JButton btnPesquisar;
	private JButton btnEditar;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnExcluir;

	private JTable tabela;


	public TelaBuscarProduto() {

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
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(34, 148, 672, 214);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNome = new JLabel("Código:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 9, 60, 18);
		panel.add(lblNome);

		setTxtBuscaNome(new JTextField());
		getTxtBuscaNome().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getTxtBuscaNome().setBounds(66, 9, 275, 19);
		panel.add(getTxtBuscaNome());
		getTxtBuscaNome().setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		//botao de pesquisa dos dados
		getBtnPesquisar().addActionListener(new TelaBuscarProdutoBotaoListener(this));
		getRootPane().setDefaultButton(getBtnPesquisar()); //entra com o botao enter
			
		getBtnPesquisar().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getBtnPesquisar().setBounds(351, 8, 102, 21);
		panel.add(getBtnPesquisar());

		JList list = new JList();
		list.setBounds(88, 137, 93, -54);
		panel.add(list);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 652, 171);
		panel.add(scrollPane);

		setTabela(new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		});
		getTabela().setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo","Tipo" , "Cor", "Tamanho", "Pre\u00E7o", "Quantidade","G\u00EAnero"
				}
				));
		getTabela().setBounds(0, 0, 1, 1);
		getTabela().getTableHeader().setReorderingAllowed(false); //não mover colunas na tabela
		getTabela().getTableHeader().setResizingAllowed(false); //não redimensionar a tabela	
		setLocationRelativeTo(null);
		setResizable(false);
		scrollPane.setViewportView(getTabela());
		

		JLabel lblBuscaDeClientes = new JLabel("BUSCA DE PRODUTOS");
		lblBuscaDeClientes.setForeground(Color.WHITE);
		lblBuscaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscaDeClientes.setBounds(246, 94, 301, 44);
		getContentPane().add(lblBuscaDeClientes);

		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new TelaBuscarProdutoBotaoListener(this));
		
		btnVoltar.setIcon(new ImageIcon(TelaBuscarProduto.class.getResource("/images/voltar-seta.png")));
		btnVoltar.setBounds(566, 384, 85, 72);
		getContentPane().add(btnVoltar);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVoltar.setBounds(566, 361, 85, 26);
		getContentPane().add(lblVoltar);

		btnNovo = new JButton("");
		btnNovo.addActionListener(new TelaBuscarProdutoBotaoListener(this));
		
		btnNovo.setIcon(new ImageIcon(TelaBuscarProduto.class.getResource("/images/shopping-basket-add256_24909.png")));
		btnNovo.setBounds(90, 384, 85, 72);
		getContentPane().add(btnNovo);

		JLabel lblAdicionarNovo = new JLabel("ADICIONAR NOVO");
		lblAdicionarNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarNovo.setForeground(Color.WHITE);
		lblAdicionarNovo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdicionarNovo.setBounds(20, 361, 230, 26);
		getContentPane().add(lblAdicionarNovo);

		btnEditar = new JButton("");
		btnEditar.addActionListener(new TelaBuscarProdutoBotaoListener(this));
		
		btnEditar.setIcon(new ImageIcon(TelaBuscarProduto.class.getResource("/images/editar.png")));
		btnEditar.setBounds(408, 384, 85, 72);
		getContentPane().add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditar.setBounds(408, 361, 85, 26);
		getContentPane().add(lblEditar);

		btnExcluir = new JButton("");
		//exclui dados da tabela
		btnExcluir.addActionListener(new TelaBuscarProdutoBotaoListener(this));
			
		btnExcluir.setIcon(new ImageIcon(TelaBuscarProduto.class.getResource("/images/delete_4219.png")));
		btnExcluir.setBounds(258, 384, 85, 72);
		getContentPane().add(btnExcluir);

		JLabel lblExcluir = new JLabel("EXCLUIR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExcluir.setBounds(258, 361, 85, 26);
		getContentPane().add(lblExcluir);

		listarProdutos();
		

	}
	
	public JTable getTabela() {
		return tabela;
	}
	public void setTabela(JTable tabela) {
		this.tabela = tabela;
	}
	
	public JTextField getTxtBuscaNome() {
		return txtBuscaNome;
	}

	public void setTxtBuscaNome(JTextField txtBuscaNome) {
		this.txtBuscaNome = txtBuscaNome;
	}
	public JButton getBtnPesquisar() {
		return btnPesquisar;
	}
	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnNovo() {
		return btnNovo;
	}

	public JButton getBtnVoltar() {
		return btnVoltar;
	}

	public JButton getBtnExcluir() {
		return btnExcluir;
	}


	public void excluirProduto(int id) {

		ExcluirProdutoDAO excluir = new ExcluirProdutoDAO(id);
	}
	
	public void editarProduto(int id) {
		
		TelaCadastroProduto tela = new TelaCadastroProduto(id);
		tela.setVisible(true);
		
	}
	

	public void listarProdutos() {

		BuscarProdutoDAO buscarProduto = new BuscarProdutoDAO();

		List<Produto> lista = buscarProduto.listarProdutos();
		DefaultTableModel dados = (DefaultTableModel)getTabela().getModel(); //cria objeto que armazenará os dados da lista
		dados.setNumRows(0);

		for(Produto p:lista) {
			dados.addRow(new Object[] {
					p.getCodigo(),
					p.getTipo(),
					p.getCor(),
					p.getTamanho(),	
					p.getPreco(),
					p.getQuantidade(),
					p.getGenero()
			});
		}
		
	}
	public void listarProdutosPorId(int id) {

		BuscarProdutoDAO buscarProduto = new BuscarProdutoDAO();

		List<Produto> lista = buscarProduto.listarProdutos();
		DefaultTableModel dados = (DefaultTableModel)getTabela().getModel(); //cria objeto que armazenará os dados da lista
		dados.setNumRows(0);

		for(Produto p:lista) {
			if (p.getCodigo() == id) {
				dados.addRow(new Object[] {
						p.getCodigo(),
						p.getTipo(),
						p.getCor(),
						p.getTamanho(),
						p.getPreco(),
						p.getQuantidade(),
						p.getGenero()
				});
			}
			
		}
		
	}

	
}

