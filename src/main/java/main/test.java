package main;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;


public class test {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    private static final AdresseRepository adresseRepository = new AdresseRepository();

    public static void main(String[] args) {
        var test = adresseRepository.findAll();


        jpaEntityManager.close();
    }
}
