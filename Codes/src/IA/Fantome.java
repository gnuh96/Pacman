package IA;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import model.*;

/**
 * Représente un personnage Fantome qui poursuit PacMan. Un fantôme est contrôlé par une IA. 
 * Les fantômes peuvent chasser PacMan et essayer de le manger en entrant en collision 
 * avec lui. Si PacMan mange un Power Pellet, le mode scatter est
 * initié et un fantôme peut être mangé s'il est touché par PacMan.
**/
public class Fantome {

	private int x;
	private int y;
	private int speed;
	private BufferedImage img;
	
	private Direction lastDirection = Direction.LEFT;
	private Direction curDirection;
	
	/**
	 * le valeur de l'objet
	 */
	private int scoreValue;
	
	/**
	 * Construit un Fantome avec une position initiale, une vitesse
	 * @param x c'est la coordonnée x initiale
	 * @param y c'est la coordonnée y initiale
	 * @param speed la vitesse à laquelle le Fantome se déplace
	 */
	public Fantome(int x, int y, int speed, char name) {
		this.speed = speed;
		x = x;
		y = y;
		scoreValue = 200;
		this.setImage(name);
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
    
	/**
	 *Réapparaît le Fantôme dans la cage	 
	 */
	public void respawnInCage() {
	}

	/**
	 * Obtient la cordonnee horizontale de Fantome.
	 * @return la cordonnee horizontale de Fantome.
	 */
	public int getX(){
		return this.x;
	}

	/**
	 * Obtient la cordonnee verticale de Fantome.
	 * @return la cordonnee verticale de Fantome.
	 */
	public int getY(){
		return this.y;
	}
	
	/**
	 * Obtient le score de Fantome.
	 * @return le score de Fantome.
	 */
	public int getValue() {
		return scoreValue;
	}

	/**
	 *  verifie que la direction est bloque par un mur
	 */
	public boolean moveIsAllowed(Direction d) 
	{	
		return true;
	}
	
	protected Direction getAIMove() {
		int curX = this.getX();
		int curY = this.getY();
		PacCompoments state = PacCompoments.getInstance();
		Player pm = state.getPac();
		int targetX = pm.getX();
		int targetY = pm.getY();
		
		tryMove(curX, curY, targetX, targetY);

		lastDirection = curDirection;
		return curDirection;
	}
	
	private void tryMove(int curX, int curY, int targetX, int targetY){
		int horizontalDifference = curX - targetX;
		int verticalDifference = curY - targetY;
		Direction preferredHorizontal = horizontalDifference > 0 ? Direction.LEFT : Direction.RIGHT;
		Direction preferredVertical = verticalDifference > 0 ? Direction.UP : Direction.DOWN;
		boolean verticalMoreImportant = Math.abs(verticalDifference) > Math.abs(horizontalDifference);
		if (verticalMoreImportant)
			curDirection = preferredVertical;
		else
			curDirection = preferredHorizontal;
		if (!this.moveIsAllowed(curDirection)) {
			if (verticalMoreImportant) {
				if (lastDirection == Direction.LEFT || lastDirection == Direction.RIGHT) {
					curDirection = lastDirection;
					if (!this.moveIsAllowed(curDirection))
						curDirection = curDirection == Direction.LEFT ? Direction.RIGHT : Direction.LEFT;
				} else {
					curDirection = preferredHorizontal;
					if (!this.moveIsAllowed(curDirection)) {
						curDirection = preferredHorizontal == Direction.LEFT ? Direction.RIGHT : Direction.LEFT;
						if (!this.moveIsAllowed(curDirection))
							curDirection = preferredVertical == Direction.UP ? Direction.DOWN : Direction.UP;
					}
				}
			} else {
				if (lastDirection == Direction.UP || lastDirection == Direction.DOWN) {
					curDirection = lastDirection;
					if (!this.moveIsAllowed(curDirection))
						curDirection = curDirection == Direction.UP ? Direction.DOWN : Direction.UP;
				} else {
					curDirection = preferredVertical;
					if (!this.moveIsAllowed(curDirection)) {
						curDirection = preferredVertical == Direction.UP ? Direction.DOWN : Direction.UP;
						if (!this.moveIsAllowed(curDirection))
							curDirection = preferredHorizontal == Direction.LEFT ? Direction.RIGHT : Direction.LEFT;
					}
				}
			}
		}
	}
}
