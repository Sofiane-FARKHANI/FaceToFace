import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Joueur {

	private boolean estVivant;
	private int x, y, score;
	private Image img, fondMsgMort;

	/**
	 * Constructeur par defaut de la classe Joueur
	 * @throws SlickException 
	 */
	public Joueur() throws SlickException {
		this.estVivant = true;
		this.x = 100;
		this.y = 500;
		this.img = new Image("res/perso.png");
		this.fondMsgMort=new Image("res/bulle.png");
	}

	/**
	 * Methode permettant l affichage a l ecran du joueur
	 * 
	 * @param g : objet contenant l ensemble des methodes de rendu
	 */
	public void render(Graphics g) {
		g.drawImage(img, x, y);
		g.setColor(Color.white);
		g.drawString("Scores : " + this.score, 700, 650);
		if (!this.estVivant) {
			g.drawImage(fondMsgMort, x+20, y-60);
			g.setColor(Color.black);
			g.drawString("AIE !", x+45, y-45);
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