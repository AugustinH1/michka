package Jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaEntityManager {
    protected static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    protected static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    protected static final EntityTransaction transaction = entityManager.getTransaction();

    public void close(){
        entityManager.close();
        entityManagerFactory.close();
    }
}
