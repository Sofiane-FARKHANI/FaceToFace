import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EnnemiCheval extends Ennemi {

	/**
	 * Constructeur par defaut de la classe EnnemiCheval
	 * 
	 * @param mot
	 */
	public EnnemiCheval(String mot) {
		lettres = mot;
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 40;
	}

	/**
	 * Reecriture de la methode render de Slick pour faire afficher l ennemi sur l
	 * ecran
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString(lettres, x, y - 25);
		g.fillRect(x, y, 20, 20);
	}

	/**
	 * Reecriture de la methode update de Slick
	 * 
	 * La methode permet a l ennemi d avancer en direction du joueur
	 */
	@Override
	public void update(int delta) {
		if (x > 100)
			x -= vx * ((float) delta / 1000);
	}

	/**
	 * Ascesseur du mot associe a l ennemi
	 * 
	 * @return : mot affiche au dessus de l ennemi
	 */
	public String getLettres() {
		return lettres;
	}

	/**
	 * Ascesseur a la coordonnee x de l ennemi
	 * 
	 * @return : coordonnee x de l ennemi
	 */
	public float getX() {
		return x;
	}
}
