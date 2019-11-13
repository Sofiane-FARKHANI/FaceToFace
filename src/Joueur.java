import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Joueur {
	
	private boolean estVivant;
	private int x,y;
	
	public Joueur() {
		this.estVivant=true;
		this.x=100;
		this.y=500;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(x, y, 20, 20);
	}
}
