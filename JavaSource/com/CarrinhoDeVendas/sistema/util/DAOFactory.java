package com.sistema.util;

import com.sistema.cliente.ClienteDAO;
import com.sistema.cliente.ClienteDAOHibernate;
import com.sistema.produto.ProdutoDAO;
import com.sistema.produto.ProdutoDAOHibernate;
import com.sistema.venda.VendaDAO;
import com.sistema.venda.VendaDAOHibernate;

public class DAOFactory {

	public static ClienteDAO criaClienteDAO() {
		ClienteDAOHibernate clienteDAOHibernate = new ClienteDAOHibernate();
		clienteDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return clienteDAOHibernate;
	}

	public static ProdutoDAO criaProdutoDAO() {
		ProdutoDAOHibernate produtoDAOHibernate = new ProdutoDAOHibernate();
		produtoDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return produtoDAOHibernate;
	}

	public static VendaDAO criaVendaDAO() {
		VendaDAOHibernate vendaDAOHibernate = new VendaDAOHibernate();
		vendaDAOHibernate.setSessao(HibernateUtil.getSession()
				.getCurrentSession());
		return vendaDAOHibernate;
	}
}
