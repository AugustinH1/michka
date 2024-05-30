package jpaDao;


import Dao.Dao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;


public abstract class JpaDao<T> implements Dao<T> {
    static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    static final EntityTransaction transaction = entityManager.getTransaction();

    public boolean create(T obj) {
        try {
            transaction.begin();
            entityManager.persist(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean update(T obj) {
        try {
            transaction.begin();
            entityManager.merge(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public boolean delete(T obj) {
        try {
            transaction.begin();
            entityManager.remove(obj);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }


    public boolean deleteAll(Class c) {
        try {
            transaction.begin();
            entityManager.createQuery("DELETE FROM " + c.getSimpleName()).executeUpdate();
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }
    }

    public List<T> findAll(Class c) {
        return entityManager.createQuery("SELECT a FROM " + c.getSimpleName() + " a").getResultList();
    }

    public T find(Class c, int id) {
        return (T) entityManager.find(c, id);
    }
}
