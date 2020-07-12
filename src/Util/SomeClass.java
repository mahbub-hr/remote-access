/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.io.Serializable;
import javafx.event.EventType;
import javafx.scene.input.*;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author mahbub
 */

public class SomeClass  implements Serializable{
    
   // private transient MouseEvent event;
    private EventType eventType;
    private double X;
    private double Y;
    private int kCode;
    
    public SomeClass(EventType<?extends MouseEvent> e, double x, double y){
            
            eventType = e;
            X= x;
            Y= y;
    }
    
    public SomeClass(EventType<? extends KeyEvent> e, int code){
            
            eventType = e;
            kCode=code;
    }
//    public  MouseEvent getEvent(){
//            return event;
//    }

    SomeClass(EventType<? extends MouseEvent> eventType) {
             this.eventType = eventType;
    }
    
    public EventType getEventType(){
            return  eventType;
    }
    
    public double GetX(){
            return X;
    }
    
    public double GetY(){
            return Y; 
    }
    
    public int  GetkCode(){
            return kCode;
    }
}
