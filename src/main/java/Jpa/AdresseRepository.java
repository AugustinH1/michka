package Jpa;

import Entity.AdresseEntity;

import java.util.List;


public class AdresseRepository extends JpaEntityManager {

    public void create(AdresseEntity adresse) {
        transaction.begin();
        entityManager.persist(adresse);
        transaction.commit();
    }

    public List<AdresseEntity> findAll() {
        return entityManager.createQuery("SELECT a FROM AdresseEntity a", AdresseEntity.class).getResultList();
    }

    public AdresseEntity findById(Integer id) {
        return entityManager.find(AdresseEntity.class, id);
    }

    public void update(AdresseEntity adresse) {
        transaction.begin();
        entityManager.merge(adresse);
        transaction.commit();
    }

    public void delete(AdresseEntity adresse) {
        transaction.begin();
        entityManager.remove(adresse);
        transaction.commit();
    }
}
