package Graphics;

import Entity.AdresseEntity;
import Jpa.AdresseRepository;
import Jpa.JpaEntityManager;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Set;


public class Fenetre extends Application {
    private static final JpaEntityManager jpaEntityManager = new JpaEntityManager();
    private static final AdresseRepository adresseRepository = new AdresseRepository();

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(1024);
        stage.setHeight(968);
        stage.setTitle("Michka");

        createButton(stage);



        stage.show();
    }

    private void createButton(Stage stage) {
        Button buttonCreateForm = new Button("Créer Bien");

        buttonCreateForm.setOnAction(event -> {
            stage.setScene(new Scene(new CreationForm()));
            stage.show();
        });


        VBox root = new VBox(buttonCreateForm);
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);

        jpaEntityManager.close();
    }

}
