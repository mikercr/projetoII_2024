package bll;

import entity.Cliente;
import entity.Fatura;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Set;

public class ClienteBLL {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
    private static EntityManager em = factory.createEntityManager();
    private static EntityTransaction transaction = em.getTransaction();

    public static void criar(Cliente cli){
        transaction.begin();
        em.persist(cli);
        transaction.commit();
    }

    public static void apagar(Cliente cli){
        transaction.begin();
        em.remove(cli);
        transaction.commit();
    } 

    public static Cliente findCliente(long id){
        return em.find(Cliente.class, id);
    }

    public static Set<Fatura> findFaturasCliente(long id){
        Cliente cli = em.find(Cliente.class, id);
        return cli.getFaturas();
    }

    public static List<Cliente> listar(){
        return em.createQuery("from Cliente").getResultList();
    }

    public static List<Cliente> listarWithName(String name){
        return em.createQuery("from Cliente where name like ?1").setParameter(1, name).getResultList();
    }





}
