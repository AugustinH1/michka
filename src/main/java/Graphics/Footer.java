package Graphics;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class Footer extends HBox {

    private TextField numRueField;
    private TextField nomRueField;
    private TextField codePostalField;
    private TextField villeField;
    private Button addButton;

    public Footer() {
        // Création des champs de texte
        numRueField = new TextField();
        numRueField.setPromptText("Numéro de rue");

        nomRueField = new TextField();
        nomRueField.setPromptText("Nom de rue");

        codePostalField = new TextField();
        codePostalField.setPromptText("Code postal");

        villeField = new TextField();
        villeField.setPromptText("Ville");

        // Création du bouton Ajouter
        addButton = new Button("Ajouter");

        // Gestionnaire d'événements pour le clic sur le bouton Ajouter
        addButton.setOnAction(event -> {
            String numRue = numRueField.getText();
            String nomRue = nomRueField.getText();
            String codePostal = codePostalField.getText();
            String ville = villeField.getText();

            // Ajoutez ici la logique pour traiter les données saisies
            System.out.println("Données saisies : Numéro de rue : " + numRue + ", Nom de rue : " + nomRue +
                    ", Code postal : " + codePostal + ", Ville : " + ville);
        });

        // Ajout des éléments au pied de la fenêtre
        this.getChildren().addAll(numRueField, nomRueField, codePostalField, villeField, addButton);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
    }
}

