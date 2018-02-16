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

        YoutubeChannel channel = new YoutubeChannel();
        JsonObject channelObject = new JsonParser().parse(Jsoup.connect("https://www.googleapis.com/youtube/v3/search?part=snippet&channelId="+channelID+"&type=video&eventType=live&key="+API_KEY)
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

        channel.setName(channelObject.get("channelTitle").getAsString());
        channel.setLive(channelObject.get("liveBroadcastContent").getAsString().equals("live"));
        channel.setThumbnails(channelObject.get("thumbnails").getAsJsonObject());
        channel.setTitle(channelObject.get("title").getAsString());
        channel.setDescription(channelObject.get("description").getAsString());


        return channel;

    }

}
