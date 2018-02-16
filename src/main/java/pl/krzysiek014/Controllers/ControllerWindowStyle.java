package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.krzysiek014.GoogleApi.GoogleApi;

import java.io.IOException;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerWindowStyle {

    @FXML
    VBox wall;
    @FXML
    Button addButton;
    public void initialize() throws IOException {
        GoogleApi api = new GoogleApi();

        addButton.setOnMouseClicked(e->{
            Stage addWindow = new Stage();
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("AddStreamer.fxml"));
            try {
                AnchorPane ap = loader.load();
                Scene scene = new Scene(ap);
                addWindow.setScene(scene);
                addWindow.setResizable(false);
                addWindow.initStyle(StageStyle.UTILITY);
                addWindow.show();
            } catch (IOException e1) {}
        });

    }
}
