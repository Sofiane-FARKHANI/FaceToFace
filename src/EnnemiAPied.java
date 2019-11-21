import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EnnemiAPied extends Ennemi {

	private Image img;
	/**
	 * Constructeur par defaut de la classe EnnemiAPied
	 * 
	 * @param mot
	 * @throws SlickException 
	 */
	public EnnemiAPied(String mot) throws SlickException {
		lettres = mot;
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 20;
		this.img=new Image("res/cowboy.png");
	}

	/**
	 * Reecriture de la methode render de Slick
	 * 
	 * La methode permet d afficher l ennemi a l ecran
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.black);
		g.drawString(lettres, x, y - 25);
		g.drawImage(this.img, x, y);

	}

	/**
	 * Reecriture de la methode update de Slick
	 * 
	 * La methode permet de faire avancer l ennemi en direction du joueur
	 */
	@Override
	public void update(int delta) {
		if (x > 100)
			x -= vx * ((float) delta / 1000);
	}

	/**
	 * Ascesseur de mot associe a l ennemi
	 * 
	 * @return : mot affiche au dessus de l ennemi
	 */
	public String getLettres() {
		return lettres;
	}

	/**
	 * Ascesseur de la coordonnee x de l ennemi
	 * 
	 * @return : coordonnee x de l ennemi
	 */
	public float getX() {
		return x;
	}
}
