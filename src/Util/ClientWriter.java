/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javafx.scene.Scene;
import javafx.scene.image.ImageView;

/**
 *
 * @author mahbub
 */
public class ClientWriter implements Runnable{
    private SomeClass sClass;
    private NetworkConnection nc;
    private ImageView imageView;
    double xScale;
    double yScale;
    
    public ClientWriter(ImageView imgView,NetworkConnection nc){
    //  sClass = new SomeClass();
    imageView = imgView;
      this.nc = nc;
      imageView.setFocusTraversable(true);
    }
    
    @Override
    public void run() {
        
            imageView.setOnMouseMoved(e->{
                SomeClass sClass= new SomeClass(e.getEventType(),e.getX(),e.getY()); 
                nc.WriteToServer(sClass);
                
            });
            
            imageView.setOnMouseClicked(e->{
                SomeClass sClass = new SomeClass(e.getEventType());
                nc.WriteToServer(sClass);
            
            });
  
            imageView.setOnMousePressed(e -> {
                SomeClass sClass = new SomeClass(e.getEventType());
                nc.WriteToServer(sClass);
            });
            
            imageView.setOnMouseReleased(e->{
                SomeClass sClass = new SomeClass(e.getEventType());
                nc.WriteToServer(sClass);
            });
            
            
  
            imageView.setOnKeyPressed(e->{
                
                SomeClass sClass = new SomeClass(e.getEventType(),e.getCode().impl_getCode());
                nc.WriteToServer(sClass);
                System.out.println("key pressed");
            });
            
            imageView.setOnKeyReleased(e->{
             
                SomeClass sClass = new SomeClass(e.getEventType(),e.getCode().impl_getCode());
                nc.WriteToServer(sClass);
                System.out.println("key released");
            });
            
    }
    
}
