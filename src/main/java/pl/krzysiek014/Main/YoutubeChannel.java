package pl.krzysiek014.Main;

import com.google.gson.JsonObject;
import com.sun.javafx.font.FontFactory;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class YoutubeChannel extends AnchorPane {

    private boolean live;
    private String channelID;
    private String description;
    private String title;
    private JsonObject thumbnails;
    private String name;

    public YoutubeChannel(boolean l, String id, String desc, String t, JsonObject img, String n){

        this.live = l;
        this.channelID = id;
        this.description = desc;
        this.title = t;
        this.thumbnails = img;
        this.name = n;

        this.getChildren().setAll(createRectangle().getChildren());

    }

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public String getChannelID() {
        return channelID;
    }

    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public JsonObject getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(JsonObject thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "YoutubeChannel{" +
                "live=" + live +
                ", channelID='" + channelID + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", thumbnails=" + thumbnails +
                ", name='" + name + '\'' +
                '}';
    }

    private AnchorPane createRectangle(){

        AnchorPane pane = new AnchorPane();

        Rectangle r = new Rectangle(361,80,Color.LIGHTGRAY);
        Label l = new Label(getName());
        Label live = new Label();
        ImageView iv = new ImageView(new Image(getThumbnails().getAsJsonObject().get("default").getAsJsonObject().get("url").getAsString()));

        pane.getChildren().addAll(r,l,iv,live);

        iv.setY(10);
        iv.setFitHeight(80);

        r.setX(10);
        r.setY(10);

        l.setLayoutX(130);
        l.setLayoutY(10);

        if(isLive()){
            live.setText("ONLINE");
            live.setTextFill(Color.RED);
        }else{
            live.setText("OFFLINE");
            live.setTextFill(Color.BLACK);
        }
        live.setLayoutX(130);
        live.setLayoutY(50);

        return pane;
    }
}
