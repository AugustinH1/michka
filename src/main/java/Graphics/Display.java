package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

import java.util.List;

public interface Display {
    default void searchProperties(Header header, ScrollPane resultArea, AdresseRepository adresseRepository) {
        var searchText = header.getSearchField().getText();
        var classification = header.getClassificationComboBox().getValue();
        var typeBien = header.getTypeBienComboBox().getValue();
        var typeChauffage = header.getTypeChauffageComboBox().getValue();
        var typeEauChaude = header.getTypeEauChaudeComboBox().getValue();
        var result = adresseRepository.findBySearchCriteria(searchText, classification, typeBien, typeChauffage, typeEauChaude);

        VBox resultBox = new VBox();
        resultBox.setSpacing(10);
        resultBox.setPadding(new Insets(10));

        result.forEach(adresse -> {
            HBox addressBox = new HBox();
            addressBox.setStyle("-fx-background-color: #b45151; -fx-padding: 10px;");
            addressBox.setSpacing(10);

            Label addressLabel = new Label();
            addressLabel.setText("Adresse " + adresse.getId() + ":\n"
                    + "Numéro de rue: " + adresse.getNumRue() + " Nom de rue: " + adresse.getNomRue() + " Code postal: " + adresse.getCodePostal() + " Ville: " + adresse.getVille());


            Button button = new Button("Modifier");
            button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    // Ajoutez ici la logique pour gérer le clic sur le bouton
                    System.out.println("Bouton cliqué pour l'adresse : " + adresse.getId());
                }
            });

            addressBox.getChildren().addAll(addressLabel, button);
            resultBox.getChildren().addAll(addressBox);
        });

        resultArea.setContent(resultBox);
    }

    default void resetProperties(Header header, ScrollPane resultArea, AdresseRepository adresseRepository) {
        header.getSearchField().clear();
        header.getClassificationComboBox().getSelectionModel().clearSelection();
        header.getTypeBienComboBox().getSelectionModel().clearSelection();
        header.getTypeChauffageComboBox().getSelectionModel().clearSelection();
        header.getTypeEauChaudeComboBox().getSelectionModel().clearSelection();
        searchProperties(header, resultArea, adresseRepository);
    }
}
