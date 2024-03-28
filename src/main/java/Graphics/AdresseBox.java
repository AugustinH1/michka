package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AdresseBox extends HBox {
    private int id;
    private AdresseEntity adresseEntity;
    private Label addressLabel;
    private Button modifyButton;

    public AdresseBox(AdresseEntity adresseEntity) {
        this.id = adresseEntity.getId();
        this.adresseEntity = adresseEntity;
        this.setStyle("-fx-background-color: #b45151; -fx-padding: 10px;");
        this.setSpacing(10);

        addressLabel = new Label();
        addressLabel.setText("Adresse " + adresseEntity.getId() + ":\n"
                + "Numéro de rue: " + adresseEntity.getNumRue()
                + ", Nom de rue: " + adresseEntity.getNomRue()
                + ", Code postal: " + adresseEntity.getCodePostal()
                + ", Ville: " + adresseEntity.getVille());

        modifyButton = new Button("Modifier");
        modifyButton.setOnAction(event -> {modifyAddress();});

        this.getChildren().addAll(addressLabel, modifyButton);
    }

    private void modifyAddress() {
        ModificationDialog dialog = new ModificationDialog(adresseEntity);
        dialog.showAndWait();
    }

    public AdresseEntity getAdresseEntity() {
        return adresseEntity;
    }

    public Button getModifyButton() {
        return modifyButton;
    }
}

