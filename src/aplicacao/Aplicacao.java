package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.Cliente;
import entities.OrdemProduto;
import entities.Pedido;
import entities.Produto;
import enums.StatusPedido;

public class Aplicacao {

	public static void main(String[] args) throws ParseException {
		Scanner s = new Scanner(System.in);
		List<OrdemProduto> listaProduto = new ArrayList<>();
		List<Integer> listaQuantidadeProduto = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
		
		System.out.println("Entre com os dados do cliente");
		System.out.print("Nome: ");
		String nome = s.next();
		System.out.print("Email: ");
		String email = s.next();
		System.out.print("Aniversário (DD/MM/AAAA): ");
		Date aniversario = sdf.parse(s.next());
		System.out.print("Status do Pedido: ");
		String status = s.next();
		System.out.println("Quantos itens irá pedir?");
		int quantidadeItens = s.nextInt();
		
		Cliente c = new Cliente(nome, email, aniversario);
		Pedido p = new Pedido(new Date(), StatusPedido.valueOf(status), c);
		for(int i = 0; i< quantidadeItens; i++) {
			System.out.print("Nome do Produto: ");
			String produto = s.next();
			System.out.print("Preço do Produto: ");
			Double preco = s.nextDouble();
			System.out.print("Quantidade: ");
			int quantidade = s.nextInt();
			p.addItem((new OrdemProduto(quantidade, new Produto(produto, preco))));
		}
		

		
		System.out.println(p.toString());
	}
}
