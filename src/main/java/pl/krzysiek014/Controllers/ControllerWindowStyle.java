package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.VBox;
import pl.krzysiek014.GoogleApi.GoogleApi;

import java.io.IOException;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerWindowStyle {

    @FXML
    VBox wall;


    public void initialize() throws IOException {
        GoogleApi api = new GoogleApi();
    }
}
