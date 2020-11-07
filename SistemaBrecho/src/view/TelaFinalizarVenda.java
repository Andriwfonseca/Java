package view;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import model.Produto;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.awt.event.ActionEvent;

public class TelaFinalizarVenda extends JFrame {

	private JPanel contentPane;
	private JTextField txtValorTotal;
	private JTextField txtValorPago;
	
	private Produto[] produtos;

	private double valorPago;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaFinalizarVenda(double valorTotal, Produto produtos[]) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); //fecha apenas essa janela
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);

		JLabel lblValorTotal = new JLabel("Valor total:");
		lblValorTotal.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblValorTotal.setBounds(75, 25, 190, 60);
		contentPane.add(lblValorTotal);

		JLabel lblValorPago = new JLabel("Valor pago:");
		lblValorPago.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblValorPago.setBounds(75, 115, 190, 60);
		contentPane.add(lblValorPago);

		txtValorTotal = new JTextField();
		txtValorTotal.setBounds(212, 36, 131, 35);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		

		txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(212, 126, 131, 35);
		contentPane.add(txtValorPago);
		focarTxt(txtValorPago); 

		JButton btnVender = new JButton("Vender");
		btnVender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean acao = true;
				boolean vendaRealizada = false;
				
				try {
					valorPago = Double.parseDouble(txtValorPago.getText());
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Valor pago inválido");
					acao = false;
				}
				if (acao) {
					
					if (valorPago > valorTotal) {
						JOptionPane.showMessageDialog(null, "Devolver troco R$"+ (valorPago - valorTotal)+"\nVenda realizada com sucesso");
						vendaRealizada = true;
					}else if(valorPago < valorTotal){
						JOptionPane.showMessageDialog(null, "Valor pago insuficiente");
					}else {
						JOptionPane.showMessageDialog(null, "Venda realizada com sucesso");
						vendaRealizada = true;
					}
				}
				if (vendaRealizada) {
					Document document = new Document();
					Random random = new Random();
					
					int numAleatorio = random.nextInt(999999);
					
					String nomeNotaFiscal = "NotaFiscal"+numAleatorio+"SdbSoft.pdf";
					
					try {
						document.removeDocListener(document);
						PdfWriter.getInstance(document, new FileOutputStream(nomeNotaFiscal));
						document.open();
												
						document.add(new Paragraph("SdbSolf"));
						for(int x = 0; x < produtos.length; x++) {
							String nota = "Item: "+ produtos[x].getTipo() +"     Quantidade: "+ produtos[x].getQuantidade() + "     Preço: R$"+ produtos[x].getPreco();
							document.add(new Paragraph(nota));
						}
						document.add(new Paragraph(" "));
						document.add(new Paragraph(" "));
						document.add(new Paragraph(" "));
						document.add(new Paragraph("Valor Total: R$" + valorTotal));
						document.add(new Paragraph("Valor Pago: R$"+valorPago));
						document.add(new Paragraph("Troco: R$" + (valorPago - valorTotal)));
						document.addTitle("Nota Fiscal SdbSoft");
						
					} catch (FileNotFoundException | DocumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
						document.close();
					}
					
					try {
						Desktop.getDesktop().open(new File(nomeNotaFiscal));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					setVisible(false);
				}
				
			}
		});

		getRootPane().setDefaultButton(btnVender); //apertar com o enter
		btnVender.setFont(new Font("Tahoma", Font.PLAIN, 28));
		btnVender.setBounds(152, 197, 141, 56);
		contentPane.add(btnVender);
		setLocationRelativeTo(null);
		txtValorTotal.setText(String.valueOf(valorTotal));
		txtValorTotal.setEditable(false);

	}
	public void focarTxt(JTextField txt) {
		final JTextField ftf = txt;
		javax.swing.SwingUtilities.invokeLater(new Runnable() { 
			public void run() { 
				ftf.requestFocusInWindow(); 
			} });
	}

}
