package bll;
import entity.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;

public class ClienteBLL {


    public static void criar(Cliente cli){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.persist(cli);
        em.getTransaction().commit();
    }

    public static void apagar(Cliente cli){
        EntityManager em = DbConnection.getEntityManager();
        em.getTransaction().begin();
        em.remove(cli);
        em.getTransaction().commit();
    }

    public static Cliente findCliente(long id){
        return DbConnection.getEntityManager().find(Cliente.class, id);
    }

    public static Set<Fatura> findFaturasCliente(long id){
        Cliente cli = DbConnection.getEntityManager().find(Cliente.class, id);
        return cli.getFaturas();
    }

    public static List<Cliente> listar(){
        return DbConnection.getEntityManager().createQuery("from Cliente").getResultList();
    }

    public static List<Cliente> listarWithName(String name){
        return DbConnection.getEntityManager().createQuery("from Cliente where name like ?1").setParameter(1, name).getResultList();
    }





}
