package Graphics;

import ApiAdressGouv.Properties;
import Entity.AdresseEntity;
import Jpa.AdresseRepository;

public interface EventHandler {
    default void searchProperties(Header header, ResultArea resultArea, AdresseRepository adresseRepository) {
        var searchText = header.getSearchField().getText();
        var classification = header.getClassificationComboBox().getValue();
        var typeBien = header.getTypeBienComboBox().getValue();
        var typeChauffage = header.getTypeChauffageComboBox().getValue();
        var typeEauChaude = header.getTypeEauChaudeComboBox().getValue();

        var result = adresseRepository.findBySearchCriteria(searchText, classification, typeBien, typeChauffage, typeEauChaude);

        resultArea.displayResults(result);
    }

    default void resetProperties(Header header, ResultArea resultArea, AdresseRepository adresseRepository) {
        header.getSearchField().clear();
        header.getClassificationComboBox().getSelectionModel().clearSelection();
        header.getTypeBienComboBox().getSelectionModel().clearSelection();
        header.getTypeChauffageComboBox().getSelectionModel().clearSelection();
        header.getTypeEauChaudeComboBox().getSelectionModel().clearSelection();
        searchProperties(header, resultArea, adresseRepository);
    }

    default void addAddress(Footer footer, AdresseRepository adresseRepository) throws Exception {
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

        numRue = Integer.valueOf(address.getHousenumber());
        nomRue = address.getStreet();
        codePostal = address.getPostcode();
        ville = address.getCity();

        adresseRepository.create(new AdresseEntity(numRue, nomRue, codePostal, ville));

        System.out.println("Données saisies : Numéro de rue : " + numRue + ", Nom de rue : " + nomRue +
                ", Code postal : " + codePostal + ", Ville : " + ville);

        footer.getNumRueField().clear();
        footer.getNomRueField().clear();
        footer.getCodePostalField().clear();
        footer.getVilleField().clear();
    }
}