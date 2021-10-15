package com.gn.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.gn.dao.ServicoDAO;
import com.gn.model.Servico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ServicoController implements Initializable {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnNExcluir;
    @FXML
    private TextField tfPesquisa;
    @FXML
    private TextField tfFuncionario;
    @FXML
    private TextField tfPreco;
    @FXML
    private TextField tfHora;
    @FXML
    private TextField tfData;
    @FXML
    private TextField tfCusto;
    @FXML
    private TableView tableView;
//    @FXML
//    private Label lbTitulo;

    ServicoDAO dao = new ServicoDAO();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    public void incluirRegistro(ActionEvent actionEvent) {
    }

    public void salvarRegistro(ActionEvent actionEvent) {
        Servico servico = new Servico();

        servico.setData(tfData.getText());
        servico.setHora(tfHora.getText());
        servico.setFuncionario(tfFuncionario.getText());
        servico.setPreco(tfPreco.getPrefWidth());
        servico.setCusto(tfCusto.getPrefWidth());

        dao.salvar(servico);
    }

    public void excluirRegistro(ActionEvent actionEvent) {
    }

    public void pesquisar(ActionEvent actionEvent) {
    }
}
