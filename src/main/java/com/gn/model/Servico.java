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
    private int ID;
    @Column(name = "data", nullable = false)
    private String data;
    @Column(name = "hora", nullable = false)
    private String hora;
    @Column(name = "funcionario", nullable = false)
    private String funcionario;
    @Column(name = "preco", nullable = false)
    private double preco;
    @Column(name = "custo", nullable = false)
    private double custo;

    public Servico() { }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
