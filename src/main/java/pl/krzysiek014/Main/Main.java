package pl.krzysiek014.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("WindowStyle.fxml"));
        ScrollPane sp = loader.load();
        Scene scene = new Scene(sp);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
        positioning(primaryStage);
    }

    private void positioning(Stage ps){
        Rectangle2D screen = Screen.getPrimary().getBounds();
        System.out.println(ps.getWidth());
        ps.setX(screen.getMaxX()-ps.getWidth()+6); //Adding 6 because of scroll
        ps.setY(screen.getMaxY()-ps.getHeight()-(screen.getMaxY()*0.03)); // Multiplying by 0.03 because of taskbar
    }
}
