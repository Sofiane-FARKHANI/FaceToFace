import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EcranFinJeu extends BasicGameState {
	
	// Le stateID est de 3 lors du fonctionnement
	private int stateID=-1, delai;
	private Image gameOver;

	public EcranFinJeu(int stateID) {
		this.stateID=stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		this.gameOver=new Image("res/game-over-screen.png").getScaledCopy(600, 700);
		this.delai=0;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setBackground(Color.black);
		g.drawImage(gameOver,100,0);
		g.setColor(Color.white);
		g.drawString("PRESS ENTER TO CONTINUE", 300, 600);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
			sbg.enterState(0);
		}	
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.stateID;
	}

}
