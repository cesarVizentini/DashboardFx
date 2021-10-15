package com.gn.dao;

import com.gn.model.Servico;
import org.hibernate.Session;

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

}
