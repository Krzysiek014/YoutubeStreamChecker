package pl.krzysiek014.Controllers;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.krzysiek014.Main.YoutubeChannel;

import java.io.IOException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerWindowStyle {

    @FXML
    private VBox wall;
    @FXML
    private Button addButton, refreshButton;
    @FXML
    ImageView sButton;

    public void initialize() throws IOException {

        sButton.setImage(new Image("setting.png"));

        sButton.setOnMouseClicked(e->{
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("SettingsWindow.fxml"));
            try {
                AnchorPane ap = loader.load();
                Scene scene = new Scene(ap);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.initStyle(StageStyle.UTILITY);
                stage.show();
            } catch (IOException e1) {}
        });

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

        refreshButton.setOnAction(e->{
            Thread t = new Thread(()->update());
            t.start();
        });

        Context.getInstance().setListOfChannels(Context.getInstance().readFile());
        wall.getChildren().addAll(sortList());

        AnimationTimer at = new AnimationTimer() {
            long nano = System.nanoTime();
            @Override
            public void handle(long now) {
                if((now-nano)/1000000000>20){
                    nano = now;
                    refreshButton.fire();
                }
            }};
        at.start();

    }

    private void update(){
        try {
            Context.getInstance().setListOfChannels(Context.getInstance().readFile());
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        Platform.runLater(()->wall.getChildren().clear());
        Platform.runLater(()->wall.getChildren().addAll(sortList()));
    }

    private List<YoutubeChannel> sortList(){
        List<YoutubeChannel> l1 = new LinkedList<>();
        List<YoutubeChannel> l2 = new LinkedList<>();
        for(YoutubeChannel yc : Context.getInstance().getListOfChannels()) {
            if(yc.isExist())
                if(yc.isLive()){
                    l1.add(yc);
                }else {
                    l2.add(yc);
                }

        }
        l1.sort(Comparator.comparing(YoutubeChannel::getViewers).reversed());
        l2.sort(Comparator.comparing(YoutubeChannel::getName));
        l1.addAll(l2);
        return l1;
    }
}