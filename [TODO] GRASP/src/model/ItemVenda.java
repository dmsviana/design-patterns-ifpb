package model;

public class ItemVenda {

	private int quantidade;

	private Produto produto;

	public ItemVenda() {

	}

	public ItemVenda(Produto produto, int quantidade) {
		this.produto = produto;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public float getSubTotal() {
		return getProduto().getPreco() * getQuantidade();
	}

}
