package br.edu.ifba.ads.inf008.model.negocios;

public abstract class Pigmento {
	
	private String id;
	private String nome;
	private int quantidade;
	private float preco;

	public Pigmento(String id, String nome, int quantidade, float preco) {
		 this.setId(id);
		 this.setNome(id);
		 this.setQuantidade(quantidade);
		 this.setPreco(preco);
	}

	public String getId() {
		return this.id;
	}

	private void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public int getQuantidade() {
		return this.quantidade;
	}

	private void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return this.preco;
	}

	private void setPreco(float preco) {
		this.preco = preco;
	}



	public abstract double getDistancia(PigmentoRGB pigRGB);
	public abstract int operacao(int a, int b);
	
	
	 
}
