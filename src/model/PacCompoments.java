package model;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import IA.Fantome;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import java.awt.Dimension;
public class PacCompoments extends JComponent //component class for storing the Tanks, moving them at once
{	
	public static PacCompoments gameInstance;
    public Player pac; //create pac
    public Fantome red;//create red ghosts
    public Fantome blue;//create blue ghosts
    public Fantome yellow;//create yellow ghosts
    public Fantome pink;//create pink ghosts
    int[][] tab;

    public Image murh = null; //murHorizontal
    public Image murv = null; //murVertical
    public Image angle1 = null;
    public Image angle2 = null;
    public Image angle3 = null;
    public Image angle4 = null;
    public Image gomme = null;
    public Image vide = null;
    public Image croisement =null;
    public Image croiseT = null;
    public Image croiseT2 = null;
    public Image croiseT3 = null;
    public Image croiseT4 = null;
    public Image cds = null;
    public Image cds2 = null;
    public Image cds3 = null;
    public Image cds4 = null;
    public boolean win = false; //boolean dependent on winning
    public boolean gameOver = false; //boolean dependent on loosing
    public boolean stopped = true; //boolean that stops and starts the game

    int counter = 0; //counter to track time
    boolean dead = false; //boolean that shows if pacman died
    boolean ghostEat = false; //boolean that shows ghosts are escaping

