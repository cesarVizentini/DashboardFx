package com.gn.dao;

import com.gn.model.Servico;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ServicoDAO {

    public void salvar(Servico servico) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(servico);
            session.getTransaction().commit();
            session.close();
            System.out.println("Servico salvo gravado com sucesso!");
        } catch (Exception erro) {
            System.out.println("Ocorreou o erro: " + erro);
        }
    }

    public List<Servico> consultar(String descricao) {

        List<Servico> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        if (descricao.length() == 0) {
            lista = session.createQuery(" from Servico ").getResultList();
        } else {
            // t é o apelido da tabela
            // comando para realizar uma busca com retorno de tudo que comeca com o que foi digitado
            lista = session.createQuery(" from Servico t where t.descricao like " + "'" + descricao + "%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();

        return lista;
    }

    public void excluir(Servico servico) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(servico);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro excluido com sucessi");
        } catch (Exception erro) {
            System.out.println("Ocorreou o erro: " + erro);
        }
    }

}
