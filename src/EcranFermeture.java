import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EcranFermeture extends BasicGameState {

	private int stateID=-1;
	private Image drole;
	private boolean nPress, oPress;
	
	public EcranFermeture(int stateID) {
		this.stateID=stateID;
		nPress=false;
		oPress=false;
	}
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		this.drole = new Image("res/wtf.jpg").getScaledCopy(1.5f);
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.clear();
		g.setBackground(Color.white);
		g.drawImage(drole, 100, 0);
		g.setColor(Color.black);
		g.drawString("ES-TU SUR DE VOULOIR ME FERMER ?", 300, 600);
		g.drawString("O(oui) / N(non)", 300, 630);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(oPress) {
			gc.exit();
		} else if(nPress){
			nPress=false;
			sbg.enterState(0);
		}
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.stateID;
	}
	
	@Override
	public void keyPressed(int key, char c) {
		if(key==Input.KEY_O) {
			oPress=true;
		} else if(key==Input.KEY_N) {
			nPress=true;
		}
	}

}
