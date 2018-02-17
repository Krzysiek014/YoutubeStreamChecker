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
import pl.krzysiek014.Main.YoutubeChannel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerWindowStyle {

    @FXML
    private VBox wall;
    @FXML
    private Button addButton, refreshButton;

    public void initialize() throws IOException {

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

        refreshButton.setOnMouseClicked(e->{
            // Temporary solution while adding channels while they are not online does not work
            wall.getChildren().clear();
            try {
                Context.getInstance().setListOfChannels(Context.getInstance().readFile());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            for(YoutubeChannel yc : Context.getInstance().getListOfChannels()) {
                if(yc.isExist()) wall.getChildren().addAll();
            }

        });

        Context.getInstance().setListOfChannels(Context.getInstance().readFile());
        wall.getChildren().addAll(Context.getInstance().getListOfChannels());
    }

}