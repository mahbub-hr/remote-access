/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Connection;

import Server.ServerController;
import Server.ServerImageWriter;
import Util.NetworkConnection;
import Util.ServerReader;
import java.io.IOException;
import java.net.*;
import java.util.Timer;
import javafx.application.Platform;

/**
 *
 * @author mahbub
 */
public class Connection implements Runnable{

    private NetworkConnection nc;
    private ServerSocket servSock;
    private Socket sock;
    private ServerController controll;
    
    public Connection( ServerController controll,ServerSocket sock) throws IOException{
       servSock = sock;
       this.controll = controll;       
    }
    
    @Override
    public void run() {
        try {
            sock = servSock.accept();
            System.out.println("connection accepted");
            nc = new NetworkConnection(sock);
            
            Platform.runLater(new Runnable(){
                @Override
                public void run() {
                    controll.setText(sock.getInetAddress().toString());
                }          
            });
            
            //new Thread(new ServerWriter(nc),"Server Writer").start();
            Timer timer=new Timer();
            ServerImageWriter task=new ServerImageWriter(nc);
            timer.scheduleAtFixedRate(task, 0, 3000);
            new Thread(new ServerReader(new robot(),nc),"Server Reader").start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    
}
