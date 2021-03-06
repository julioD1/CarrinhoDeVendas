package com.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sistema.cliente.Cliente;
import com.sistema.cliente.ClienteRN;
import com.sistema.produto.Produto;
import com.sistema.produto.ProdutoRN;
import com.sistema.venda.Venda;
import com.sistema.venda.VendaRN;

public class VendaTest extends TestHeranca {

	Cliente c1;
	Cliente c2;
	Cliente c3;

	Produto p1;
	Produto p2;
	Produto p3;

	@Before
	public void setup() {
		c1 = new Cliente("34125365474", "Lucas@gmail", "Rua 1", "Lucas ",
				new Date());
		c2 = new Cliente("34125365474", "Tulio@gmail", "Rua 2", "Tulio",
				new Date());
		c3 = new Cliente("34125365474", "Vanessa@gmail", "Rua 3", "Vanessa",
				new Date());

		ClienteRN clienteRN = new ClienteRN();

		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);

		p1 = new Produto("lote", "Arroz", new Date(), 50, 7.0f);
		p2 = new Produto("lote2", "Feijao", new Date(), 30, 2.5f);
		p3 = new Produto("fardo", "Agua", new Date(), 300, 1.5f);

		ProdutoRN produtoRN = new ProdutoRN();

		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);

	}

	@After
	public void limpaBanco() {
		VendaRN vendaRN = new VendaRN();

		List<Venda> produtos = vendaRN.listar();

		for (Venda produto : produtos) {
			vendaRN.excluir(produto);

		}

	}

	@Test
	public void registraTest() {

		VendaRN vendaRN = new VendaRN();

		Venda venda1 = new Venda();
		venda1.setCliente(c1);
		venda1.setProduto(p1);
		venda1.setDataVenda(new Date());

		Venda venda2 = new Venda();
		venda2.setCliente(c2);
		venda2.setProduto(p2);
		venda2.setDataVenda(new Date());

		Venda venda3 = new Venda();
		venda3.setCliente(c3);
		venda3.setProduto(p3);
		venda3.setDataVenda(new Date());

		vendaRN.registraVenda(venda1);
		vendaRN.registraVenda(venda2);
		vendaRN.registraVenda(venda3);

		List<Venda> vendas = vendaRN.listar();

		assertEquals(3, vendas.size());

	}

}
