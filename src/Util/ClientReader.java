/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author user
 */
public class ClientReader implements Runnable{
    public NetworkConnection netConnection;
    ImageView imageView;
    transient Image img;
    Rectangle rect;

    public ClientReader(ImageView imageView, NetworkConnection nc) {
        netConnection=nc;
        this.imageView = imageView;
    }
    
    @Override
    public void run() {
        try {
           rect=(Rectangle) netConnection.ois.readObject();
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        System.out.println("Reader Started");
        while(true){
            try {
                //setting image to imageview
                BufferedImage im = netConnection.readObject();    
                img = SwingFXUtils.toFXImage(im, null);
                imageView.setImage(img);
               
                imageView.setSmooth(true);
                //System.out.println("@ read thread");
              
                
            } catch (Exception ex) {
                ex.printStackTrace();
                System.exit(0);
                System.out.println("Exception in Read Thread "+ ex);
            }
       }
        
    }
    
    public Rectangle getServerScreenDim(){
        return rect;
    }
    
}
