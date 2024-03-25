package Graphics;

import javafx.application.Application;
import javafx.stage.Stage;


public class main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.setWidth(1024);
        stage.setHeight(968);
        stage.setTitle("JavaFX Xebia");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
