package com.gn.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.gn.dao.ServicoDAO;
import com.gn.model.Servico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class ServicoController implements Initializable, ICadastro {

    @FXML
    private Button btnNovo;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnNExcluir;
    @FXML
    private TextField tfPesquisa;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfDescricao;
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
    private TableView<Servico> tableView;
//    @FXML
//    private Label lbTitulo;

    private ServicoDAO dao = new ServicoDAO();
    private ObservableList<Servico> observableList = FXCollections.observableArrayList();
    private List<Servico> listaServicos;
    private Servico objetoSelecionado = new Servico();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        criarColunasTabela();
        atualizarTabela();
    }

    @FXML
    public void incluirRegistro(ActionEvent actionEvent) {
        limparCamposFormulario();
    }

    @FXML
    public void salvarRegistro(ActionEvent actionEvent) {
        Servico servico = new Servico();

        if (objetoSelecionado.getID() != null) {
            servico.setID(objetoSelecionado.getID());
        }

        servico.setDescricao(tfDescricao.getText());
        servico.setData(tfData.getText());
        servico.setHora(tfHora.getText());
        servico.setFuncionario(tfFuncionario.getText());
        servico.setPreco(tfPreco.getPrefWidth());
        servico.setCusto(tfCusto.getPrefWidth());

        dao.salvar(servico);

        atualizarTabela();
        limparCamposFormulario();
    }

    @FXML
    public void excluirRegistro(ActionEvent actionEvent) {
        dao.excluir(objetoSelecionado);

        limparCamposFormulario();
        atualizarTabela();
    }

    @Override
    public void criarColunasTabela() {
        TableColumn<Servico, Long> colunaID = new TableColumn<>("ID");
        colunaID.setMinWidth(40);
        colunaID.setMaxWidth(40);
        TableColumn<Servico, String> colunaDescricao = new TableColumn<>("descricao");
        TableColumn<Servico, String> colunaData = new TableColumn<>("data");
        TableColumn<Servico, String> colunaHora = new TableColumn<>("hora");
        TableColumn<Servico, String> colunaFuncionario = new TableColumn<>("funcionario");
        TableColumn<Servico, Double> colunaPreco = new TableColumn<>("preco");
        TableColumn<Servico, Double> colunaCusto = new TableColumn<>("custo");

        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        tableView.getColumns().addAll(colunaID, colunaDescricao, colunaData, colunaHora, colunaFuncionario, colunaPreco, colunaCusto);

        colunaID.setCellValueFactory(new PropertyValueFactory("ID"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        colunaData.setCellValueFactory(new PropertyValueFactory("data"));
        colunaHora.setCellValueFactory(new PropertyValueFactory("hora"));
        colunaFuncionario.setCellValueFactory(new PropertyValueFactory("funcionario"));
        colunaPreco.setCellValueFactory(new PropertyValueFactory("preco"));
        colunaCusto.setCellValueFactory(new PropertyValueFactory("custo"));
    }

    @Override
    public void atualizarTabela() {
        observableList.clear();
        listaServicos = dao.consultar(tfPesquisa.getText());

        for (Servico s : listaServicos) {
            observableList.add(s);
        }

        tableView.getItems().setAll(observableList);
        tableView.getSelectionModel().selectFirst();

    }

    @Override
    public void setCamposFormulario() {
        objetoSelecionado = tableView.getItems().get(tableView.getSelectionModel().getSelectedIndex());
        tfID.setText(String.valueOf(objetoSelecionado.getID()));
        tfDescricao.setText(objetoSelecionado.getDescricao());
        tfData.setText(objetoSelecionado.getData());
        tfHora.setText(objetoSelecionado.getHora());
        tfFuncionario.setText(objetoSelecionado.getFuncionario());
        tfPreco.setText(String.valueOf(objetoSelecionado.getPreco()));
        tfCusto.setText(String.valueOf(objetoSelecionado.getCusto()));
    }

    @Override
    public void limparCamposFormulario() {
        objetoSelecionado = null;
        tfID.clear();
        tfDescricao.clear();
        tfData.clear();
        tfHora.clear();
        tfFuncionario.clear();
        tfPreco.clear();
        tfCusto.clear();
        tfDescricao.requestFocus();
    }

    @FXML
    public void filtrarRegistros(KeyEvent keyEvent) {
        atualizarTabela();
    }

    @FXML
    public void clicarTabela(MouseEvent mouseEvent) {
        setCamposFormulario();
    }

    public void pesquisar(ActionEvent actionEvent) {

    }

}
