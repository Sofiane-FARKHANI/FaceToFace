import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Joueur {
	
	private boolean estVivant;
	private int x,y, score;
	
	public Joueur() {
		this.estVivant=true;
		this.x=100;
		this.y=500;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(x, y, 20, 20);
		g.setColor(Color.white);
		g.drawString("Scores : "+this.score, 700, 650);
		if(!this.estVivant) {
			g.drawString("Vous êtes nul !", 400, 650);
		}
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(score>=0)
			this.score = score;
	}

	public boolean isEstVivant() {
		return estVivant;
	}

	public void tuerJoueur(Ennemi e) {
		if(((EnnemiAPied)e).getX()<=this.x) {
			this.estVivant=false;
		}
	}
	
	
}
