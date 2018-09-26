package entities;

public class OrdemProduto {
	private Integer quantidade;
	private Double precoTotal;
	private Produto produto;
	
	public OrdemProduto(Integer quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return precoTotal;
	}

	
	public Double totalproduto() {
		return quantidade*produto.getPreco();
	}
}
