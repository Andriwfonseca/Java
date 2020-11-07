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

public class TelaPadrao extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public TelaPadrao() {

		
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
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