    public PacCompoments() //in constructor variables are initialized
    {
        this.setSize(new Dimension(645,668));

        pac = new Player(30,30,30);
        red = new Fantome(481, 798, 6, "blinky");
        blue = new Fantome(481, 798, 5, "inky");
        yellow = new Fantome(481, 798, 5, "clyde");
        pink = new Fantome(481, 798, 6, "pinky");
        Labyrinthe lb = new Labyrinthe();
        tab = lb.getTab();
        System.out.println(tab.length);
        InitLaby();
    }
    public void InitLaby(){

        try {
            murh = ImageIO.read(new File("src/model/resources/murDroit.png"));
            murv = ImageIO.read(new File("src/model/resources/murDroit2.png"));
            angle1 = ImageIO.read(new File("src/model/resources/murAngle.png"));
            angle2 = ImageIO.read(new File("src/model/resources/murAngle2.png"));
            angle3 = ImageIO.read(new File("src/model/resources/murAngle3.png"));
            angle4 = ImageIO.read(new File("src/model/resources/murAngle4.png"));
            gomme = ImageIO.read(new File("src/model/resources/point.png"));
            vide = ImageIO.read(new File("src/model/resources/vide.png"));
            croisement = ImageIO.read(new File("src/model/resources/croisement.png"));
            croiseT = ImageIO.read(new File("src/model/resources/croiseT.png"));
            croiseT2 = ImageIO.read(new File("src/model/resources/croiseT2.png"));
            croiseT3 = ImageIO.read(new File("src/model/resources/croiseT3.png"));
            croiseT4 = ImageIO.read(new File("src/model/resources/croiseT4.png"));
            cds = ImageIO.read(new File("src/model/resources/murCulDeSac3.png"));
            cds2 = ImageIO.read(new File("src/model/resources/murCulDeSac2.png"));
            cds3 = ImageIO.read(new File("src/model/resources/murCulDeSac.png"));
            cds4 = ImageIO.read(new File("src/model/resources/murCulDeSac4.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static PacCompoments getInstance() {
		return gameInstance;
	}
    
    

	public Player getPac() {
		return pac;
	}

	public void setPac(Player pac) {
		this.pac = pac;
	}

	public static void setInstance(PacCompoments pacCompoments) {
		gameInstance = pacCompoments;
	}

    public void getState(boolean b) //takes start/stop state from PacFrame
    {
        stopped = b;
    }

    public void paintComponent(Graphics g) //draws every object
    {
        //LABY
        for (int i = 0; i < 21; i++) {
            for(int j = 0; j < 21; j++) {
                if (tab[i][j]==1){
                    if(j==0){
                        if(i==20){
                            g.drawImage(angle2, i * 30, j * 30, this);
                        } else {
                            if (i==0){
                                g.drawImage(angle1, i * 30, j * 30, this);
                            } else {
                                if (tab[i][j + 1] == 1 & tab[i + 1][j] == 1 & tab[i - 1][j] == 1) {
                                    g.drawImage(croiseT, i * 30, j * 30, this);
                                }
                                if (tab[i][j + 1] != 1) {
                                    g.drawImage(murh, i * 30, j * 30, this);
                                }
                            }
                        }
                    }
                    if(0<j & j<20 & 0<i & i<20) {
                        if (tab[i][j + 1] == 1 & tab[i][j - 1] == 1) {
                            g.drawImage(murv, i * 30, j * 30, this);
                        }
                        if (tab[i + 1][j] == 1 & tab[i - 1][j] == 1) {
                            g.drawImage(murh, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i + 1][j] == 1){
                            g.drawImage(croiseT4, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i - 1][j] == 1){
                            g.drawImage(croiseT2, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i + 1][j] == 1 & tab[i - 1][j] == 1){
                            g.drawImage(croiseT, i*30, j*30, this);
                        }
                        if(tab[i][j - 1] == 1 & tab[i + 1][j] == 1 & tab[i - 1][j] == 1){
                            g.drawImage(croiseT3, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i - 1][j] == 1 & tab[i + 1][j] == 1){
                            g.drawImage(croisement, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] == 1 & tab[i - 1][j] != 1 & tab[i + 1][j] != 1){
                            g.drawImage(cds4, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] != 1 & tab[i - 1][j] != 1 & tab[i + 1][j] != 1){
                            g.drawImage(cds3, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] != 1 & tab[i - 1][j] == 1 & tab[i + 1][j] != 1){
                            g.drawImage(cds2, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] != 1 & tab[i - 1][j] != 1 & tab[i + 1][j] == 1){
                            g.drawImage(cds, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] != 1 & tab[i - 1][j] != 1 & tab[i + 1][j] == 1){
                            g.drawImage(angle1, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] != 1 & tab[i - 1][j] == 1 & tab[i + 1][j] != 1){
                            g.drawImage(angle2, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] == 1 & tab[i - 1][j] == 1 & tab[i + 1][j] != 1){
                            g.drawImage(angle4, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] == 1 & tab[i - 1][j] != 1 & tab[i + 1][j] == 1){
                            g.drawImage(angle3, i*30, j*30, this);
                        }
                    }
                    if(0<j & j<20 & i==0){
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i + 1][j] == 1){
                            g.drawImage(croiseT4, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] != 1 & tab[i + 1][j] == 1){
                            g.drawImage(angle1, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i + 1][j] != 1){
                            g.drawImage(murv, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] == 1 & tab[i + 1][j] == 1){
                            g.drawImage(angle3, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] != 1 & tab[i + 1][j] == 1){
                            g.drawImage(murh, i*30, j*30, this);
                        }
                    }
                    if(0<j & j<20 & i==20){
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i - 1][j] == 1){
                            g.drawImage(croiseT2, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] != 1 & tab[i - 1][j] == 1){
                            g.drawImage(angle2, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] == 1 & tab[i][j - 1] == 1 & tab[i - 1][j] != 1){
                            g.drawImage(murv, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] == 1 & tab[i - 1][j] == 1){
                            g.drawImage(angle4, i*30, j*30, this);
                        }
                        if(tab[i][j + 1] != 1 & tab[i][j - 1] != 1 & tab[i - 1][j] == 1){
                            g.drawImage(murh, i*30, j*30, this);
                        }
                    }
                    if(j==20){
                        if(i==0){
                            g.drawImage(angle3, i*30, j*30, this);
                        } else {
                            if(i==20){
                                g.drawImage(angle4, i*30, j*30, this);
                            } else {

                                if (tab[i + 1][j] == 1 & tab[i - 1][j] == 1) {
                                    g.drawImage(murh, i * 30, j * 30, this);
                                }
                                if (tab[i][j - 1] == 1) {
                                    g.drawImage(croiseT3, i * 30, j * 30, this);
                                }
                            }
                        }
                    }

                }
                if (tab[i][j]==2){
                    g.drawImage(gomme, i*30, j*30, this);
                }

                if (tab[i][j]==8){
                    g.drawImage(vide, i*30, j*30, this);
                }

            }
            pac.draw(g); //draws pacman
        }
        if(stopped) {//draws stop screen
            g.setColor(Color.BLACK);
            g.fillRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("PRESS SPACEBAR",(645-300)/2+65,(668-20)/2);
            g.drawString("TO START/STOP",(645-300)/2+71,(668-20)/2+20);
        }
        if(win) { //draws win screen
            g.setColor(Color.BLACK);
            g.fillRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("YOU WIN!",(645-200)/2+53,(668-20)/2);
        }
        if(gameOver) {//draws game over screen
            g.setColor(Color.BLACK);
            g.fillRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(new Color(29,28,229));
            g.drawRect((645-300)/2,(668-150)/2,300,150);
            g.setColor(Color.WHITE);
            g.drawString("GAME OVER",(645-200)/2+53,(668-20)/2);
        }
        
    }

    public void reDraw() //repaints and sets variables dependent on time
    {
        pac.u = true;
        pac.d = true;
        pac.l = true;
        pac.r = true;
        if (pac.getY()-1 > 0 && pac.getY() / 30 < 20 && pac.getX() / 30 < 20 && pac.getX()-1 > 0) {
            if (tab[pac.getX() / 30][pac.getY() / 30] == 2) {
                tab[pac.getX() / 30][pac.getY() / 30] = 8;
            }
            if (tab[pac.getX() / 30][(pac.getY() - 1) / 30] == 1) {
                System.out.println("N");
                pac.u = false;
            }
            if (tab[pac.getX() / 30][(pac.getY() + 30) / 30] == 1) {
                System.out.println("S");
                pac.d = false;
            }
            if (tab[(pac.getX() + 30) / 30][pac.getY() / 30] == 1) {
                System.out.println("E");
                pac.r = false;
            }
            if (tab[(pac.getX() - 1) / 30][(pac.getY()) / 30] == 1) {
                System.out.println("W");
                pac.l = false;
            }
        }
            pac.move(); //changes variables in pacman
            repaint(); //repaints...
    }
}
