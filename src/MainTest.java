import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;

public class MainTest extends BasicGame{

	// Site d origine de l image
	// http://wallpaperswide.com/low_poly_wild_west-wallpapers.html
	private Image background;
	
	private ArrayList<Ennemi> ennemis;
	private EnnemiAPied e;
	private EnnemiCheval ec;
	private Joueur player;
	private TextField saisiUser;
	
	public MainTest(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(this.background, 0, 0);
		e.render(g);
		ec.render(g);
		player.render(g);
		saisiUser.render(gc, g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.background = new Image("res/wild_west.png");
		e = new EnnemiAPied();
		ec = new EnnemiCheval();
		player = new Joueur();
		saisiUser = new TextField(gc, gc.getDefaultFont(), 50, 620, 200, 30);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if(player.isEstVivant()) {
			if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				if(saisiUser.getText().compareTo(e.getLettres())==0) {
					player.setScore(player.getScore()+1);
					e.setEstMort(true);
					saisiUser.setText("");
				}
			}
			ec.update(delta);
			e.update(delta);
			player.tuerJoueur(e);
		}
	}
	
	public static void main(String[] args){
		AppGameContainer app;
		try {
			app = new AppGameContainer(new MainTest("FaceToFace"));
			app.setDisplayMode(800, 700, false);
			app.setShowFPS(false);
			app.setTargetFrameRate(60);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

}
