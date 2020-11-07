package model;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class CodigoLabelComAcao {
	

	JLabel label = new JLabel();
	
	public void botaoLabel(JLabel label) {
		
		//codigo para aparecer a maozinha do mouse
		label.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		//criar ação para clique
		label.addMouseListener(new MouseAdapter()  
		{  
		    public void mouseClicked(MouseEvent e)  
		    {  
		       // ação aqui
		      JOptionPane.showMessageDialog(null, "Ação do botao(label)");
		      
		      //compara o texto da label
		     if(label.getText().equals("Inserir")) {
		    	 botaoInserir();
		    	 
		     }else if (label.getText().equals("Editar")){
		    	 botaoEditar();
		     }
		     

		    }  
		}); 
	}
	public void botaoInserir() {
		System.out.println("Inserir");
	}
	
	public void botaoEditar() {
		System.out.println("Editar");
	}
	
}
