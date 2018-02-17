package pl.krzysiek014.GoogleApi;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import pl.krzysiek014.Main.YoutubeChannel;

import java.io.IOException;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class GoogleApi {

    private String API_KEY = ""; // Insert Google Api key

    public YoutubeChannel getChannelInfo(String channelID) throws IOException {
        try {
            JsonObject channelObject = new JsonParser().parse(Jsoup.connect("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId=" + channelID + "&type=video&eventType=live&key=" + API_KEY)
                    .ignoreContentType(true)
                    .get()
                    .text())
                    .getAsJsonObject()
                    .get("items")
                    .getAsJsonArray()
                    .get(0)
                    .getAsJsonObject()
                    .get("snippet")
                    .getAsJsonObject();

            String name = channelObject.get("channelTitle").getAsString();
            boolean live = channelObject.get("liveBroadcastContent").getAsString().equals("live");
            JsonObject thumbnails = channelObject.get("thumbnails").getAsJsonObject();
            String title = channelObject.get("title").getAsString();
            String description = channelObject.get("description").getAsString();


            return new YoutubeChannel(live, channelID, description, title, thumbnails, name);
        }catch(IndexOutOfBoundsException iobe){
            return new YoutubeChannel(false, channelID);
        }
    }

    public YoutubeChannel getChannel(String channelID) throws IOException {
        try {
            JsonObject channelObject = new JsonParser().parse(Jsoup.connect("https://www.googleapis.com/youtube/v3/channels?part=snippet&id=" + channelID + "&key=" + API_KEY)
                    .ignoreContentType(true)
                    .get()
                    .text())
                    .getAsJsonObject()
                    .get("items")
                    .getAsJsonArray()
                    .get(0)
                    .getAsJsonObject()
                    .get("snippet")
                    .getAsJsonObject();

            String name = channelObject.get("title").getAsString();
            JsonObject thumbnails = channelObject.get("thumbnails").getAsJsonObject();

            return new YoutubeChannel(channelID, thumbnails, name);
        }catch(IndexOutOfBoundsException iobe){
            return new YoutubeChannel(false, channelID);
        }
    }

}
