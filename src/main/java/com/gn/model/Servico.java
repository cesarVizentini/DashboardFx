package com.gn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="sevico")
public class Servico implements Serializable {

    // mudar tipos String, hora e funcionario

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long ID;
    @Column(name = "descricao", nullable = false)
    private String descricao;
    @Column(name = "data", nullable = false)
    private String data;
    @Column(name = "hora", nullable = false)
    private String hora;
    @Column(name = "funcionario", nullable = false)
    private String funcionario;
    @Column(name = "preco", nullable = false)
    private Double preco;
    @Column(name = "custo", nullable = false)
    private Double custo;

    public Servico() { }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(String funcionario) {
        this.funcionario = funcionario;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getCusto() {
        return custo;
    }

    public void setCusto(Double custo) {
        this.custo = custo;
    }
}
