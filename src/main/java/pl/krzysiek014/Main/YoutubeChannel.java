package pl.krzysiek014.Main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class YoutubeChannel extends Rectangle {

    private boolean live;
    private String channelID;
    private String description;

    public YoutubeChannel(boolean l, String id, String desc){

        setFill(Color.BLUE);
        setWidth(100);
        setHeight(100);

        this.live = l;
        this.channelID = id;
        this.description = desc;
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
}
