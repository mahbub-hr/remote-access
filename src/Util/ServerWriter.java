/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

/**
 *
 * @author user
 */
public class ServerWriter implements Runnable{
    public NetworkConnection netConnection;
   
    public ServerWriter(NetworkConnection nc){
        netConnection=nc;
        System.out.println("Writer started");
         
    }

//    public ServerWriter(ImageView imageView) {
//        imgView = imageView;
//    }
    
    @Override
    public void run() {
        while(true){
            //System.out.println("running");
          //cpaturing image 
            try {
                BufferedImage bim = ImageCapture.screenshot();
                
//                BufferedImage img=new BufferedImage(1024,575, BufferedImage.TYPE_INT_ARGB);
//                Graphics g = img.getGraphics();
//                g.drawImage(img, 0, 0,1024,575, (ImageObserver) img);
//                ImageIO.write(img, "jpeg", new FileOutputStream("screen"));
                netConnection.writeObject(bim);
                
                //System.out.println("@ write thread");
            }
             catch (Exception ex) {
                 ex.printStackTrace();
             }
                     
        }
    }

}
