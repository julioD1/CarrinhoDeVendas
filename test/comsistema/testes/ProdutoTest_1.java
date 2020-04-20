package comsistema.testes;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sistema.produto.Produto;
import com.sistema.produto.ProdutoRN;

public class ProdutoTest extends TestHeranca {

	@Before
	public void setup() {
		Produto p1 = new Produto("lote", "Caderno", new Date(), 50, 7.0f);
		Produto p2 = new Produto("lote2", "Regua", new Date(), 30, 2.5f);
		Produto p3 = new Produto("fardo", "Papel", new Date(), 300, 1.5f);
		Produto p4 = new Produto("edicao", "Livro", new Date(), 10, 30.0f);
		Produto p5 = new Produto("caixa", "Caneta", new Date(), 90, 1.5f);

		ProdutoRN produtoRN = new ProdutoRN();
		produtoRN.salvar(p1);
		produtoRN.salvar(p2);
		produtoRN.salvar(p3);
		produtoRN.salvar(p4);
		produtoRN.salvar(p5);

	}

	@After
	public void limpaBanco() {

		ProdutoRN produtoRN = new ProdutoRN();

		List<Produto> produtos = produtoRN.listar();

		for (Produto produto : produtos) {
			produtoRN.excluir(produto);

		}

	}

	@Test
	public void salvarProdutoTest() {

		ProdutoRN produtoRN = new ProdutoRN();

		Produto produtoSalvo = new Produto("lote33", "Apontador", new Date(),
				110, 1.0f);

		produtoRN.salvar(produtoSalvo);

		Produto produtoPesquisado = produtoRN.pesquisarPorNome("Apo");

		assertEquals("lote33", produtoPesquisado.getUnidade());

	}

	@Test
	public void listaProdutosTest() {

		ProdutoRN produtoRN = new ProdutoRN();
		List<Produto> produtos = produtoRN.listar();

		assertEquals(5, produtos.size());

	}

	
}
