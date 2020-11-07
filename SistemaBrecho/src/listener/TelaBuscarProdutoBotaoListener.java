package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.TelaBuscarProduto;
import view.TelaCadastroProduto;
import view.TelaMenu;

public class TelaBuscarProdutoBotaoListener implements ActionListener{
	private TelaBuscarProduto obj;

	public TelaBuscarProdutoBotaoListener(TelaBuscarProduto obj) {
		
		this.obj = obj;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == obj.getBtnPesquisar()) {
			pesquisar();
		}else if (e.getSource() == obj.getBtnExcluir()) {
			excluir();
		}else if (e.getSource() == obj.getBtnEditar()) {
			editar();
		}else if (e.getSource() == obj.getBtnNovo()) {
			novo();
		}else if (e.getSource() == obj.getBtnVoltar()) {
			voltar();
		}
		
		
	}
	
	public void pesquisar() {
		int id = 0;
		try {
			id = Integer.parseInt(obj.getTxtBuscaNome().getText());
			obj.listarProdutosPorId(id);
			
		} catch (Exception e2) {
			
			obj.listarProdutos();
		}
	}
	public void excluir() {
		int id = (int)obj.getTabela().getValueAt(obj.getTabela().getSelectedRow(), 0); //pega  o id do item selecionado       (linha selecionada, e coluna que quero)	

		obj.excluirProduto(id);
		obj.listarProdutos();
	}
	public void editar() {
		//Botao editar
		int id = 0;
		try {
			
			id = (int)obj.getTabela().getModel().getValueAt(obj.getTabela().getSelectedRow(), 0); //pega  o id do item selecionado 
			
			obj.editarProduto(id);
			obj.setVisible(false);
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
	public void novo() {
		new TelaCadastroProduto().setVisible(true);
		obj.setVisible(false);

	}
	public void voltar() {
		obj.setVisible(false);
		new TelaMenu().setVisible(true);
	}
}
