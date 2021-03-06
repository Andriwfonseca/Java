package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import dao.BuscarClienteDAO;
import dao.ExcluirClienteDAO;
import model.Cliente;

public class TelaBuscarCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscaNome;
	
	private JButton btnPesquisar;
	private JButton btnEditar;
	private JButton btnNovo;
	private JButton btnVoltar;
	private JButton btnExcluir;

	private JTable tabela;


	public TelaBuscarCliente() {

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

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 9, 60, 18);
		panel.add(lblNome);

		setTxtBuscaNome(new JTextField());
		getTxtBuscaNome().setFont(new Font("Tahoma", Font.PLAIN, 14));
		getTxtBuscaNome().setBounds(66, 9, 275, 19);
		panel.add(getTxtBuscaNome());
		getTxtBuscaNome().setColumns(10);

		btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String nome = "";
				try {
					nome = txtBuscaNome.getText();
					listarClientesPorNome(nome);
					
				} catch (Exception e2) {
					
					listarClientes();
				}
			}
		});
		
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
						"C\u00F3digo","Nome" , "E-mail", "CPF", "RG", "Data de nascimento"
				}
				));
		getTabela().setBounds(0, 0, 1, 1);
		getTabela().getTableHeader().setReorderingAllowed(false); //n�o mover colunas na tabela
		getTabela().getTableHeader().setResizingAllowed(false); //n�o redimensionar a tabela
		setLocationRelativeTo(null);
		setResizable(false);
		scrollPane.setViewportView(getTabela());
		

		JLabel lblBuscaDeClientes = new JLabel("BUSCA DE CLIENTES");
		lblBuscaDeClientes.setForeground(Color.WHITE);
		lblBuscaDeClientes.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBuscaDeClientes.setBounds(246, 94, 301, 44);
		getContentPane().add(lblBuscaDeClientes);

		btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaMenu().setVisible(true);
				setVisible(false);
			}
		});
		
		
		btnVoltar.setIcon(new ImageIcon(TelaBuscarCliente.class.getResource("/images/voltar-seta.png")));
		btnVoltar.setBounds(566, 384, 85, 72);
		getContentPane().add(btnVoltar);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVoltar.setBounds(566, 361, 85, 26);
		getContentPane().add(lblVoltar);

		btnNovo = new JButton("");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new TelaCadastroCliente().setVisible(true);
				setVisible(false);
			}
		});
		
		
		btnNovo.setIcon(new ImageIcon(TelaBuscarCliente.class.getResource("/images/addUsuario.png")));
		btnNovo.setBounds(90, 384, 85, 72);
		getContentPane().add(btnNovo);

		JLabel lblAdicionarNovo = new JLabel("CADASTRAR CLIENTE");
		lblAdicionarNovo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionarNovo.setForeground(Color.WHITE);
		lblAdicionarNovo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblAdicionarNovo.setBounds(20, 361, 230, 26);
		getContentPane().add(lblAdicionarNovo);

		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = 0;
				try {
					
					id = (int)getTabela().getModel().getValueAt(getTabela().getSelectedRow(), 0); //pega  o id do item selecionado 
					
					editarCliente(id);
					setVisible(false);
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		
		
		btnEditar.setIcon(new ImageIcon(TelaBuscarCliente.class.getResource("/images/editar.png")));
		btnEditar.setBounds(408, 384, 85, 72);
		getContentPane().add(btnEditar);

		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(Color.WHITE);
		lblEditar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEditar.setBounds(408, 361, 85, 26);
		getContentPane().add(lblEditar);

		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int)getTabela().getValueAt(getTabela().getSelectedRow(), 0); //pega  o id do item selecionado       (linha selecionada, e coluna que quero)	

				excluirCliente(id);
				listarClientes();
			}
		});
		//exclui dados da tabela
		
			
		btnExcluir.setIcon(new ImageIcon(TelaBuscarCliente.class.getResource("/images/delete_4219.png")));
		btnExcluir.setBounds(258, 384, 85, 72);
		getContentPane().add(btnExcluir);

		JLabel lblExcluir = new JLabel("EXCLUIR");
		lblExcluir.setHorizontalAlignment(SwingConstants.CENTER);
		lblExcluir.setForeground(Color.WHITE);
		lblExcluir.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblExcluir.setBounds(258, 361, 85, 26);
		getContentPane().add(lblExcluir);

		listarClientes();

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


	public void excluirCliente(int id) {

		ExcluirClienteDAO excluir = new ExcluirClienteDAO(id);
	}
	
	public void editarCliente(int id) {
		
		TelaCadastroCliente tela = new TelaCadastroCliente(id);
		tela.setVisible(true);
		
	}
	

	public void listarClientes() {

		BuscarClienteDAO buscarCliente = new BuscarClienteDAO();

		List<Cliente> lista = buscarCliente.listarClientes();
		DefaultTableModel dados = (DefaultTableModel)getTabela().getModel(); //cria objeto que armazenar� os dados da lista
		dados.setNumRows(0);

		for(Cliente p:lista) {
			dados.addRow(new Object[] {
					p.getCodigo(),
					p.getNome(),
					p.getEmail(),
					p.getCpf(),
					p.getRg(),
					p.getDataNascimento()
					
			});
		}
		
	}
	public void listarClientesPorNome(String nome) {

		BuscarClienteDAO buscarCliente = new BuscarClienteDAO();

		List<Cliente> lista = buscarCliente.listarClientes();
		DefaultTableModel dados = (DefaultTableModel)getTabela().getModel(); //cria objeto que armazenar� os dados da lista
		dados.setNumRows(0);

		for(Cliente p:lista) {
			
			if (p.getNome().toLowerCase().contains(nome.toLowerCase())) { //transforma o nome em letra minuscula e verifica se contem o nome digitado 
				dados.addRow(new Object[] {								  // e o nome digitado tbm � transformado em letra minuscula	
						p.getCodigo(),									  //para poder achar todos os nomes independente se � maiusculo ou minusculo				
						p.getNome(),									  	
						p.getEmail(),
						p.getCpf(),
						p.getRg(),
						p.getDataNascimento()
				});
				
			}
			
			
		}
		
	}

	
}

