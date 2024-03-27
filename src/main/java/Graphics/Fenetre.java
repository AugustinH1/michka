package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.util.List;


public class Fenetre extends Application implements Display {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    private static final AdresseRepository adresseRepository = new AdresseRepository();

    private Header header;
    private ScrollPane resultArea;
    private Footer footer;

    public static void main(String[] args) {
        launch(args);
        jpaEntityManager.close();
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialisation des éléments
        resultArea = new ScrollPane();
        header = new Header();
        footer = new Footer();

        searchProperties(header, resultArea, adresseRepository);
        eventHandler();

        // Création de la structure de la fenêtre
        BorderPane root = new BorderPane();
        root.setTop(header);
        root.setCenter(resultArea);
        root.setBottom(footer);

        // Affichage de la scène
        Scene scene = new Scene(root, 1200, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Application Michka");
        primaryStage.show();
    }

    private void eventHandler() {
        header.getSearchButton().setOnAction(event -> searchProperties(header, resultArea, adresseRepository));
        header.getResetButton().setOnAction(event -> resetProperties(header, resultArea, adresseRepository));
    }
}
