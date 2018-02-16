package pl.krzysiek014.Main;

import com.google.gson.JsonObject;
import javafx.scene.control.Label;
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

    public YoutubeChannel(){
        this.getChildren().addAll(createRectangle().getChildren());
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

        Rectangle r = new Rectangle(361,74,Color.LIGHTGRAY);
        Label l = new Label(getName());

        pane.getChildren().addAll(r,l);

        r.setX(10);
        r.setY(10);
        l.setLayoutX(200);
        l.setLayoutY(10);
        return pane;
    }
}
