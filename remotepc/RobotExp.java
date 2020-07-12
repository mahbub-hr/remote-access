/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remotepc;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 *
 * @author mahbub
 */
public class RobotExp {
     
    public static void main(String[] args) {
         
        try {
             
            Robot robot = new Robot();
           
            robot.delay(5000);
            robot.keyPress(KeyEvent.VK_H);
            robot.keyPress(KeyEvent.VK_I);
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyPress(KeyEvent.VK_B);
            robot.keyPress(KeyEvent.VK_U);
            robot.keyPress(KeyEvent.VK_D);
            robot.keyPress(KeyEvent.VK_Y);
           // while(true){
            Point p = MouseInfo.getPointerInfo().getLocation();
            System.out.println(p.x+" "+p.y);
            robot.mouseMove(1318, 87);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           // }
             
        } catch (AWTException e) {
            System.out.println("Exception "+e);
        }
    }
}
