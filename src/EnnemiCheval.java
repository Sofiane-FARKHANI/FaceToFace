import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class EnnemiCheval extends Ennemi {
	
	/**
	 * Constructeur par defaut de la classe EnnemiCheval
	 * 
	 * @param mot
	 * @throws SlickException 
	 */
	public EnnemiCheval(String mot, String typeGame) throws SlickException {
		lettres = mot;
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 40;
		if(typeGame.equalsIgnoreCase("FW"))
			this.img = new Image("res/cowboy__horse.png");
		else if(typeGame.equalsIgnoreCase("SP"))
			this.img=new Image("res/alien_volant.png").getScaledCopy(0.2f);
		else
			this.img=new Image("res/patrick.png");
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
