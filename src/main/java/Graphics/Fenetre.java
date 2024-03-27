package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;


public class Fenetre extends Application {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    private static final AdresseRepository adresseRepository = new AdresseRepository();
    private CreationForm creationForm = new CreationForm();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(968);
        stage.setHeight(600);
        stage.setTitle("Michka");

        HBox root = new HBox(creationForm);
        stage.setScene(new Scene(root));



        stage.show();
    }

    public static void main(String[] args) {
        launch(args);

        jpaEntityManager.close();
    }

}
