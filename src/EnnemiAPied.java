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
	public EnnemiAPied(String mot, String typeGame) throws SlickException {
		lettres = mot;
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 20;
		if(typeGame.equalsIgnoreCase("FW"))
			this.img=new Image("res/cowboy.png");
		else
			this.img=new Image("res/alien-gun.png").getScaledCopy(0.1f);
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
}
