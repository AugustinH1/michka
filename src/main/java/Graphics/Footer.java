package Graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import utils.NumField;

public class Footer extends HBox {

    private NumField numRueField;
    private TextField nomRueField;
    private NumField codePostalField;
    private TextField villeField;
    private Button addButton;

    public Footer() {
        // Création des champs de texte
        numRueField = new NumField();
        numRueField.setPromptText("Numéro de rue");

        nomRueField = new TextField();
        nomRueField.setPromptText("Nom de rue");

        codePostalField = new NumField();
        codePostalField.setPromptText("Code postal");

        villeField = new TextField();
        villeField.setPromptText("Ville");

        // Création du bouton Ajouter
        addButton = new Button("Ajouter");


        // Ajout des éléments au pied de la fenêtre
        this.getChildren().addAll(numRueField, nomRueField, codePostalField, villeField, addButton);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
    }

    public Button getAddButton() {
        return addButton;
    }

    public NumField getNumRueField() {
        return numRueField;
    }

    public TextField getNomRueField() {
        return nomRueField;
    }

    public NumField getCodePostalField() {
        return codePostalField;
    }

    public TextField getVilleField() {
        return villeField;
    }
}

