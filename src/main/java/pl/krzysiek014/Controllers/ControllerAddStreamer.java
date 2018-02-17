package pl.krzysiek014.Controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
        addButton.setOnMouseClicked(e->{
            try {
                PrintWriter pw = new PrintWriter(new File("StreamerList"));
                for(YoutubeChannel s : Context.getInstance().getListOfChannels()){
                    pw.write(s.getChannelID()+"\n");
                }
                pw.write(idText.getText());
                pw.close();
                Context.getInstance().addToList(api.getChannelInfo(idText.getText()));

                ((Node)e.getSource()).getScene().getWindow().hide();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });

        checkButton.setOnMouseClicked(e->{
            name.setText("ABC");
        });

    }

}
