package pl.krzysiek014.Controllers;

import pl.krzysiek014.GoogleApi.GoogleApi;
import pl.krzysiek014.Main.YoutubeChannel;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class Context {

    private final static Context instance = new Context();
    private GoogleApi api = new GoogleApi();
    private List<YoutubeChannel> listOfChannels = new LinkedList<>();

    public static Context getInstance() {
        return instance;
    }

    public void setListOfChannels(List<YoutubeChannel> listOfChannels) {
        this.listOfChannels = listOfChannels;
    }

    public List<YoutubeChannel> getListOfChannels() {
        return listOfChannels;
    }

    public List<YoutubeChannel> readFile() throws IOException {
        List<YoutubeChannel> l  = new LinkedList<>();

        Scanner scan = new Scanner(new File("StreamerList"));
        while(scan.hasNextLine()){
            l.add(api.getChannelInfo(scan.nextLine()));
        }
        return l;
    }

    public void addToList(YoutubeChannel yc){
        listOfChannels.add(yc);
    }
}
