import java.io.IOException;
import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class PartieDeJeu extends BasicGameState {
	
	// Site d origine de l image
	// http://wallpaperswide.com/low_poly_wild_west-wallpapers.html
	private Image backgroundFW, backgroundSP, backgroundBS;
	private TextField saisiUser;

	private ArrayList<Ennemi> ennemis;
	private ArrayList<String> dico;

	private LireFichier fic, infoJeu;

	private Ennemi e;
	private Joueur player;
	private String typeGame;

	private int nbEnnemiVague, stateId=-1;
	
	public PartieDeJeu(int stateId) {
		this.stateId=stateId;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.backgroundFW = new Image("res/wild_west.png");
		this.backgroundSP = new Image("res/space_wallpaper.jpg").getScaledCopy(1.2f);
		this.backgroundBS=new Image("res/bikini_bottom.png").getScaledCopy(800, 600);
		
		this.fic = new LireFichier("res/DicoSansAccent.txt");
		this.infoJeu = new LireFichier("res/info.txt");
		this.dico = new ArrayList<String>();
		
		// Capture d exception lors de la lecture du fichier txt
		try {
			this.dico = this.fic.lecturesDesLignes();
			this.typeGame = this.infoJeu.lectureDUneLigne();
		} catch (IOException err) {
			err.printStackTrace();
		}

		player = new Joueur(typeGame);
		saisiUser = new TextField(gc, gc.getDefaultFont(), 50, 620, 200, 30);
		saisiUser.setFocus(true);
		ennemis = new ArrayList<Ennemi>();

		this.genererEnnemi(this.dico);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if(typeGame.equalsIgnoreCase("FW"))
			g.drawImage(this.backgroundFW, 0, 0);
		else if(typeGame.equalsIgnoreCase("SP"))
			g.drawImage(this.backgroundSP, 0, 0);
		else
			g.drawImage(backgroundBS, 0, 0);
		
		for (int i = 0; i < ennemis.size(); i++) {
			ennemis.get(i).render(g);
		}
		player.render(g);
		saisiUser.render(gc, g);
		saisiUser.setFocus(true);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		if (player.isEstVivant()) {
			if (gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
				String res = saisiUser.getText();
				for (int i = 0; i < ennemis.size(); i++) {
					if (ennemis.get(i) instanceof Boss) {
						if(((Boss) ennemis.get(i)).comparaisonMotAfficher(res)) {
							if(((Boss) ennemis.get(i)).nbMotRestant()==1) {
								ennemis.remove(i);
								player.setScore(player.getScore()+5);
								saisiUser.setText("");
							}
							else {
								((Boss) ennemis.get(i)).supprMot();
								saisiUser.setText("");
							}
						} else {
							for(int j=0; j<ennemis.size();j++) {
								ennemis.get(j).setVx(ennemis.get(j).getVx()*1.25f);
							}
						}
							
					} else {
						if (ennemis.get(i).getLettres().hashCode() == res.hashCode()) {
							player.setScore(player.getScore() + 1);
							saisiUser.setText("");
							ennemis.remove(i);
						}else {
							for(int j=0; j<ennemis.size();j++) {
								ennemis.get(j).setVx(ennemis.get(j).getVx()*1.25f);
							}
						}
					}
				}
			}
		} else {
			sbg.enterState(3);
		}

		for (Ennemi ennemi : ennemis) {
			ennemi.update(delta);
			player.tuerJoueur(ennemi);
		}
	}

	/**
	 * Méthode retournant l'identifiant de l'état
	 */
	@Override
	public int getID() {
		return this.stateId;
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
			int typeEnnemi = (int) (Math.random() * 3);
			switch (typeEnnemi) {
			case 0:
				e = new EnnemiAPied(dictionnaire.get(emplacementMot), this.typeGame);
				break;
			case 1:
				e = new EnnemiCheval(dictionnaire.get(emplacementMot), this.typeGame);
				break;
			case 2:
				e = new Boss(dictionnaire, this.typeGame);
				break;
			default:
				e = new EnnemiAPied(dictionnaire.get(emplacementMot), this.typeGame);
			}
				
			ennemis.add(e);
		}
	}

}
