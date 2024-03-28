package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ModificationDialog extends Stage {
    private static final AdresseRepository adresseRepository = new AdresseRepository();

    private AdresseEntity adresseEntity;
    private TextField numRueField;
    private TextField nomRueField;
    private TextField codePostalField;
    private TextField villeField;

    public ModificationDialog(AdresseEntity adresseEntity) {
        this.adresseEntity = adresseEntity;

        // Création des champs de texte pour la modification
        numRueField = new TextField(String.valueOf(adresseEntity.getNumRue()));
        nomRueField = new TextField(adresseEntity.getNomRue());
        codePostalField = new TextField(adresseEntity.getCodePostal());
        villeField = new TextField(adresseEntity.getVille());

        // Création du formulaire de modification
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        gridPane.add(new Label("Numéro de rue:"), 0, 0);
        gridPane.add(numRueField, 1, 0);
        gridPane.add(new Label("Nom de rue:"), 0, 1);
        gridPane.add(nomRueField, 1, 1);
        gridPane.add(new Label("Code postal:"), 0, 2);
        gridPane.add(codePostalField, 1, 2);
        gridPane.add(new Label("Ville:"), 0, 3);
        gridPane.add(villeField, 1, 3);

        // Création des boutons de validation et d'annulation
        Button validerButton = new Button("Valider");
        validerButton.setOnAction(event -> validerModification());
        Button annulerButton = new Button("Annuler");
        annulerButton.setOnAction(event -> close());

        gridPane.add(validerButton, 0, 4);
        gridPane.add(annulerButton, 1, 4);

        // Configuration de la scène
        Scene scene = new Scene(gridPane);
        setScene(scene);

        // Configuration de la fenêtre de dialogue
        setTitle("Modifier l'adresse");
        initModality(Modality.APPLICATION_MODAL);
        setResizable(false);
    }

    private void validerModification() {
        adresseEntity.setNumRue(Integer.parseInt(numRueField.getText()));
        adresseEntity.setNomRue(nomRueField.getText());
        adresseEntity.setCodePostal(codePostalField.getText());
        adresseEntity.setVille(villeField.getText());

        adresseRepository.update(adresseEntity);

        close();
    }
}
