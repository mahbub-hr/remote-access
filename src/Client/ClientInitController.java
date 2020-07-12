/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import Util.NetworkConnection;
import Viewer.ViewerController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mahbub
 */
public class ClientInitController implements Initializable {

    private String serverIP = "127.0.0.1";
    private String serverPort = "3333" ;
    private NetworkConnection nc;
    private boolean isConnected = false;
    private boolean isReaderRunning = false;
    private Stage stage;
    @FXML
    private Button connect;
    @FXML
    private Button configure;
    @FXML
    private Button fileTransfer;
    @FXML
    private Button about;
    @FXML
    private Button exit;
    @FXML
    private TextArea textArea;
    @FXML
    private Button play;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleConnect(ActionEvent event) {
        if (!isConnected) {
            try {
                
                System.out.println("Connecting.......");
                nc = new NetworkConnection(serverIP, Integer.parseInt(serverPort.trim()));
                isConnected = true;
                System.out.println("Connected to Server!");
               // JOptionPane.showMessageDialog(null, "Connected!");
                
            } catch (IOException ex) {
                
                JOptionPane.showMessageDialog(null, "Can not connect to Server");
                ex.printStackTrace();
            }
        }else{
                JOptionPane.showMessageDialog(null, "You are already Connected!");
        }
    }

    @FXML
    private void  handleConfigure(ActionEvent event) {
        serverIP = JOptionPane.showInputDialog("Server IP");
        serverPort = JOptionPane.showInputDialog("Port");
        
        if(serverIP.length()==0 || serverPort.length()==0) JOptionPane.showMessageDialog(null, "Invalid IP or Port");
        else{
        
            try(FileOutputStream fp = new FileOutputStream("config.txt")){
                fp.write((serverIP+"\n").getBytes());
                fp.write(serverPort.getBytes());
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
            
        }
        
    }
    
     @FXML
    private void handlePlay(ActionEvent event) {
        
        if(isConnected == false){
            JOptionPane.showMessageDialog(null, "You are not Connected!");
        }
        else{
            
            try {
                if (!isReaderRunning ) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/TextContent/viewer.fxml"));
                Parent root = (Parent)loader.load();
                ViewerController controll = (ViewerController)loader.getController();
                 
                stage = new Stage();
                stage.setTitle("Viewer");
                Scene scene = new Scene(root);
                
                stage.setScene(scene);
                controll.setSatge(stage);
                stage.show();
                    System.out.println(scene.getWidth());
                    System.out.println(stage.getWidth());
                controll.StartThread(nc);
                isReaderRunning = true;
                }
                else{
                 stage.show();
                 
                }

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }

    @FXML
    private void handleFileTransfer(ActionEvent event) {
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        System.out.println("about");
       
        Stage stage = new Stage();
        stage.setScene(new Scene( FXMLLoader.load(getClass().getResource("/TextContent/about.fxml"))));
        stage.show();
        
    }

    @FXML
    private void handleExit(ActionEvent event)  {
//        if(nc.socket == null){
//            System.out.println("here");
//            nc.socket.close();
//        }
        
        System.exit(0);
          
    }
    
}


