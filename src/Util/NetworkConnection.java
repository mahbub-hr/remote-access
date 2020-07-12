/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.Socket;
import java.util.zip.*;
import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class NetworkConnection {
    public Socket socket;
    ObjectInputStream ois;
    public ObjectOutputStream oos;
    transient Image image;
    GZIPOutputStream gout;
    GZIPInputStream gin;
    
    public NetworkConnection(Socket sock) throws IOException{
        socket=sock;
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());        
    }
    
    public NetworkConnection(String ip,int port) throws IOException{
        socket=new Socket(ip, port);
        oos=new ObjectOutputStream(socket.getOutputStream());
        ois=new ObjectInputStream(socket.getInputStream());
    }
    
    public void writeObject(BufferedImage bim) throws IOException  {
         
        try {
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(bim, "jpg", baos);
            baos.flush();
            byte[]data=baos.toByteArray();
            System.out.println("baos:"+data.length);
            
            oos.writeObject(data);
            oos.flush();
            oos.reset();
            System.out.println("writed");
        } catch (Exception ex) {
            System.out.println("Eception in write Method "+ex);
        }        
    }
    
    public BufferedImage readObject() throws IOException, ClassNotFoundException {

        byte[]data=(byte[]) ois.readObject();
        ByteArrayInputStream bais=new ByteArrayInputStream(data);
        BufferedImage bim=ImageIO.read(bais);
        
        return bim;          
    }
    
    public void WriteToServer(Object ob){
        try {
            oos.writeObject(ob);
            oos.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            System.exit(0);
            
        }
    }
    
    public SomeClass ReadFromClient() throws IOException, ClassNotFoundException{
        
        SomeClass ob;
        
        ob =(SomeClass) ois.readObject();
        if(ob == null) return null;

        return ob;
    }
    
}



