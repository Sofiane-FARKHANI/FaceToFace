import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Boss extends Ennemi {
	
	private ArrayList<String> mots;
	
	public Boss(ArrayList<String> dico, String typeGame) throws SlickException {
		int nbMotAlea = (int)(Math.random()*3)+1;
		this.mots = new ArrayList<String>();
		for(int i=0;i<nbMotAlea;i++) {
			int pos = (int)(Math.random()*dico.size());
			this.mots.add(dico.get(pos));
		}
		
		if(typeGame.equalsIgnoreCase("FW"))
			this.img=new Image("res/boss.png");
		else if(typeGame.equalsIgnoreCase("SP"))
			this.img=new Image("res/boss_alien.png");
		else
			this.img=new Image("res/boss_bob.png");
		
		x = 600;
		y = (int) (Math.random() * 100 + 400);
		vx = 5;
	}
	
	@Override
	public void render(Graphics g) {
		g.drawImage(img, x, y);
		g.setColor(Color.black);
		g.drawString(mots.get(0), x, y-25);
		
	}

	@Override
	public void update(int delta) {
		if (x > 100)
			x -= vx * ((float) delta / 1000);
	}
	
	public void supprMot() {
		this.mots.remove(0);
	}
	
	public boolean comparaisonMotAfficher(String motSaisi) {
		return this.mots.get(0).hashCode() == motSaisi.hashCode();
	}
	
	public int nbMotRestant() {
		return this.mots.size();
	}

}
