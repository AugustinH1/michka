package Graphics;

import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import Enum.*;
import javafx.scene.layout.VBox;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Header extends HBox {
    private TextField searchField;
    private ComboBox<String> typeBienComboBox;
    private ComboBox<String> typeChauffageComboBox;
    private ComboBox<String> typeEauChaudeComboBox;
    private ComboBox<String> classificationComboBox;
    private Button searchButton;
    private Button resetButton;


    public Header() {
        searchField = new TextField();
        typeBienComboBox = new ComboBox<>();
        typeChauffageComboBox = new ComboBox<>();
        typeEauChaudeComboBox = new ComboBox<>();
        classificationComboBox = new ComboBox<>();

        searchField.setPromptText("Rechercher");
        //ajouter l'ENUM ClassificationBien
        Arrays.stream(ClassificationBien.values()).forEach(classification ->
                classificationComboBox.getItems().add(classification.toString()));

        Arrays.stream(TypeBien.values()).forEach(typeBien ->
                typeBienComboBox.getItems().add(typeBien.toString()));

        Arrays.stream(TypeChauffage.values()).forEach(typeChauffage ->
                typeChauffageComboBox.getItems().add(typeChauffage.toString()));

        Arrays.stream(TypeEauChaude.values()).forEach(typeEauChaude ->
                typeEauChaudeComboBox.getItems().add(typeEauChaude.toString()));

        Label classificationLabel = new Label("Classification : ");
        Label typeBienLabel = new Label("Type de bien : ");
        Label typeChauffageLabel = new Label("Type de chauffage : ");
        Label typeEauChaudeLabel = new Label("Type d'eau chaude : ");

        VBox classificationBox = new VBox();
        VBox typeBienBox = new VBox();
        VBox typeChauffageBox = new VBox();
        VBox typeEauChaudeBox = new VBox();

        classificationBox.getChildren().addAll(classificationLabel, classificationComboBox);
        typeBienBox.getChildren().addAll(typeBienLabel, typeBienComboBox);
        typeChauffageBox.getChildren().addAll(typeChauffageLabel, typeChauffageComboBox);
        typeEauChaudeBox.getChildren().addAll(typeEauChaudeLabel, typeEauChaudeComboBox);


        searchButton = new Button("Rechercher");
        resetButton = new Button("Réinitialiser");


        this.getChildren().addAll(searchField, classificationBox, typeBienBox, typeChauffageBox, typeEauChaudeBox, searchButton, resetButton);
        this.setSpacing(10);
        this.setPadding(new Insets(10));
    }


    public Button getSearchButton() {
        return searchButton;
    }

    public Button getResetButton() {
        return resetButton;
    }

    public TextField getSearchField() {
        return searchField;
    }

    public ComboBox<String> getTypeBienComboBox() {
        return typeBienComboBox;
    }

    public ComboBox<String> getTypeChauffageComboBox() {
        return typeChauffageComboBox;
    }

    public ComboBox<String> getTypeEauChaudeComboBox() {
        return typeEauChaudeComboBox;
    }

    public ComboBox<String> getClassificationComboBox() {
        return classificationComboBox;
    }
}