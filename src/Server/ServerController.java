/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Server.Connection.Connection;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author mahbub
 */
public class ServerController implements Initializable {

    public String serverIP;
    public String serverPort="3333";
    private boolean shouldAccept = true;
    private ServerSocket ServSock;
    
    @FXML
    private Button start;
    @FXML
    private Button stop;
    @FXML
    private Button configure;
    @FXML
    private Button about;
    @FXML
    private Button exit;
    @FXML
    private VBox VBoxServer;
    @FXML
    private VBox VBoxClient;
    
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleStart(ActionEvent event) throws IOException {
       // shouldAccept = true;
        if(serverPort.length()==0)
            JOptionPane.showMessageDialog(null, "Invalid IP or Port");
        else{
            
            ServSock = new ServerSocket(Integer.parseInt(serverPort.trim()));
            new Thread(new Connection(this, ServSock),"Server Thread").start();
            //JOptionPane.showMessageDialog(null, "Server Started!");
            System.out.println("server started");
            Text t1= new Text("IP : 192.168.56.1"+"\nPort : "+ serverPort);
            Text t= new Text("Waiting to be connected......\n----------------------------------------");
            VBoxServer.getChildren().addAll(t1,t);     
        }
    }

   

    @FXML
    private void handleStop(ActionEvent event) {
        try {
            ServSock.close();
            JOptionPane.showMessageDialog(null,"Server Closed!" );
        } catch (IOException ex) {
            System.out.println("Server Closed");
        }
    }

    @FXML
    private void handleConfigure(ActionEvent event) {
       //serverIP =  JOptionPane.showInputDialog("Enter IP");
       serverPort = JOptionPane.showInputDialog("Enter Port");
    }

    @FXML
    private void handleAbout(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene( FXMLLoader.load(getClass().getResource("/TextContent/about.fxml"))));
        stage.show();
    }

    @FXML
    private void handleExit(ActionEvent event) {
        
        System.exit(0);
    }
    
    public void setText(String ip){
      VBoxClient.getChildren().add(new Text("CLient1 Connected\nIP: "+ ip));
    }
}
