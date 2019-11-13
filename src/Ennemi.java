import org.newdawn.slick.Graphics;

public abstract class Ennemi {
	private String lettres;
	
	public abstract void render(Graphics g);
	public abstract void update(int delta);
	
}
