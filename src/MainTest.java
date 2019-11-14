import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
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
	private Ennemi e;
	private Joueur player;
	private TextField saisiUser;
	private int nbEnnemiVague;
	
	public MainTest(String name) {
		super(name);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(this.background, 0, 0);
		for (int i=0;i<ennemis.size();i++) {
			ennemis.get(i).render(g);
		}
		player.render(g);
		saisiUser.render(gc, g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.background = new Image("res/wild_west.png");
		player = new Joueur();
		saisiUser = new TextField(gc, gc.getDefaultFont(), 50, 620, 200, 30);
		ennemis = new ArrayList<Ennemi>();
		
		this.genererEnnemi();
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if(player.isEstVivant()) {
			for (int i=0;i<ennemis.size();i++) {
				if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
					if(ennemis.get(i) instanceof EnnemiAPied) {
						if(saisiUser.getText().compareTo(((EnnemiAPied) ennemis.get(i)).getLettres())==0) {
							player.setScore(player.getScore()+1);
							ennemis.remove(i);
							saisiUser.setText("");
							this.genererEnnemi();
						}
					} else if(ennemis.get(i) instanceof EnnemiCheval) {
						if(saisiUser.getText().compareTo(((EnnemiCheval) ennemis.get(i)).getLettres())==0) {
							player.setScore(player.getScore()+1);
							ennemis.remove(i);
							saisiUser.setText("");
							this.genererEnnemi();
						}
					}
				}
				break;
			}

			for (int i=0;i<ennemis.size();i++) {
				ennemis.get(i).update(delta);
				player.tuerJoueur(ennemis.get(i));
			}
		}
	}
	
	public void genererEnnemi() {
		nbEnnemiVague = (int)(Math.random()*player.getScore()+1);
		for(int i=0;i<nbEnnemiVague;i++) {
			int typeEnnemi = (int)(Math.random()*2);
			if(typeEnnemi==0) {
				e = new EnnemiAPied();
			} else {
				e = new EnnemiCheval();
			}
			ennemis.add(e);
		}
	}
	
	/**
	 * Point d entree du programme
	 */
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
