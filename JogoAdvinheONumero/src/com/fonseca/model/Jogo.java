package com.fonseca.model;

import java.util.Random;

import javax.swing.JOptionPane;

public class Jogo {

	private int numeroPremiado = 0;
	private boolean jogoEmAndamento;
	private Jogador jogador; 
	
	public Jogo(Jogador jogador) {
		
		jogoEmAndamento = true;
		this.jogador = jogador;
	}
	
	public void iniciaJogo() {
		
		Jogador jogador = getJogador();
		jogador.addNumeroTentativas();
		
		if (numeroPremiado == 0) {
			numeroPremiado = gerarNumero();
		}
		getJogador().setNumeroDoChute(Integer.parseInt(JOptionPane.showInputDialog("Advinhe o número premiado entre 1 e 100")));
		
		
		if (jogador.getNumeroDoChute() == numeroPremiado) {
			jogoEmAndamento = false;
			JOptionPane.showMessageDialog(null, "Parabéns "+ jogador.getNome()+" você venceu\nNúmero de tentativas: "+jogador.getNumeroTentativas());
		}else if (jogador.getNumeroDoChute() > numeroPremiado) {
			
			JOptionPane.showMessageDialog(null,"Seu número de chute é maior que o número premiado\nNúmero de tentativas: "+jogador.getNumeroTentativas());
		}else {
			JOptionPane.showMessageDialog(null,"Seu número de chute é menor que o número premiado\nNúmero de tentativas: "+jogador.getNumeroTentativas());
		}
		
	}
	
	
	
	public Jogador getJogador() {
		
		return jogador;
	}
	
	public int gerarNumero() {
		
		Random gerador = new Random();
		int numeroGerado = gerador.nextInt(100) +1;
		
		return numeroGerado;
		
	}
	public boolean isJogoEmAndamento() {
		return jogoEmAndamento;
	}
}
