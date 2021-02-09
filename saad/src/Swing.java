import model.PacFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class Swing extends JFrame {

//    public Swing() throws IOException {
//        super("Pac-man");
//
//        WindowListener l = new WindowAdapter() {
//            public void windowClosing(WindowEvent e){
//                System.exit(0);
//            }
//        };
//
//        addWindowListener(l);
//        setSize(1500,800);
//        setVisible(true);
//
//    }


    public static void main(String [] args)throws java.io.IOException{
        new PacFrame();

    }
}