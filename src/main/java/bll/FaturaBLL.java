package bll;

import entity.Cliente;
import entity.Fatura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class FaturaBLL {

    public static void criarFatura(Cliente cli, Fatura fat){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        fat.setIdCliente(cli);
        cli.getFaturas().add(fat);
        em.persist(cli);
        em.persist(fat);
        em.getTransaction().commit();
    }

    public static void criarFatura(long idCli, Fatura fat){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        Cliente cli = em.find(Cliente.class, idCli);
        cli.getFaturas().add(fat);
        em.merge(cli);
        em.getTransaction().commit();
    }
}
