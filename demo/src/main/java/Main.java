import bll.ClienteBLL;
import entity.Cliente;
import entity.Fatura;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.metamodel.Metamodel;
import jakarta.transaction.Transaction;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String args[]){

/*
        Cliente cliente = new Cliente();
        cliente.setName("Josefina");
        cliente.setAddress("Rua ondelamora, 123");
        cliente.setPostalCode("4950-123");
        cliente.setNif("817364554");
        ClienteBLL.criar(cliente);
*/
        Cliente cli = ClienteBLL.findCliente(10);
        System.out.println(cli.getName());

        for(Fatura fat : cli.getFaturas()){
            System.out.println(fat.getId() + " --> " + fat.getTotalFatura());
        }


/*
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
        EntityManager em = factory.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
*/
/*
        try{
            transaction.begin();
            Cliente cli = new Cliente();
            cli.setName("Anacleto");
            cli.setAddress("Rua do Sobe e Desce, 321");
            cli.setNif("987654321");
            cli.setPostalCode("8000");

            em.persist(cli);


            transaction.commit();
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }

        Cliente cli1 = new Cliente();
        cli1 = em.find(Cliente.class, 10);

        System.out.println(cli1.getName() + "\t " + cli1.getPostalCode());
        for(Fatura fat : cli1.getFaturas()){
            System.out.println(fat.getId() + ": " + fat.getTotalFatura());
        }


        Query q = em.createQuery("from Cliente Where name LIKE ?1")
                .setParameter(1, "%Zac%");

        List<Cliente> lista = q.getResultList();
        for(Cliente c : lista)
            System.out.println(c.getName());

*/
    }

}
