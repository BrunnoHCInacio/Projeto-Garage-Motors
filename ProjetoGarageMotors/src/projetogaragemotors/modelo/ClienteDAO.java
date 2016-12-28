/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetogaragemotors.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import projetogaragemotors.controller.Cliente;
import projetogaragemotors.controller.ClienteEndereco;

/**
 *
 * @author brunn
 */
public class ClienteDAO {

    public ClienteDAO() {
    }

    public static int create(Cliente cliente) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = " insert into clientes (nome, cpf) values ('"
                + cliente.getNome() + "','"
                + cliente.getCpf() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1); // Retorna e grava na variavel 'key' a chave gerada no banco de dados.
        cliente.setPkCliente(key); // Seta no objeto cliente o id gerado pelo banco.
        ClienteEnderecoDAO.create(cliente.getClienteEndereco());// Grava o endereco do cliente.
        return key;
    }

    public static Cliente retreave(int pkCliente) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select * from clientes where pk_cliente =" + pkCliente;
        ResultSet rs = stm.executeQuery(sql);
        ClienteEndereco clienteEndereco = ClienteEnderecoDAO.retreaveByCliente(pkCliente);
        rs.next();
        return new Cliente(
                rs.getInt("pk_cliente"),
                rs.getString("nome"),
                rs.getString("cpf"),
                clienteEndereco);
    }

    public static ArrayList<Cliente> retreaveAll() throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select * from clientes";
        ResultSet rs = stm.executeQuery(sql);
        ArrayList<Cliente> listaCliente = new ArrayList<>();

        while (rs.next()) {

            ClienteEndereco clienteEndereco = ClienteEnderecoDAO.retreaveByCliente(rs.getInt("pk_cliente"));

            listaCliente.add(
                    new Cliente(
                            rs.getInt("pk_cliente"),
                            rs.getString("nome"),
                            rs.getString("cpf"),
                            clienteEndereco));
        }
        return listaCliente;
    }
}
