package model;
import IA.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import javax.swing.JComponent;
import java.awt.Dimension;
public class PacCompoments extends JComponent //component class for storing the Tanks, moving them at once
{
    public Player pac; //create pac
    public Fantome red;//create red ghosts
    public Fantome blue;//create blue ghosts
    public Fantome yellow;//create yellow ghosts
    public Fantome pink;//create pink ghosts
    public boolean win = false; //boolean dependent on winning
    public boolean gameOver = false; //boolean dependent on loosing
    public boolean stopped = true; //boolean that stops and starts the game

    int counter = 0; //counter to track time
    boolean dead = false; //boolean that shows if pacman died
    boolean ghostEat = false; //boolean that shows ghosts are escaping

    public PacCompoments() //in constructor variables are initialized
    {
        this.setSize(new Dimension(992,692));

        pac = new Player(481,568,30);

    }

    public void getState(boolean b) //takes start/stop state from PacFrame
    {
        stopped = b;
    }

    public void paintComponent(Graphics g) //draws every object
    {

        pac.draw(g); //draws pacman
        //fantome.
        if(stopped) {//draws stop screen
            g.setColor(Color.BLACK);
            g.fillRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("PRESS SPACEBAR",(994-300)/2+65,(692-20)/2);
            g.drawString("TO START/STOP",(994-300)/2+71,(692-20)/2+20);
        }
        if(win) { //draws win screen
            g.setColor(Color.BLACK);
            g.fillRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("YOU WIN!",(994-200)/2+53,(692-20)/2);
        }
        if(gameOver) {//draws game over screen
            g.setColor(Color.BLACK);
            g.fillRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((994-300)/2,(692-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER",(994-200)/2+53,(692-20)/2);
        }
        
        Image img = null;
        try {
            img = ImageIO.read(new File("src/model/resources/murDroit.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Labyrinthe lb = new Labyrinthe();
        int[][] tab = lb.getTab();
        for (int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                if (tab[i][j]==1){
                    g.drawImage(img, i*30, j*30, this);
                }


            }
        }
    }

    public void reDraw() //repaints and sets variables dependent on time
    {
         pac.r = true;


        pac.move(); //changes variables in pacman
        repaint(); //repaints...
    }
}
