package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;

public class AdresseBox extends HBox {
    private AdresseEntity adresseEntity;
    private Label addressLabel;
    private Button modifyButton;
    private Button removeButton;

    public AdresseBox(AdresseEntity adresseEntity, ResultArea resultArea) {
        this.adresseEntity = adresseEntity;
        this.setStyle("-fx-background-color: #af9bdc; -fx-padding: 10px;");
        this.setSpacing(10);

        this.setPrefWidth(0.9 * resultArea.getWidth());


        addressLabel = new Label();
        addressLabel.setText(
                "Numéro de rue: " + adresseEntity.getNumRue()
                        + ", Nom de rue: " + adresseEntity.getNomRue()
                        + ", Code postal: " + adresseEntity.getCodePostal()
                        + ", Ville: " + adresseEntity.getVille());

        modifyButton = new Button("Modifier");
        modifyButton.setOnAction(event -> modifyAddress());

        removeButton = new Button("Supprimer");
        removeButton.setOnAction(event -> removeAddress());

        // Create a flexible region to push the buttons to the right
        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        this.getChildren().addAll(addressLabel, spacer, modifyButton, removeButton);
    }

    private void modifyAddress() {
        ModificationDialog dialog = new ModificationDialog(adresseEntity);
        dialog.showAndWait();
    }

    private void removeAddress() {
        AdresseRepository adresseRepository = new AdresseRepository();
        adresseRepository.delete(adresseEntity);
    }
}

