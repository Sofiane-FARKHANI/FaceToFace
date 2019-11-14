import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class EnnemiAPied extends Ennemi {
	
	private String lettres;
	private float x,y,vx;
	private boolean estMort;
	
	public EnnemiAPied() {
		this.lettres = "test";
		this.x=600;
		this.y=(int)(Math.random()*100+400);
		this.vx=50;
		this.estMort=false;
	}

	@Override
	public void render(Graphics g) {
		if(!this.estMort) {
			g.setColor(Color.black);
			g.drawString(lettres, x, y-25);
			g.fillRect(x, y, 20, 20);
		}
	}

	@Override
	public void update(int delta) {
		if (!this.estMort) {
			if(this.x>100)
				this.x-=vx*((float)delta/1000);
		}
	}

	public String getLettres() {
		return this.lettres;
	}

	public void setEstMort(boolean estMort) {
		this.estMort = estMort;
	}

	public float getX() {
		return x;
	}
}
