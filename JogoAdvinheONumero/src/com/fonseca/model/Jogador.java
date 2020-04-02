package com.fonseca.model;

public class Jogador {
	
	private String nome;
	private int numeroTentativas;
	private int numeroDoChute;
	
	public Jogador(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNumeroDoChute(int numero) {
		
		numeroDoChute = numero;
	}
	
	public void addNumeroTentativas() {
		numeroTentativas += 1;
	}
	
	public int getNumeroDoChute() {
		return numeroDoChute;
	}
	
	public int getNumeroTentativas() {
		return numeroTentativas;
	}
	

}
