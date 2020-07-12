/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotepc;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mahbub
 */
public class ScreenCaptureTest {
   static ArrayList<BufferedImage> q = new ArrayList<>();
    public static void main(String[] args) throws AWTException, IOException {
       //for (int i = 0; i < 5; i++) {
         BufferedImage screencapture = new Robot().createScreenCapture(
           new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()) );
          //q.add(screencapture);
          File file = new File("screencapture.jpg");
          ImageIO.write(screencapture, "jpg", file);
          
          
     
        //}
    }
}
