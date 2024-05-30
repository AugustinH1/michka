package Graphics;

import Dao.DaoAdresse;
import Entity.AdresseEntity;
import Entity.BienEntity;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import jpaDao.JpaDaoAdresse;
import jpaDao.JpaDaoBien;

import java.util.Objects;

public class AdresseBox extends HBox {
    private static final DaoAdresse adresseManager = new JpaDaoAdresse();
    private static final JpaDaoBien bienManager = new JpaDaoBien();
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
        var text = "Numéro de rue: " + adresseEntity.getNumRue()
                + ", Nom de rue: " + adresseEntity.getNomRue()
                + ", Code postal: " + adresseEntity.getCodePostal()
                + ", Ville: " + adresseEntity.getVille();

        if (adresseEntity.getBiens() != null || !adresseEntity.getBiens().isEmpty()) {
            text += ", Classification: " + adresseEntity.getBiens()
                        .stream()
                        .map(BienEntity::getClassification)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse("N/A")
                    + ", Type de bien: " + adresseEntity.getBiens()
                        .stream()
                        .map(BienEntity::getTypeBien)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse("N/A")
                    + ", Type de chauffage: " + adresseEntity.getBiens()
                        .stream()
                        .map(BienEntity::getChauffage)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse("N/A")
                    + ", Type eau chaude: " + adresseEntity.getBiens()
                        .stream()
                        .map(BienEntity::getTypeEauChaude)
                        .filter(Objects::nonNull)
                        .findFirst()
                        .orElse("N/A");
        }
        addressLabel.setText(text);

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
        adresseEntity.getBiens().forEach(bienManager::delete);
        adresseManager.delete(adresseEntity);
    }
}

