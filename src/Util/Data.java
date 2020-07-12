/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.*;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author mahbub
 */
public class Data implements Serializable{
    
   private MouseEvent mouseEvent;
//    private ObjectOutputStream oos;
//    private ObjectInputStream ois;
    
    Data(MouseEvent e, ObjectOutputStream o, ObjectInputStream i){
        mouseEvent = e;
//        oos = o;
//        ois= i;
  
    }
    
//   private  void writeObject(ObjectOutputStream oos){
//        try {
//            oos.defaultWriteObject();
//            oos.writeObject(mouseEvent);
//            oos.flush();
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//    
//    private Object readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException{
//       ois.defaultReadObject();
//       return ois.readObject();
//    }
}
