package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enums.StatusPedido;

public class Pedido {
	private Date data;
	private StatusPedido status;
	private Cliente cliente;
	private List<OrdemProduto> listaDeProdutos = new ArrayList<>();
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Pedido(Date data, StatusPedido status, Cliente cliente) {
		this.data = data;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<OrdemProduto> getListaDeProdutos() {
		return listaDeProdutos;
	}
	
	public void addItem(OrdemProduto ordemProduto) {
		this.listaDeProdutos.add(ordemProduto);
	}
	
	public void removeItem(OrdemProduto ordemproduto) {
		listaDeProdutos.remove(ordemproduto);
	}
	
	public Double total() {
		Double total = 0.0;
		for(OrdemProduto ordem : listaDeProdutos) {
			total += ordem.totalproduto();
		}
		return total;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Pedido: ");
		sb.append(sdf.format(data) + "\n");
		sb.append("Status: ");
		sb.append(status + "\n");
		sb.append("Cliente: ");
		sb.append(cliente.getNome() + "\n");
		sb.append("Order items:\n");
		for (OrdemProduto item : listaDeProdutos) {
			sb.append(item.getProduto().getNome() + ", $"+item.getProduto().getPreco() +", subtotal"+item.totalproduto()+"\n");
		}
		sb.append("total: $");
		sb.append(String.format("%.2f", total()));
		
		return sb.toString();
	}
	
}
