import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Joueur {

	private boolean estVivant;
	private int x, y, score;

	/**
	 * Constructeur par defaut de la classe Joueur
	 */
	public Joueur() {
		this.estVivant = true;
		this.x = 100;
		this.y = 500;
	}

	/**
	 * Methode permettant l affichage a l ecran du joueur
	 * 
	 * @param g : objet contenant l ensemble des methodes de rendu
	 */
	public void render(Graphics g) {
		g.setColor(Color.magenta);
		g.fillRect(x, y, 20, 20);
		g.setColor(Color.white);
		g.drawString("Scores : " + this.score, 700, 650);
		if (!this.estVivant) {
			g.drawString("Vous êtes nul !", 400, 650);
		}
	}

	/**
	 * Ascesseur du score
	 * 
	 * @return : retourne la valeur du score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Mutateur du score
	 * 
	 * @param score : nouvelle valeur du score
	 */
	public void setScore(int score) {
		if (score >= 0)
			this.score = score;
	}

	/**
	 * Ascesseur a l etat du joueur
	 * 
	 * @return : retourne l etat du joueur true : le joueur est en vie false : le
	 *         joueur a perdu la partie
	 */
	public boolean isEstVivant() {
		return estVivant;
	}

	/**
	 * Methode permettant de changer d etat le joueur Passe le joueur de l etat en
	 * vie à mort
	 * 
	 * La methode test si un ennemi est arrive au niveau du joueur
	 * 
	 * @param e : Ennemi que l on souhaite tester
	 */
	public void tuerJoueur(Ennemi e) {
		if (e instanceof EnnemiAPied) {
			if (((EnnemiAPied) e).getX() <= this.x)
				this.estVivant = false;
		} else if (e instanceof EnnemiCheval) {
			if (((EnnemiCheval) e).getX() <= this.x)
				this.estVivant = false;
		}
	}
}