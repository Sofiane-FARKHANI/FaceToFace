import org.newdawn.slick.Graphics;

/**
 * Classe abstraite permettant de definir le comportement de base d un ennemi
 * @author Sofiane Farkhani
 *
 */
public abstract class Ennemi {
	protected String lettres;
	protected float x, y, vx; 
	
	public String getLettres() {
		return this.lettres;
	}
	
	public float getX() {
		return this.x;
	}
	
	public abstract void render(Graphics g);
	public abstract void update(int delta);
}