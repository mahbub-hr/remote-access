/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Util.ClientReader;
import Util.ClientWriter;
import Util.NetworkConnection;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahbub
 */
public class ViewerController implements Initializable {
    
    private Stage viewerStage;
    private Thread clientReader;
    private Thread clientWriter;
   
    @FXML
    private ImageView imageView;
    @FXML
    private AnchorPane aPane;
      
    public void setSatge(Stage stage) {
        viewerStage=stage;
    }
     
    public void StartThread(NetworkConnection nc){
        ImageViewPane iPane=new ImageViewPane(imageView);
        aPane.getChildren().add(iPane);
       ClientReader r=new ClientReader(imageView, nc);
       clientReader = new Thread(r, "Client Reader");
       clientReader.start();
       
       clientWriter = new Thread( new ClientWriter(imageView,nc), "Client Writer");
       clientWriter.start();
    }    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}
