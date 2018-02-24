package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import pl.krzysiek014.Main.Settings;

import java.io.IOException;

/**
 * Created by Krzysiek014 on 24.02.2018.
 */
public class ControllerSettingsWindow {

    @FXML
    private CheckBox showOffline, hideButtons, enableAuto;
    @FXML
    private Button saveButton, cancelButton;
    public void initialize(){

        saveButton.setOnAction(e->{
            Settings.getInstance().setProperty("show-offline",Boolean.toString(showOffline.isSelected()));
            Settings.getInstance().setProperty("hide-buttons",Boolean.toString(hideButtons.isSelected()));
            Settings.getInstance().setProperty("auto-refresh",Boolean.toString(enableAuto.isSelected()));
            try {
                Settings.getInstance().saveProperties();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ((Node) e.getSource()).getScene().getWindow().hide();
        });

    }
}