import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EnnemiCheval extends Ennemi {

	//https://dribbble.com/shots/5504359-Cute-cartoon-cowboy-on-his-horse
	private Image img;	
	
	/**
	 * Constructeur par defaut de la classe EnnemiCheval
	 * 
	 * @param mot
	 * @throws SlickException 
	 */
	public EnnemiCheval(String mot) throws SlickException {
		lettres = mot;
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 40;
		this.img = new Image("res/cowboy__horse.png");
	}

	/**
	 * Reecriture de la methode render de Slick pour faire afficher l ennemi sur l
	 * ecran
	 */
	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.drawString(lettres, x, y - 25);
		//g.fillRect(x, y, 20, 20);
		g.drawImage(this.img, x, y);
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
}
