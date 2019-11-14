import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EnnemiCheval extends Ennemi {
	
	private String lettres;
	private float x,y,vx;
	private boolean estMort;
	
	/**
	 * Constructeur par defaut de la classe EnnemiCheval
	 */
	public EnnemiCheval() {
		this.lettres = "cheval";
		this.x=600;
		this.y=(int)(Math.random()*100+400);
		this.vx=100;
		this.estMort=false;
	}

	/**
	 * Reecriture de la methode render de Slick pour faire afficher l ennemi sur l ecran
	 */
	@Override
	public void render(Graphics g) {
		if(!this.estMort) {
			g.setColor(Color.red);
			g.drawString(lettres, x, y-25);
			g.fillRect(x, y, 20, 20);
		}
	}

	/**
	 * Reecriture de la methode update de Slick
	 * 
	 * La methode permet a l ennemi d avancer en direction du joueur
	 */
	@Override
	public void update(int delta) {
		if (!this.estMort) {
			if(this.x>100)
				this.x-=vx*((float)delta/1000);
		}
	}

	/**
	 * Ascesseur du mot associe a l ennemi
	 * @return : mot affiche au dessus de l ennemi
	 */
	public String getLettres() {
		return this.lettres;
	}

	/**
	 * Mutateur de l etat de l ennemi
	 * @param estMort : nouvel etat de l ennemi
	 * 		true	: l ennemi est mort
	 * 		false	: l ennemi est en vie
	 */
	public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

	/**
	 * Ascesseur a la coordonnee x de l ennemi
	 * @return : coordonnee x de l ennemi
	 */
	public float getX() {
		return x;
	}
}
