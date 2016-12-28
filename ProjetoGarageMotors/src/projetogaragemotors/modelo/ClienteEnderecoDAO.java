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
import projetogaragemotors.controller.ClienteEndereco;

/**
 *
 * @author brunn
 */
public class ClienteEnderecoDAO {

    public ClienteEnderecoDAO() {
    }

    public static int create(ClienteEndereco clienteEndereco) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "insert into clientes_enderecos ("
                + "logradouro, bairro, cidade, estado, pais, cep) "
                + "values('" + clienteEndereco.getLogradouro() + "','"
                + clienteEndereco.getBairro() + "','"
                + clienteEndereco.getCidade() + "','"
                + clienteEndereco.getEstado() + "','"
                + clienteEndereco.getEstado() + "','"
                + clienteEndereco.getPais() + "','"
                + clienteEndereco.getCep() + "')";
        stm.execute(sql, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = stm.getGeneratedKeys();
        rs.next();
        int key = rs.getInt(1);
        clienteEndereco.setPkEndereco(key);
        return key;
    }

    public static ClienteEndereco retreave(int pkClienteEndereco) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select * from clientes_enderecos where pk_Endereco = " + pkClienteEndereco;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ClienteEndereco(
                rs.getString("logradouro"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getString("cep"),
                rs.getInt("pk_endereco"),
                rs.getInt("fk_cliente"));
    }

    public static ClienteEndereco retreaveByCliente(int fkCliente) throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select * from clientes_enderecos where fk_cliente = " + fkCliente;

        ResultSet rs = stm.executeQuery(sql);
        rs.next();
        return new ClienteEndereco(
                rs.getString("logradouro"),
                rs.getString("bairro"),
                rs.getString("cidade"),
                rs.getString("estado"),
                rs.getString("pais"),
                rs.getString("cep"),
                rs.getInt("pk_endereco"),
                rs.getInt("fk_cliente"));
    }

    public static ArrayList<ClienteEndereco> retreaveAll() throws SQLException {
        Statement stm = BancoDados.createConnection().createStatement();
        String sql = "select * from clientes_enderecos";

        ResultSet rs = stm.executeQuery(sql);
        ArrayList<ClienteEndereco> listaEnderecos = new ArrayList<>();
        while (rs.next()) {
            listaEnderecos.add(
                    new ClienteEndereco(
                            rs.getString("logradouro"),
                            rs.getString("bairro"),
                            rs.getString("cidade"),
                            rs.getString("estado"),
                            rs.getString("pais"),
                            rs.getString("cep"),
                            rs.getInt("pk_endereco"),
                            rs.getInt("fk_cliente")));
        }
        return listaEnderecos;
    }
}
