package application;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("exemplo-jpa");
        EntityManager em = emf.createEntityManager();) {


            Pessoa p = em.find(Pessoa.class, 2);
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();

        }
        System.out.println("Pronto!");
    }
}
