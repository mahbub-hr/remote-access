/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author mahbub
 */
public class ServerPopController implements Initializable {

    private String sIP;
    private String sPort;
    private Stage stg;
    @FXML
    private CheckBox checkBox;
    @FXML
    private TextField sereverIP;
    @FXML
    private TextField serverPort;
    @FXML
    private Button ok;
    @FXML
    private Button later;
    private ServerController controll;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleCheckBox(ActionEvent event) {
    }

    @FXML
    private void handleOk(ActionEvent event) {
        sIP = sereverIP.getText().trim();
        sPort= serverPort.getText().trim();
        controll.serverIP=sIP;
        controll.serverPort=sPort;
        stg.close();
    }

    @FXML
    private void handleLater(ActionEvent event) {
        stg.close();
    }
   
   
    public void SetControll(ServerController c){
            controll = c;
    }

    void setStage(Stage stage) {
         stg=stage;
    }
}
