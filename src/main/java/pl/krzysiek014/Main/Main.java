package pl.krzysiek014.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import pl.krzysiek014.Controllers.HostServicesProvider;

/**
 * Created by Krzysiek014 on 16.02.2018.
 */
public class Main extends Application {

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        HostServicesProvider.getInstance().setHostServices(getHostServices());
        FXMLLoader loader = new FXMLLoader(ClassLoader.getSystemResource("WindowStyle.fxml"));
        AnchorPane ap = loader.load();
        Scene scene = new Scene(ap);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.setResizable(false);
        primaryStage.show();
        positioning(primaryStage);
    }

    private void positioning(Stage ps){
        Rectangle2D screen = Screen.getPrimary().getBounds();
        ps.setX(screen.getMaxX()-ps.getWidth()+6); //Adding 6 because of scroll
        ps.setY(screen.getMaxY()-ps.getHeight()-38); // Subtract 38 because of taskbar
    }
}
