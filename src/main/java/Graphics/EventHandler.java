package Graphics;

import ApiAdressGouv.Properties;
import Dao.DaoAdresse;
import Dao.DaoBien;
import Entity.AdresseEntity;
import Entity.BienEntity;
import jpaDao.JpaDaoBien;

import java.util.Set;

public interface EventHandler {
    default void searchProperties(Header header, ResultArea resultArea, DaoAdresse adresseManager) {
        var searchText = header.getSearchField().getText();
        var classification = header.getClassificationComboBox().getValue();
        var typeBien = header.getTypeBienComboBox().getValue();
        var typeChauffage = header.getTypeChauffageComboBox().getValue();
        var typeEauChaude = header.getTypeEauChaudeComboBox().getValue();

        var result = adresseManager.findBySearchCriteria(searchText, classification, typeBien, typeChauffage, typeEauChaude);

        resultArea.displayResults(result);
    }

    default void resetProperties(Header header, ResultArea resultArea, DaoAdresse adresseManager) {
        header.getSearchField().clear();
        header.getClassificationComboBox().getSelectionModel().clearSelection();
        header.getTypeBienComboBox().getSelectionModel().clearSelection();
        header.getTypeChauffageComboBox().getSelectionModel().clearSelection();
        header.getTypeEauChaudeComboBox().getSelectionModel().clearSelection();
        searchProperties(header, resultArea, adresseManager);
    }

    default void addAddress(Footer footer, DaoAdresse adresseManager) throws Exception {
        Integer numRue = footer.getNumRueField().getValue();
        String nomRue = footer.getNomRueField().getText();
        String codePostal = footer.getCodePostalField().getText();
        String ville = footer.getVilleField().getText();

        if (numRue == null || nomRue.isEmpty() || codePostal.isEmpty() || ville.isEmpty()) {
            System.out.println("Veuillez remplir tous les champs");
            return;
        }

        SugestedAdressDialog dialog = new SugestedAdressDialog(numRue, nomRue, codePostal, ville);
        dialog.showAndWait();
        Properties address = dialog.getSelectedAddress();

        if (address == null) {
            System.out.println("Aucune adresse sélectionnée");
            return;
        }

        numRue =  address.getHousenumber() == null ? null : Integer.valueOf(address.getHousenumber());
        nomRue = address.getStreet();
        codePostal = address.getPostcode();
        ville = address.getCity();


        //String typeEauChaude, String chauffage, String typeBien String classification
        var typeEauChaude = footer.getTypeEauChaude() == null ? null : footer.getTypeEauChaude().toString();
        var chauffage = footer.getTypeChauffage() == null ? null : footer.getTypeChauffage().toString();
        var typeBien = footer.getTypeBien() == null ? null : footer.getTypeBien().toString();
        var classification = footer.getClassification() == null ? null : footer.getClassification().toString();

        var bien = new BienEntity(typeEauChaude, chauffage, typeBien, classification);

        var adresse = new AdresseEntity(numRue, nomRue, codePostal, ville, Set.of(bien));
        adresse.getBiens().forEach(bienEntity -> {
            bienEntity.setAdresse(adresse);
            DaoBien bienManager = new JpaDaoBien();
            bienManager.create(bienEntity);
        });
        adresseManager.create(adresse);

        System.out.println("Données saisies : Numéro de rue : " + numRue + ", Nom de rue : " + nomRue +
                ", Code postal : " + codePostal + ", Ville : " + ville);

        footer.getNumRueField().clear();
        footer.getNomRueField().clear();
        footer.getCodePostalField().clear();
        footer.getVilleField().clear();
    }
}
