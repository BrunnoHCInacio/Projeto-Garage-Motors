/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetogaragemotors.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author brunn
 */
public class FXMLCadastroClienteController implements Initializable {

    private Cliente cliente;
    private ClienteEndereco clienteEndereco;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldCpf;

    @FXML
    private TextField textFieldLogradouro;

    @FXML
    private TextField textFieldBairro;

    @FXML
    private TextField textFieldCidade;

    @FXML
    private TextField textFieldCep;

    @FXML
    private ComboBox<String> comboEstado;

    @FXML
    private ComboBox<String> comboPais;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboEstado.getItems().addAll("AC", "AL", "AM", "AP", "BA", "CE", "DF", "ES", "GO",
                "MA", "MG", "MS", "MT", "PA", "PB", "PE", "PI", "PR",
                "RJ", "RN", "RO", "RS", "SC", "SE", "SP", "TO");
        comboPais.getItems().add("Brasil");
        // TODO
    }

    public void limpaTela() {
        textFieldNome.clear();
        textFieldCpf.clear();
        textFieldLogradouro.clear();
        textFieldBairro.clear();
        textFieldCidade.clear();
        textFieldCep.clear();
        comboEstado.getSelectionModel().clearSelection();
        comboPais.getSelectionModel().clearSelection();
    }

    public void save() {
        boolean salvar = false;

        if (cliente == null) {
            cliente = new Cliente();
            clienteEndereco = new ClienteEndereco();
            salvar = true;
        }
        
        cliente.setNome(textFieldNome.getText());
        cliente.setCpf(textFieldCep.getText());
        cliente.setClienteEndereco(clienteEndereco);
        
        clienteEndereco.setLogradouro(textFieldLogradouro.getText());
        clienteEndereco.setBairro(textFieldBairro.getText());
        clienteEndereco.setCidade(textFieldCidade.getText());
        clienteEndereco.setEstado(comboEstado.getValue());
        clienteEndereco.setPais(comboPais.getValue());
        clienteEndereco.setCep(textFieldCep.getText());
        if(salvar){
            try {
                cliente.save();
            } catch (SQLException ex) {
                Logger.getLogger(FXMLCadastroClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            cliente.update();
        }
    }
    public void cancelar(){
        limpaTela();
    }

}
