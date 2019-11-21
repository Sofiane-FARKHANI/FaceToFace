import org.newdawn.slick.Graphics;

public abstract class Ennemi {

	protected String lettres;
	protected float x, y, vx; 
	
	public abstract void render(Graphics g);

	public abstract void update(int delta);

}
