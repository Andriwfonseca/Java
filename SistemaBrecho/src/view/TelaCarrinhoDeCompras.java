package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.AdicionaProdutoCarrinhoDAO;
import dao.BuscarProdutoDAO;
import dao.EditarProdutoDAO;
import model.Produto;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class TelaCarrinhoDeCompras extends JFrame {

	private JPanel contentPane;
	private JTable tabela;
	private JTextField txtCodigo;
	private JTextField txtQuantidade;
	private static int numeroDeItens;
	private DefaultTableModel dados;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TelaCarrinhoDeCompras() {

		numeroDeItens = 0;
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
		panel.setBounds(28, 125, 692, 241);
		getContentPane().add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 332, 217);
		panel.add(scrollPane);

		//cria a tabela sobreescrevendo  o metodo de editar celulas
		tabela = new JTable() {
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false;
			}
		};
		tabela.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"C\u00F3digo","Tipo" ,"Quantidade", "Valor total"
				}
				));
		tabela.setBounds(0, 0, 1, 1);
		tabela.getTableHeader().setReorderingAllowed(false); //não mover colunas na tabela
		tabela.getTableHeader().setResizingAllowed(false); //não redimensionar a tabela

		setLocationRelativeTo(null);
		setResizable(false);
		scrollPane.setViewportView(tabela);

		JButton btnAdicionar = new JButton("Adicionar produto");
		btnAdicionar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				boolean acao = true; //se tiver digitado o id e quantidade corretamente, acao fica true para poder executar a ação do botao

				AdicionaProdutoCarrinhoDAO addProduto = new AdicionaProdutoCarrinhoDAO();

				int id = 0;
				int quantidade = 0;
				try {

					id = Integer.parseInt(txtCodigo.getText());

				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Id inválido");
					acao = false;
				}

				if (acao) {
					try {

						quantidade = Integer.parseInt(txtQuantidade.getText());

					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "Quantidade inválida");
						acao = false;
					}
				}

				if (acao) {


					List<Produto> lista = addProduto.adicionarProdutos(id,quantidade);

					if (!lista.isEmpty()) { //se a lista nao estiver vazia, coloca ela na tabela, se nao existir a id, a lista ficara vazia

						int quantEstoque = pegarQuantidadeItemEstoque(id);

						if (quantEstoque >= quantidade) {

							if (quantidade > 0) {
								dados = (DefaultTableModel)tabela.getModel(); //cria objeto que armazenará os dados da lista
								dados.setNumRows(numeroDeItens);



								for(Produto p:lista) {
									dados.addRow(new Object[] {
											p.getCodigo(),
											p.getTipo(),
											p.getQuantidade(),
											p.getPreco(),

									});
								}
								removerQuantidadeItemEstoque(quantidade, id);
								numeroDeItens ++;
							}else {
								JOptionPane.showMessageDialog(null, "Por favor, insira uma quantidade válida");
							}

							
						}else {
							JOptionPane.showMessageDialog(null, "Não tem essa quantidade em estoque");
						}


					}else {
						JOptionPane.showMessageDialog(null, "Código de item não cadastrado no sistema!");
					}
				}




			}
		});
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAdicionar.setBounds(457, 140, 155, 53);
		panel.add(btnAdicionar);

		JLabel lblCodigo = new JLabel("C\u00F3digo:");
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCodigo.setBounds(447, 27, 79, 48);
		panel.add(lblCodigo);

		txtCodigo = new JTextField();
		txtCodigo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtCodigo.setBounds(516, 41, 96, 19);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);

		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblQuantidade.setBounds(411, 70, 110, 48);
		panel.add(lblQuantidade);

		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtQuantidade.setColumns(10);
		txtQuantidade.setBounds(516, 85, 96, 19);
		panel.add(txtQuantidade);

		JLabel lblCarrinhoDeCompras = new JLabel("CARRINHO DE COMPRAS");
		lblCarrinhoDeCompras.setForeground(Color.WHITE);
		lblCarrinhoDeCompras.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCarrinhoDeCompras.setBounds(213, 80, 301, 44);
		getContentPane().add(lblCarrinhoDeCompras);

		JButton btnVoltar = new JButton("");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new TelaMenu().setVisible(true);
			}
		});
		btnVoltar.setIcon(new ImageIcon(TelaCarrinhoDeCompras.class.getResource("/images/voltar-seta.png")));
		btnVoltar.setBounds(501, 390, 85, 64);
		getContentPane().add(btnVoltar);

		JLabel lblVoltar = new JLabel("VOLTAR");
		lblVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblVoltar.setBounds(501, 363, 85, 26);
		getContentPane().add(lblVoltar);

		JButton btnFinalizar = new JButton("");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//int numeroDeItensCarrinho = tabela.getModel().getRowCount();
				double somaTotal = 0;
				Produto produtos[] = new Produto[numeroDeItens]; //criar array de objetos para gerar o pdf na telaFinalizarVenda

				//faz a soma de todos itens no carrinho
				for(int x = 0;x < numeroDeItens;x++) {

					produtos[x] = new Produto();
					somaTotal = somaTotal + (double) tabela.getValueAt(x, 3);
					produtos[x].setTipo((String) tabela.getValueAt(x, 1));								
					double precoTotal =(double) tabela.getValueAt(x, 3);
					int quantidade = (int) tabela.getValueAt(x, 2);
					double preco = precoTotal / quantidade;
					produtos[x].setPreco( preco);
					produtos[x].setQuantidade(quantidade);



				}


				TelaFinalizarVenda telaFinalizaVenda = new TelaFinalizarVenda(somaTotal,produtos);
				telaFinalizaVenda.setVisible(true);

				//limpar a tabela
				dados = (DefaultTableModel)tabela.getModel();
				dados.setNumRows(0);
				numeroDeItens = 0;

				txtCodigo.setText("");
				txtQuantidade.setText("");
				focarTxt(txtCodigo);
			}
		});
		btnFinalizar.setIcon(new ImageIcon(TelaCarrinhoDeCompras.class.getResource("/images/US-dollar256_24937.png")));
		btnFinalizar.setBounds(117, 390, 85, 64);
		getContentPane().add(btnFinalizar);

		JLabel lblFinalizarVenda = new JLabel("FINALIZAR");
		lblFinalizarVenda.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinalizarVenda.setForeground(Color.WHITE);
		lblFinalizarVenda.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFinalizarVenda.setBounds(104, 363, 112, 26);
		getContentPane().add(lblFinalizarVenda);

		JButton btnRemover = new JButton("");
		btnRemover.setIcon(new ImageIcon(TelaCarrinhoDeCompras.class.getResource("/images/delete_4219.png")));
		btnRemover.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				//Se tiver algum item selecionado, apaga ele
				if (tabela.getSelectedRow() != -1) {

					int quantidadeDaLinhaSelecionada = (int) tabela.getModel().getValueAt(tabela.getSelectedRow(), 2);
					int idDaLinhaSelecionada = (int) tabela.getModel().getValueAt(tabela.getSelectedRow(), 0);
					
					

					dados.removeRow(tabela.getSelectedRow() );
					dados.fireTableRowsDeleted(tabela.getSelectedRow() , tabela.getSelectedRow() ); 
					numeroDeItens--; //aqui é pra não criar espaços em branco na tabela

					devolverQuantidadeItemEstoque(idDaLinhaSelecionada, quantidadeDaLinhaSelecionada);
				}



			}
		});
		btnRemover.setBounds(301, 390, 85, 64);
		getContentPane().add(btnRemover);

		JLabel lblRemover = new JLabel("REMOVER");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblRemover.setBounds(288, 363, 112, 26);
		getContentPane().add(lblRemover);
		setLocationRelativeTo(null);
		setResizable(false);
		focarTxt(txtCodigo);
		getRootPane().setDefaultButton(btnAdicionar); //adiciona com o botao enter

	}

	public void focarTxt(JTextField txt) {
		final JTextField ftf = txt;
		javax.swing.SwingUtilities.invokeLater(new Runnable() { 
			public void run() { 
				ftf.requestFocusInWindow(); 
			} });
	}

	public int pegarQuantidadeItemEstoque(int id) {
		BuscarProdutoDAO buscarProduto = new BuscarProdutoDAO();

		List<Produto> lista = buscarProduto.listarProdutos();

		int quant = 0;
		for(Produto p:lista) {

			if (p.getCodigo() == id) {

				quant = p.getQuantidade();

			}
		}
		return quant;
	}

	public void removerQuantidadeItemEstoque(int quantidade, int id) {

		int quantidadeEstoque = pegarQuantidadeItemEstoque(id);
		int quantidadeCarrinho = quantidade;
		int quantidadeFinal = quantidadeEstoque - quantidadeCarrinho;

		EditarProdutoDAO editarProd = new EditarProdutoDAO(quantidadeFinal,id); 

	}
	public void devolverQuantidadeItemEstoque(int id, int quantidade) {

		int quantidadeEstoque = pegarQuantidadeItemEstoque(id);
		int quantidadeCarrinho = quantidade;
		int quantidadeFinal = quantidadeEstoque + quantidadeCarrinho;

		EditarProdutoDAO editarProd = new EditarProdutoDAO(quantidadeFinal,id); 
	}
}
