package utils;

import javafx.scene.control.TextField;

public class NumField extends TextField {
    
    public NumField() {
        super();
        // Définir un écouteur pour contrôler le contenu du champ de texte
        this.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                this.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
    }

    public int getValue() {
        if (getText().isEmpty()) {
            return 0;
        }
        return Integer.parseInt(getText());
    }
}