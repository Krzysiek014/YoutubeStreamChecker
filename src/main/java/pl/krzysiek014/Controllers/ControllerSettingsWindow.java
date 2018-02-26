package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import pl.krzysiek014.Main.Settings;

import java.io.IOException;

/**
 * Created by Krzysiek014 on 24.02.2018.
 */
public class ControllerSettingsWindow {

    @FXML
    private CheckBox showOffline, hideButtons, enableAuto, showTitle;
    @FXML
    private Button saveButton, cancelButton;
    @FXML
    Slider timeInterval;
    public void initialize(){

        showOffline.setSelected(Boolean.parseBoolean(Settings.getInstance().getProperty("show-offline")));
        hideButtons.setSelected(Boolean.parseBoolean(Settings.getInstance().getProperty("hide-buttons")));
        showTitle.setSelected(Boolean.parseBoolean(Settings.getInstance().getProperty("show-title")));
        enableAuto.setSelected(Boolean.parseBoolean(Settings.getInstance().getProperty("auto-refresh")));
        timeInterval.setValue(Double.valueOf(Settings.getInstance().getProperty("time-interval")));

        saveButton.setOnAction(e->{
            Settings.getInstance().setProperty("show-offline",Boolean.toString(showOffline.isSelected()));
            Settings.getInstance().setProperty("hide-buttons",Boolean.toString(hideButtons.isSelected()));
            Settings.getInstance().setProperty("show-title",Boolean.toString(showTitle.isSelected()));
            Settings.getInstance().setProperty("auto-refresh",Boolean.toString(enableAuto.isSelected()));
            Settings.getInstance().setProperty("time-interval",String.valueOf(timeInterval.getValue()));
            try {
                Settings.getInstance().saveProperties();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            ((Node) e.getSource()).getScene().getWindow().hide();
        });

        cancelButton.setOnAction(e-> ((Node) e.getSource()).getScene().getWindow().hide());
    }
}