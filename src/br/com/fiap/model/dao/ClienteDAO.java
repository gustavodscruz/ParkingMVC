package br.com.fiap.model.dao;

import br.com.fiap.model.dto.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO implements IDAO{
    Connection con;
    Cliente cliente;


    public ClienteDAO(Connection con) {
        this.con = con;
    }

    public Connection getCon() {
        return con;
    }

    public String inserir(Object object){
        cliente = (Cliente) object;
        String sql = "Insert into ddd_cliente(NOME_CLIENTE, PLACA) values(?, ?)";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setString(1, cliente.getNomeCLiente());
            ps.setString(2, cliente.getPlaca());
            if(ps.executeUpdate() > 0){
                return "Inserido com sucesso!";
            }
            return "Dados não foram inseridos!";
        }catch (SQLException e){
            return "Erro de sql!\n" + e.getMessage();
        }
    }

    public String alterar(Object object){
        cliente = (Cliente) object;
        String sql = "UPDATE DDD_CLIENTE SET NOME_CLIENTE =?, PLACA = ? where ID_CLIENTE = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(3, cliente.getIdCliente());
            ps.setString(1, cliente.getNomeCLiente());
            ps.setString(2, cliente.getPlaca());
            if(ps.executeUpdate() > 0){
                return "Alterado com sucesso!";
            }
            return "Não alterado! Falha!";
        }catch (SQLException e){
            return "Erro de sql!\n" + e.getMessage();
        }
    }
    public String excluir(Object object){
        cliente = (Cliente) object;
        String sql = "DELETE DDD_CLIENTE where ID_CLIENTE = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, cliente.getIdCliente());
            if(ps.executeUpdate() > 0){
                return "Deletado com sucesso!";
            }
            return "Não excluído! Falha!";
        }catch (SQLException e){
            return "Erro de sql!\n" + e.getMessage();
        }
    }
    public String listarUm(Object object){
        cliente = (Cliente) object;
        String sql = "SELECT * from DDD_CLIENTE where ID_CLIENTE = ?";
        try(PreparedStatement ps = getCon().prepareStatement(sql)){
            ps.setInt(1, cliente.getIdCliente());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return "Nome do cliente: " + rs.getString("NOME_CLIENTE") + "\nPlaca: " + rs.getString("PLACA");
            }else{
                return "Sem cliente selecionado! Verifique o id que foi inserida para busca!";
            }

        }catch (SQLException e){
            return "Erro de sql!\n" + e.getMessage();
        }
    }
}
