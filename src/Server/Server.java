/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Util.*;

import java.awt.AWTException;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mahbub
 */
public class Server extends Application {
    NetworkConnection nc;
    private ServerController Scontroll;
    
    @Override
    public void init() throws IOException{
    }
    
    @Override
    public void start(Stage primaryStage) throws AWTException, IOException {
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextContent/server.fxml"));
        Parent root = loader.load();
        Scontroll= loader.getController();
        Scene scene=new Scene(root,540,310);
        primaryStage.setScene(scene);
        primaryStage.show();
      //  openPopup();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void openPopup() throws IOException{
    
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextContent/ServerPop.fxml"));
        Parent root = loader.load();
        ServerPopController controll=loader.getController();
        controll.SetControll(Scontroll);
        Stage stage = new Stage();
        controll.setStage(stage);
        Scene scene = new Scene(root,300,170);
        stage.setScene(scene);
        stage.show();
    }
    
}
