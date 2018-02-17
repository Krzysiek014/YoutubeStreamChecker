package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pl.krzysiek014.GoogleApi.GoogleApi;
import pl.krzysiek014.Main.YoutubeChannel;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class ControllerAddStreamer {

    @FXML
    private Button addButton, checkButton;
    @FXML
    private TextField idText;
    @FXML
    private Label name;
    @FXML
    private ImageView avatar;

    public void initialize(){
        GoogleApi api = new GoogleApi();
        // Init button actions
        //TODO adding channels while they are not live
        addButton.setOnMouseClicked(e->{
            YoutubeChannel yc = new YoutubeChannel(false, idText.getText());
                try {
                    yc = api.getChannelInfo(idText.getText());
                } catch (IOException ignored) {
                }
                if (yc.isExist()) {
                    try {
                        PrintWriter pw = new PrintWriter(new File("StreamerList"));
                        for (YoutubeChannel s : Context.getInstance().getListOfChannels()) {
                            pw.write(s.getChannelID() + "\n");
                        }
                        pw.write(idText.getText());
                        pw.close();
                        Context.getInstance().addToList(api.getChannelInfo(idText.getText()));

                        ((Node) e.getSource()).getScene().getWindow().hide();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    idText.clear();
                    idText.setPromptText("Channel is not live right now");
                    idText.setStyle("-fx-prompt-text-fill: red");
                }
        });

        // TODO implement isExist() function
        checkButton.setOnMouseClicked(e->{
            YoutubeChannel yc = new YoutubeChannel(false,idText.getText());
            try {
               yc = api.getChannel(idText.getText());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            if(yc.isExist()) {
                name.setText(yc.getName());
                avatar.setImage(new Image(yc.getThumbnails().get("default").getAsJsonObject().get("url").getAsString()));
            }else{
                name.setText("");
                avatar.setImage(null);
                idText.clear();
                idText.setPromptText("Channel is not live right now");
                idText.setStyle("-fx-prompt-text-fill: red");
            }
        });

    }

}
