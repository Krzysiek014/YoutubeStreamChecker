package pl.krzysiek014.Main;

import com.google.gson.JsonObject;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import pl.krzysiek014.Controllers.HostServicesProvider;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class YoutubeChannel extends AnchorPane {

    private boolean live = false;
    private String channelID;
    private String description;
    private String title;
    private JsonObject thumbnails;
    private String name;
    private boolean exist = true;
    private String videoId;
    private int viewers;

    public YoutubeChannel(boolean l, String id, String desc, String t, JsonObject img, String n, String vid, int vc){

        this.live = l;
        this.channelID = id;
        this.description = desc;
        this.title = t;
        this.thumbnails = img;
        this.name = n;
        this.videoId = vid;
        this.viewers = vc;

        this.getChildren().setAll(createRectangle().getChildren());

    }

    public YoutubeChannel(String id, JsonObject img, String n){

        this.channelID = id;
        this.thumbnails = img;
        this.name = n;

        if(Settings.getInstance().getProperty("show-offline").equals("true")) this.getChildren().setAll(createRectangle().getChildren());
    }

    public YoutubeChannel(boolean exist, String id){
        this.exist = exist;
        this.channelID = id;
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

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

    public String getVideoId() {
        return videoId;
    }

    public void setVideoId(String videoId) {
        this.videoId = videoId;
    }

    public int getViewers() {
        return viewers;
    }

    public void setViewers(int viewers) {
        this.viewers = viewers;
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
            live.setText("ONLINE    " + String.format("%,d",getViewers()));
            live.setTextFill(Color.RED);
            this.setOnMouseClicked(e->{
                HostServicesProvider.getInstance().getHostServices().showDocument("https://www.youtube.com/embed/"+getVideoId()+"?autoplay=1");
            });
            this.setOnMouseEntered(e->r.setFill(Color.valueOf("#9aa7ad")));
            this.setOnMouseExited(e->r.setFill(Color.LIGHTGRAY));
        }else{
            live.setText("OFFLINE");
            live.setTextFill(Color.BLACK);
            this.setOnMouseEntered(e->r.setFill(Color.valueOf("#9aa7ad")));
            this.setOnMouseExited(e->r.setFill(Color.LIGHTGRAY));
        }
        live.setLayoutX(130);
        live.setLayoutY(50);

        return pane;
    }

}
