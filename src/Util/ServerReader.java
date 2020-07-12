/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Server.Connection.robot;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mahbub
 */
public class ServerReader implements Runnable {
    
   
    private robot rbt;
    private NetworkConnection nc;
    

    public ServerReader(robot rbt, NetworkConnection nc){
      this.rbt = rbt;
      this.nc = nc;
    }
    
   @Override
    public void run(){
      while(true){
          try {
              SomeClass sClass = nc.ReadFromClient();
              rbt.MouseEventAnalyse(sClass);
          } catch (Exception ex) {
              ex.printStackTrace();
              //System.exit(0);
          }
      
      }
    }
    
}
