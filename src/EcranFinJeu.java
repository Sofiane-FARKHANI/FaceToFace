import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class EcranFinJeu extends BasicGameState implements ComponentListener {
	
	// Le stateID est de 3 lors du fonctionnement
	private int stateID=-1, delai;
	private Image gameOver;

	public EcranFinJeu(int stateID) {
		this.stateID=stateID;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		this.gameOver=new Image("res/game-over-screen.png").getScaledCopy(800, 700);
		this.delai=0;

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.drawImage(gameOver,0,0);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		delai+=delta;
		if(delai>=6000)
			sbg.enterState(0);
	}

	@Override
	public void componentActivated(AbstractComponent ac) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.stateID;
	}

}
