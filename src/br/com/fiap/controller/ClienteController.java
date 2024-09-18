package br.com.fiap.controller;

import br.com.fiap.model.dao.ClienteDAO;
import br.com.fiap.model.dto.Cliente;
import br.com.fiap.model.factory.ConnectionFactory;

import java.sql.Connection;

public class ClienteController {
    public String inserirCliente(String nome, String placa){
        Cliente cliente = new Cliente();
        cliente.setNomeCLiente(nome);
        cliente.setPlaca(placa);
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        String resultado = clienteDAO.inserir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String alterarCliente(int id, String nome, String placa){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        cliente.setNomeCLiente(nome);
        cliente.setPlaca(placa);
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        String resultado = clienteDAO.alterar(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String excluirCliente(int id){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        String resultado = clienteDAO.excluir(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
    public String listarUm(int id){
        Cliente cliente = new Cliente();
        cliente.setIdCliente(id);
        Connection con = ConnectionFactory.abrirConexao();
        ClienteDAO clienteDAO = new ClienteDAO(con);
        String resultado = clienteDAO.listarUm(cliente);
        ConnectionFactory.fecharConexao(con);
        return resultado;
    }
}
