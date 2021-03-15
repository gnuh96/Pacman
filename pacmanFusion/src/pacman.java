import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class pacman {

    private int x;
    private int y;
    private BufferedImage img;

    public pacman(int x, int y, char name) {
        this.setX(x);
        this.setY(y);
        this.setImage(name);
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setImage(char name) {
        try {
            this.img = ImageIO.read(new File("png/" + name + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public BufferedImage getImage(){
        return this.img;
    }

    public void paint(Graphics g){
            g.drawImage(this.img, this.x, this.y, null);
        }
    }