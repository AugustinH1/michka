package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;
import java.util.Set;


public class Fenetre extends Application {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    private static final AdresseRepository adresseRepository = new AdresseRepository();
    private CreationForm creationForm;
    private ScrollPane resultArea;


    @Override
    public void start(Stage primaryStage) {
        // Création des éléments de l'interface utilisateur
        TextField searchField = new TextField();
        Button searchButton = new Button("Rechercher");
        resultArea = new ScrollPane();
        creationForm = new CreationForm();

        // Gestionnaire d'événements pour le bouton "Rechercher"
        searchButton.setOnAction(event -> searchProperties(searchField.getText()));

        // Création du layout principal
        BorderPane root = new BorderPane();
        HBox searchBox = new HBox(10, searchField, searchButton);
        searchBox.setPadding(new Insets(10));
        root.setTop(searchBox);
        root.setCenter(resultArea);
        root.setBottom(creationForm);

        // Affichage de la scène
        Scene scene = new Scene(root, 1400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Real Estate App");
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    // Méthode pour effectuer la recherche des biens en fonction des critères saisis
    private void searchProperties(String searchText) {
        var result = searchText.isEmpty() ? adresseRepository.findAll() : adresseRepository.findByVille(searchText);

        VBox resultBox = new VBox();
        resultBox.setSpacing(10);
        resultBox.setPadding(new Insets(10));

        for (AdresseEntity adresse : result) {
            Label addressLabel = new Label();
            addressLabel.setStyle("-fx-background-color: #b45151; -fx-padding: 10px; -fx-min-width: 90%");
            addressLabel.setText("Adresse " + adresse.getId() + ":\n"
                    + "Numéro de rue: " + adresse.getNumRue() + " Nom de rue: " + adresse.getNomRue() + " Code postal: " + adresse.getCodePostal() + " Ville: " + adresse.getVille());
            resultBox.getChildren().add(addressLabel);
        }

        resultArea.setContent(resultBox);
    }

    public static void main(String[] args) {
        launch(args);

        jpaEntityManager.close();
    }

}
