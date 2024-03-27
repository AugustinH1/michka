package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import utils.NumField;

public class CreationForm extends GridPane {
    private NumField numRueField;
    private TextField nomRueField;
    private TextField codePostalField;
    private TextField villeField;

    private static final AdresseRepository adresseRepository = new AdresseRepository();

    public CreationForm() {
        // Création des champs de texte pour le formulaire de création d'adresse
        numRueField = new NumField();
        nomRueField = new TextField();
        codePostalField = new TextField();
        villeField = new TextField();

        // Création des étiquettes pour chaque champ
        Label numRueLabel = new Label("Numéro de rue:");
        Label nomRueLabel = new Label("Nom de rue:");
        Label codePostalLabel = new Label("Code postal:");
        Label villeLabel = new Label("Ville:");

        // Création du bouton "Créer"
        Button createButton = new Button("Créer");
        createButton.setOnAction(event -> createAddress());

        // Création d'une boîte horizontale pour le bouton "Créer"
        HBox buttonBox = new HBox(createButton);
        buttonBox.setPadding(new Insets(10));
        buttonBox.setSpacing(10);
        buttonBox.setStyle("-fx-alignment: center-right");

        // Création du formulaire de création d'adresse
        setHgap(10);
        setVgap(5);
        addRow(0, numRueLabel, numRueField);
        addRow(0, nomRueLabel, nomRueField);
        addRow(0, codePostalLabel, codePostalField);
        addRow(0, villeLabel, villeField);
        addRow(0, buttonBox);
    }

    // Méthode pour créer une nouvelle adresse
    private void createAddress() {
        // Récupérer les valeurs des champs de texte
        Integer numRue = numRueField.getValue();
        String nomRue = nomRueField.getText();
        String codePostal = codePostalField.getText();
        String ville = villeField.getText();

        adresseRepository.create(new AdresseEntity(numRue, nomRue, codePostal, ville));

        // Vous pouvez implémenter la logique pour créer une adresse avec les valeurs saisies ici
        System.out.println("Nouvelle adresse créée : " + numRue + " " + nomRue + ", " + codePostal + " " + ville);
    }
}
