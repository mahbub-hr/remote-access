package Util;


import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class ImageCapture {
    public static Rectangle screenRect= new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
    public static BufferedImage screenshot() throws AWTException, IOException { 
        BufferedImage capture = new Robot().createScreenCapture(screenRect);
       // System.out.println("Image Captured");
        //Image image = SwingFXUtils.toFXImage(capture, null);
        //imageView.setImage(image);
        //return imageView;
        return capture;
    }
}
