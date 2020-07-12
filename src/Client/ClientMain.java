/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Util.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author user
 */
public class ClientMain extends Application {
    
    private int serverIP;
    NetworkConnection nc;
    private ClientWriter cWriter;
    private int serverPort; 
    public static void main(String[] args) throws IOException {
        
        launch(args); 
    }
    
    
     @Override
    public void init() throws IOException{
      // nc = new NetworkConnection("localhost", 6666);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("/TextContent/clientInit.fxml"));
        
        Parent root = loader.load();
       
        Scene scene=new Scene(root,585,400);
        stage.setScene(scene);
        stage.show();
    }
    
}
