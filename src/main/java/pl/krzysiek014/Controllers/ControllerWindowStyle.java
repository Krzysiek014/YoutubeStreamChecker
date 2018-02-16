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
    VBox wall;
    @FXML
    Button addButton, refreshButton;

    GoogleApi api;

    private List<YoutubeChannel> listOfChannels;

    public void initialize() throws IOException {
        api = new GoogleApi();

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
            try {
                wall.getChildren().clear();
                listOfChannels = readFile();
                wall.getChildren().addAll(listOfChannels);
            } catch (IOException ignored){}
        });

        listOfChannels = readFile();


        wall.getChildren().addAll(listOfChannels);
    }

    public List<YoutubeChannel> readFile() throws IOException {
        List<YoutubeChannel> l  = new LinkedList<>();

        Scanner scan = new Scanner(new File("StreamerList"));
        while(scan.hasNextLine()){
            l.add(api.getChannelInfo(scan.nextLine()));
        }
        return l;
    }
}
