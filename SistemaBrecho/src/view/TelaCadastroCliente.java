package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dao.BuscarClienteDAO;
import dao.BuscarProdutoDAO;
import dao.CadastrarClienteDAO;
import dao.EditarClienteDAO;
import model.Cliente;
import model.Produto;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCliente;
	private JTextField txtEmailCliente;
	private JTextField txtRuaCliente;
	private JTextField txtBairroCliente;
	private JTextField txtNumeroCliente;
	private JTextField txtCodigoCliente;
	private  JFormattedTextField txtRgCliente;
	private JFormattedTextField txtDataNascimentoCliente;
	private JFormattedTextField txtCpfCliente;
	private int codigo;
	
	private boolean editando;



	public TelaCadastroCliente() {

		inicializarComponentes();
		editando = false;
		
	}
	public TelaCadastroCliente(int id) {

		inicializarComponentes();
		editando = true;
		
		BuscarClienteDAO buscarCliente = new BuscarClienteDAO();
		List<Cliente> lista = buscarCliente.listarClientes();

		//preenche os dados recuperado pela id selecionada na tela buscar produtos
		for(Cliente cliente:lista) {
			if (cliente.getCodigo() == id) {


				codigo = id;
				txtNomeCliente.setText(cliente.getNome());
				txtCodigoCliente.setText(Integer.toString(cliente.getCodigo()));
				txtEmailCliente.setText(cliente.getEmail());
				txtCpfCliente.setText(cliente.getCpf());
				txtRgCliente.setText(cliente.getRg());
				txtDataNascimentoCliente.setText(cliente.getDataNascimento());
				txtRuaCliente.setText(cliente.getRua());
				txtBairroCliente.setText(cliente.getBairro());
				txtNumeroCliente.setText(Integer.toString(cliente.getNumero()));
				
			}
		}
		
	}
	
	public void focarTxt(JTextField txt) {
		final JTextField ftf = txt;
		javax.swing.SwingUtilities.invokeLater(new Runnable() { 
			public void run() { 
				ftf.requestFocusInWindow(); 
			} });
	}
	public void inicializarComponentes() {
		
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
		lblCdigo.setBounds(10, 15, 62, 26);
		panel.add(lblCdigo);
		
		JLabel lblGnero = new JLabel("Nome:");
		lblGnero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGnero.setBounds(10, 51, 62, 13);
		panel.add(lblGnero);
				
		JLabel lblCdigo_1 = new JLabel("E-mail:");
		lblCdigo_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1.setBounds(10, 73, 80, 26);
		panel.add(lblCdigo_1);
		
		txtCodigoCliente = new JTextField();
		txtCodigoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCodigoCliente.setBounds(68, 19, 96, 19);
		panel.add(txtCodigoCliente);
		txtCodigoCliente.setColumns(10);
		txtCodigoCliente.setEditable(false);
		
		
		JLabel lblCdigo_1_2 = new JLabel("Data de nascimento:");
		lblCdigo_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_2.setBounds(329, 102, 141, 26);
		panel.add(lblCdigo_1_2);
		
		JLabel lblCdigo_1_3 = new JLabel("CPF:");
		lblCdigo_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_3.setBounds(10, 102, 80, 26);
		panel.add(lblCdigo_1_3);
		
		JLabel lblCdigo_1_3_2 = new JLabel("RG:");
		lblCdigo_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_3_2.setBounds(190, 102, 80, 26);
		panel.add(lblCdigo_1_3_2);
		
		JLabel lblCdigo_1_3_3 = new JLabel("Rua:");
		lblCdigo_1_3_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_3_3.setBounds(10, 136, 80, 26);
		panel.add(lblCdigo_1_3_3);
		
		JLabel lblCdigo_1_3_2_1 = new JLabel("Bairro:");
		lblCdigo_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigo_1_3_2_1.setBounds(258, 136, 80, 26);
		panel.add(lblCdigo_1_3_2_1);
		
		JLabel lblNumero = new JLabel("N\u00FAmero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumero.setBounds(10, 172, 141, 26);

		
		panel.add(lblNumero);
		
		txtNomeCliente = new JTextField();
		txtNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNomeCliente.setColumns(10);
		txtNomeCliente.setBounds(68, 51, 242, 19);
		panel.add(txtNomeCliente);
		
		txtEmailCliente = new JTextField();
		txtEmailCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtEmailCliente.setColumns(10);
		txtEmailCliente.setBounds(68, 79, 242, 19);
		panel.add(txtEmailCliente);
		
		txtRuaCliente = new JTextField();
		txtRuaCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtRuaCliente.setColumns(10);
		txtRuaCliente.setBounds(68, 138, 180, 19);
		panel.add(txtRuaCliente);
		
		txtBairroCliente = new JTextField();
		txtBairroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtBairroCliente.setColumns(10);
		txtBairroCliente.setBounds(304, 138, 180, 19);
		panel.add(txtBairroCliente);
		
		txtNumeroCliente = new JTextField();
		txtNumeroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNumeroCliente.setColumns(10);
		txtNumeroCliente.setBounds(68, 174, 96, 19);
		panel.add(txtNumeroCliente);
		
		txtCpfCliente = new JFormattedTextField();
		txtCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtCpfCliente.setBounds(68, 109, 111, 19);
		panel.add(txtCpfCliente);

        try {
            txtCpfCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));          
            
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        txtRgCliente = new JFormattedTextField();
        txtRgCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtRgCliente.setBounds(215, 108, 96, 19);
        panel.add(txtRgCliente);
        
        try {
        	txtRgCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#.###.###")));        
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        
        txtDataNascimentoCliente = new JFormattedTextField();
    	txtDataNascimentoCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	txtDataNascimentoCliente.setBounds(460, 108, 80, 19);
    	panel.add(txtDataNascimentoCliente);
    	  try {
              txtDataNascimentoCliente.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
          } catch (java.text.ParseException ex) {
              ex.printStackTrace();
          }
    	  
    	
		JLabel lblCadastroDeProdutos = new JLabel("CADASTRO DE CLIENTES");
		lblCadastroDeProdutos.setForeground(new Color(255, 255, 255));
		lblCadastroDeProdutos.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblCadastroDeProdutos.setBounds(219, 81, 301, 44);
		getContentPane().add(lblCadastroDeProdutos);
		
		JButton btnSalvar = new JButton("");
		
		
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean podeSalvar = true;
				String nome = "";
				String email = "";
				String cpf = "";
				String rg = "";
				String dataNascimento = "";
				String rua = "";
				String bairro = "" ;
				int numero = 0;

				
				try {
					nome = txtNomeCliente.getText();
					if (nome.length() < 2) {
						new Throwable("Por favor, insira um nome válido!");
						JOptionPane.showMessageDialog(null, "Por favor, insira um nome válido!");
						podeSalvar = false;
						focarTxt(txtNomeCliente);
					}
				} catch (Exception e2) {
					podeSalvar = false;
					JOptionPane.showMessageDialog(null, "Por favor, insira um nome válido!");
				}
				
				if (podeSalvar) {
					try {
						email = txtEmailCliente.getText();
						if (email.length() < 5) {
							new Throwable("Por favor, insira um email válido!");
							JOptionPane.showMessageDialog(null, "Por favor, insira um email válido!");
							podeSalvar = false;
							focarTxt(txtEmailCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira um email válido!");
					}
				}
				if (podeSalvar) {
					
					try {
						cpf = (txtCpfCliente.getText());
						if (cpf.contains(" ")) {
							new Throwable("Por favor, insira um cpf válido!");
							JOptionPane.showMessageDialog(null, "Por favor, insira um cpf válido!");							
							podeSalvar = false;
							focarTxt(txtCpfCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira um cpf válido!");
					}
				}
				if (podeSalvar) {
					
					try {
						rg = (txtRgCliente.getText());
						if (rg.contains(" ")) {
							new Throwable("Por favor, insira um rg válido!");
							JOptionPane.showMessageDialog(null, "Por favor, insira um rg válido!");
							podeSalvar = false;
							focarTxt(txtRgCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira um rg válido!");
					}
				}
				if (podeSalvar) {
					
					try {
						dataNascimento = txtDataNascimentoCliente.getText();
						if (dataNascimento.contains(" ")) {
							new Throwable("Por favor, insira uma data de nascimento válida!");
							JOptionPane.showMessageDialog(null, "Por favor, insira uma data de nascimento válida!");
							podeSalvar = false;
							focarTxt(txtDataNascimentoCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira uma data de nascimento válida!");
					}
				}
				if (podeSalvar) {
					
					try {
						rua = txtRuaCliente.getText();
						if (rua.length() < 2) {
							new Throwable("Por favor, insira uma rua válida!");
							JOptionPane.showMessageDialog(null, "Por favor, insira uma rua válida!");
							podeSalvar = false;
							focarTxt(txtRuaCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira uma rua válida!");
					}
				}
				if (podeSalvar) {
					
					try {
						bairro = txtBairroCliente.getText();
						if (bairro.length() < 2) {
							new Throwable("Por favor, insira um bairro válido!");
							JOptionPane.showMessageDialog(null, "Por favor, insira um bairro válido!");
							podeSalvar = false;
							focarTxt(txtBairroCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira um bairro válido!");
						
					}
				}
				if (podeSalvar) {
					
					try {
						numero = Integer.parseInt(txtNumeroCliente.getText());
						if (numero < 2) {
							new Throwable("Por favor, insira um número válido!");
							JOptionPane.showMessageDialog(null, "Por favor, insira um número válido!");
							podeSalvar = false;
							focarTxt(txtNumeroCliente);
						}
					} catch (Exception e2) {
						podeSalvar = false;
						JOptionPane.showMessageDialog(null, "Por favor, insira um número válido!");
						focarTxt(txtNumeroCliente);
					}
				}

				if (podeSalvar) {
					
					if (!editando) {
						new CadastrarClienteDAO(nome, email, cpf, rg, dataNascimento, rua, bairro, numero);
					}else {
						new EditarClienteDAO(codigo, nome, email, cpf, rg, dataNascimento, rua, bairro, numero);
					}
					txtNomeCliente.setText("");
					txtEmailCliente.setText("");
					txtRgCliente.setText("");
					txtCpfCliente.setText("");
					txtBairroCliente.setText("");
					txtNumeroCliente.setText("");
					txtRuaCliente.setText("");
					txtDataNascimentoCliente.setText("");
					txtCodigoCliente.setText(Integer.toString(pegarProximaId()));
					
				}
			
			
			
				
				
			}
		});
		btnSalvar.setIcon(new ImageIcon(TelaCadastroProduto.class.getResource("/images/disquete.png")));
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(203, 380, 85, 72);
		getContentPane().add(btnSalvar);
		
		JButton btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNomeCliente.setText("");
				txtEmailCliente.setText("");
				txtRgCliente.setText("");
				txtCpfCliente.setText("");
				txtBairroCliente.setText("");
				txtNumeroCliente.setText("");
				txtRuaCliente.setText("");
				txtDataNascimentoCliente.setText("");
				txtCodigoCliente.setText(Integer.toString(pegarProximaId()));
				
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
		focarTxt(txtNomeCliente);
		txtCodigoCliente.setText(Integer.toString(pegarProximaId()));
		getRootPane().setDefaultButton(btnSalvar);
	}
	

	public int pegarProximaId() {
		BuscarClienteDAO buscarCliente = new BuscarClienteDAO();

		
		List<Cliente> lista = buscarCliente.listarClientes();
		Cliente cliente = new Cliente();
		cliente = lista.get(lista.size() -1); //recupera o ultimo valor da lista
	
		int id = cliente.getCodigo() +1;	//pega o codigo do ultimo valor da lista e acrescenta 1, porq sera o proximo id
	
		return id;
	}

}
