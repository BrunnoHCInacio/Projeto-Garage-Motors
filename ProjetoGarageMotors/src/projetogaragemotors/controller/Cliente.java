/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetogaragemotors.controller;

/**
 *
 * @author brunn
 */
public class Cliente {

    private int pkCliente;
    private String nome;
    private String cpf;

    private ClienteEndereco clienteEndereco;

    public Cliente() {
    }

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.clienteEndereco = clienteEndereco;
    }

    public Cliente(int pkCliente, String nome, String cpf, ClienteEndereco clienteEndereco) {
        this.pkCliente = pkCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.clienteEndereco = clienteEndereco;
    }

    public int getPkCliente() {
        return pkCliente;
    }

    public void setPkCliente(int pkCliente) {
        this.pkCliente = pkCliente;
        this.clienteEndereco.setFkCliente(pkCliente);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ClienteEndereco getClienteEndereco() {
        return clienteEndereco;
    }

    public void setClienteEndereco(ClienteEndereco clienteEndereco) {
        this.clienteEndereco = clienteEndereco;
    }
    
    public void save(){
        
    }
    public void search(){
        
    }
    public void update(){
        
    }
    public void delete(){
        
    }
   
}
