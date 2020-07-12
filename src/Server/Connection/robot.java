/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server.Connection;

import Util.SomeClass;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import static javafx.scene.input.MouseEvent.*;


/**
 *
 * @author mahbub
 */
public class robot {
  
  private Robot r;
  
  robot(){
    
      try {
          r= new Robot();
      } catch (AWTException ex) {
             ex.printStackTrace();
      }
   
  }
  
  
  
  public  void MouseEventAnalyse(SomeClass e){
 
        if(e.getEventType() == MOUSE_MOVED)
             r.mouseMove((int)e.GetX(), (int)e.GetY());
        
        else if(e.getEventType() == MOUSE_CLICKED ){
             r.mousePress(InputEvent.BUTTON1_MASK);
             r.mouseRelease(InputEvent.BUTTON1_MASK);
        }

        else if(e.getEventType() == MOUSE_PRESSED){
             r.mousePress(InputEvent.BUTTON1_DOWN_MASK);
             //r.mouseMove((int)e.GetX(), (int)e.GetY());
        }
        
        else if(e.getEventType() == MOUSE_RELEASED){
             r.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }
        
        else if(e.getEventType() == KeyEvent.KEY_PRESSED){
             r.keyPress(e.GetkCode());
        }
        
        else if(e.getEventType() == KeyEvent.KEY_RELEASED){
             r.keyRelease(e.GetkCode());
        }
    }
  
}
