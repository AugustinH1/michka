import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;


public class test {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    public static void main(String[] args) {
        AdresseRepository adresseRepository = new AdresseRepository();
        AdresseEntity adresse = new AdresseEntity();
        adresse.setCodePostal("33");
        adresseRepository.create(adresse);
        adresse.setCodePostal("44");
        adresseRepository.create(adresse);

        adresseRepository.findAll();


        jpaEntityManager.close();
    }
}
