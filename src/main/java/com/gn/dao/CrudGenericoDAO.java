package com.gn.dao;

import com.gn.model.Servico;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CrudGenericoDAO<Classe> {

    public boolean salvar(Classe classe) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.merge(classe);
            session.getTransaction().commit();
            session.close();
            return true;
        } catch (Exception erro) {
            System.out.println("Ocorreou o erro: " + erro);
            return false;
        }
    }

    public List<Classe> consultar(String descricao, String nomeClasse) {

        List<Classe> lista = new ArrayList<>();
        Session session = ConexaoBanco.getSessionFactory().openSession();
        session.beginTransaction();
        if (descricao.length() == 0) {
            lista = session.createQuery(" from " + nomeClasse).getResultList();
        } else {
            // t é o apelido da tabela
            // comando para realizar uma busca com retorno de tudo que comeca com o que foi digitado
            lista = session.createQuery(" from " + nomeClasse + " m where m.descricao like " + "'" + descricao + "%'").getResultList();
        }
        session.getTransaction().commit();
        session.close();

        return lista;
    }

    public void excluir(Classe classe) {
        try {
            Session session = ConexaoBanco.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(classe);
            session.getTransaction().commit();
            session.close();
            System.out.println("Registro excluido com sucessi");
        } catch (Exception erro) {
            System.out.println("Ocorreou o erro: " + erro);
        }
    }

}
