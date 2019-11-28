import java.io.IOException;
import java.util.ArrayList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.StateBasedGame;

public class MainTest extends BasicGame {

	// Site d origine de l image
	// http://wallpaperswide.com/low_poly_wild_west-wallpapers.html
	private Image background;
	private TextField saisiUser;

	private ArrayList<Ennemi> ennemis;
	private ArrayList<String> dico;

	private LireFichier fic;

	private Ennemi e;
	private Joueur player;

	private int nbEnnemiVague;

	public MainTest(String name) {
		super(name);
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(this.background, 0, 0);
		for (int i = 0; i < ennemis.size(); i++) {
			ennemis.get(i).render(g);
		}
		player.render(g);
		saisiUser.render(gc, g);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		this.background = new Image("res/wild_west.png");

		this.fic = new LireFichier("res/DicoSansAccent.txt");
		this.dico = new ArrayList<String>();

		// Capture d exception lors de la lecture du fichier txt
		try {
			this.dico = this.fic.lecturesDesLignes();
		} catch (IOException err) {
			err.printStackTrace();
		}

		player = new Joueur();
		saisiUser = new TextField(gc, gc.getDefaultFont(), 50, 620, 200, 30);
		saisiUser.setFocus(true);
		ennemis = new ArrayList<Ennemi>();

		this.genererEnnemi(this.dico);
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if (player.isEstVivant()) {
			if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				String res = saisiUser.getText();
				for (int i = 0; i < ennemis.size(); i++) {
					if (ennemis.get(i).getLettres().hashCode() == res.hashCode()) {
						player.setScore(player.getScore() + 1);
						saisiUser.setText("");
						ennemis.remove(i);
						this.genererEnnemi(dico);
					}
				}
			}
		}

		for (Ennemi ennemi : ennemis) {
			ennemi.update(delta);
			player.tuerJoueur(ennemi);
		}
	}

	/**
	 * Methode permettant de generer un nouvel ennemi
	 * 
	 * @param dictionnaire
	 * @throws SlickException
	 */
	public void genererEnnemi(ArrayList<String> dictionnaire) throws SlickException {
		nbEnnemiVague = (int) (Math.random() * 3) + 1;
		for (int i = 0; i < nbEnnemiVague; i++) {
			int emplacementMot = (int) (Math.random() * dictionnaire.size());
			int typeEnnemi = (int) (Math.random() * 2);
			if (typeEnnemi == 0) {
				e = new EnnemiAPied(dictionnaire.get(emplacementMot));
			} else {
				e = new EnnemiCheval(dictionnaire.get(emplacementMot));
			}
			ennemis.add(e);
		}
	}

	/**
	 * Point d entree du programme
	 * 
	 * @throws IOException
	 */
	/*public static void main(String[] args) throws IOException, SlickException {
		AppGameContainer app;
		app = new AppGameContainer(new MainTest("FaceToFace"));
		app.setDisplayMode(800, 700, false);
		app.setShowFPS(false);
		app.setTargetFrameRate(60);
		app.start();
	}*/
}