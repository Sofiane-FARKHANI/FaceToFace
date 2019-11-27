import org.newdawn.slick.Graphics;

/**
 * Classe abstraite permettant de definir le comportement de base d un ennemi
 * @author Sofiane Farkhani
 *
 */
public abstract class Ennemi {
	
	protected String lettres;
	protected float x, y, vx; 
	
	/**
	 * Methode permettant de recuperer le mot d un ennemi
	 * @return : retourne le mot correspondant a l ennemi
	 */
	public String getLettres() {
		return this.lettres;
	}
	
	/**
	 * Methode permettant de recuperer la coordonnee x de l ennemi
	 * @return : valeur de la coordonnee x de l ennemi
	 */
	public float getX() {
		return this.x;
	}
	
	public abstract void render(Graphics g);
	public abstract void update(int delta);
	
	
}