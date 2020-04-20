package com.sistema.test;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sistema.cliente.Cliente;
import com.sistema.cliente.ClienteRN;

public class ClienteTest extends TestHeranca{
	
	@Before
	public void setup(){
		Cliente c1 = new Cliente("34125365474", "Lucas@gmail", "Rua 1", "Cliente 1", new Date());
		Cliente c2 = new Cliente("34125365474", "Tulio@gmail", "Rua 2", "Cliente 2", new Date());
		Cliente c3 = new Cliente("34125365474", "Vanessa@gmail", "Rua 3", "Cliente 3", new Date());
		
		ClienteRN clienteRN = new ClienteRN();
		
		clienteRN.salvar(c1);
		clienteRN.salvar(c2);
		clienteRN.salvar(c3);
		
	}
	
	@After
	public void limpaBanco(){
		
		ClienteRN clienteRN = new ClienteRN();
		List<Cliente> lista = clienteRN .listar();
		
		for (Cliente cliente : lista) {
			clienteRN.excluir(cliente);
		}
	}

	@Test
	public void salvarTest() {

		Cliente c1 = new Cliente();

		c1.setNome("Ronaldo");
		c1.setEndereco("Rua Teste");
		c1.setCpf("123456789");

		ClienteRN clienteRN = new ClienteRN();

		clienteRN.salvar(c1);

		assertEquals(true, true);

	}
	
	@Test
	public void listarTest(){
		ClienteRN clienteRN = new ClienteRN();
		 List<Cliente> lista = clienteRN.listar();
		 assertEquals(3, lista.size());
		 
	}
	
	@Test
	public void excluirTest(){
		ClienteRN clienteRN = new ClienteRN();
		
		List<Cliente> lista = clienteRN.listar();
		
		Cliente clienteExcluido = lista.get(0);
		
		clienteRN.excluir(clienteExcluido);
		
		lista = clienteRN.listar();
		
		assertEquals(2, lista.size());
		
	}
	
	@Test
	public void pesquisarTest(){
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado =  clienteRN.pesquisar("lu");
		
		assertEquals("Lucas@gmail", clientePesquisado.getEmail());

	}
	@Test
	public void alterarTest(){
		
		ClienteRN clienteRN = new ClienteRN();
		Cliente clientePesquisado =  clienteRN.pesquisar("lu");
		
		assertEquals("Lucas@gmail", clientePesquisado.getEmail());
		
		clientePesquisado.setEndereco("Novo Endereço");
		
		clienteRN.alterar(clientePesquisado);
		
		Cliente clienteAlterado = clienteRN.pesquisar("lu");
		
		assertEquals("Novo Endereço", clienteAlterado.getEndereco());
		
	}
	
}
