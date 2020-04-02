package com.fonseca;

import javax.swing.JOptionPane;

import com.fonseca.model.Jogador;
import com.fonseca.model.Jogo;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nomeJogador = JOptionPane.showInputDialog("Qual seu nome?");
		
		Jogador jogador = new Jogador(nomeJogador);
		
		Jogo jogo = new Jogo(jogador);
		
		while (jogo.isJogoEmAndamento()) {
			jogo.iniciaJogo();
		}
		

	}

}
