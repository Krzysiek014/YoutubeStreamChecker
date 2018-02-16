package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerAddStreamer {

    @FXML
    private Button addButton, checkButton;
    @FXML
    private TextField idText;

    public void initialize(){

        // Init button actions
        addButton.setOnMouseClicked(e->{
            ((Node)e.getSource()).getScene().getWindow().hide();
        });

        checkButton.setOnMouseClicked(e->{

        });

    }

}
