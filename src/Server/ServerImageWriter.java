/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import Util.ImageCapture;
import Util.NetworkConnection;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mahbub
 */
public class ServerImageWriter extends TimerTask{

   public NetworkConnection netConnection;
   
    public ServerImageWriter(NetworkConnection nc){
        netConnection=nc;
        System.out.println("Writer started");
         
    }

//    public ServerWriter(ImageView imageView) {
//        imgView = imageView;
//    }
    
    @Override
    public void run() {
       try {
           netConnection.oos.writeObject(ImageCapture.screenRect);
       } catch (IOException ex) {
           ex.printStackTrace();
       }
        while(true){
            //System.out.println("running");
          
            try {
                BufferedImage bim = ImageCapture.screenshot();
                //imgView.setImage(image);
                BufferedImage newImg = new BufferedImage(1024, 576, BufferedImage.TYPE_INT_ARGB);
                Graphics g=newImg.getGraphics();
                g.drawImage(bim, 0, 0,1024,576,null );
                g.dispose();
                ImageIO.write(bim, "png", new FileOutputStream("screen.png"));
                netConnection.writeObject(bim);
                
                //System.out.println("@ write thread");
            }
             catch (Exception ex) {
                 ex.printStackTrace();
             }
                     
        }
    }
    
}
