package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CreationForm extends VBox {
    private static final AdresseRepository adresseRepository = new AdresseRepository();
    private TextField numRueField;
    private TextField nomRueField;
    private TextField codePostalField;
    private TextField villeField;
    private Button createButton;

    public CreationForm() {
        // Création des champs de texte
        numRueField = new TextField();
        nomRueField = new TextField();
        codePostalField = new TextField();
        villeField = new TextField();

        // Création des étiquettes pour chaque champ
        Label numRueLabel = new Label("Numéro de rue:");
        Label nomRueLabel = new Label("Nom de rue:");
        Label codePostalLabel = new Label("Code postal:");
        Label villeLabel = new Label("Ville:");

        createButton = new Button("Créer");
        setCreateButtonAction();

        // Configuration du formulaire
        this.setSpacing(10);
        this.setPadding(new Insets(10));

        // Ajout des étiquettes et des champs au formulaire
        this.getChildren().addAll(
                numRueLabel, numRueField,
                nomRueLabel, nomRueField,
                codePostalLabel, codePostalField,
                villeLabel, villeField,
                createButton
        );
    }

    public void setCreateButtonAction() {
        createButton.setOnAction(event -> {
            AdresseEntity adresse = new AdresseEntity();

            adresse.setNumRue(Integer.parseInt(numRueField.getText()));
            adresse.setNomRue(nomRueField.getText());
            adresse.setCodePostal(codePostalField.getText());
            adresse.setVille(villeField.getText());
            adresseRepository.create(adresse);

        });
    }
}
