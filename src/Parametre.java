import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Parametre extends BasicGameState implements ComponentListener {
	
	private MouseOverArea btnBack;
	private int stateId = -1;
	private boolean isPressBtnBack;
	private Image backgroundBtnBack;

	public Parametre(int state) {
		this.stateId=state;
		this.isPressBtnBack=false;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		backgroundBtnBack=new Image("res/btn3.png");
		btnBack=new MouseOverArea(gc, backgroundBtnBack, 0,0,100,100,this);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		btnBack.render(gc, g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(isPressBtnBack) {
			this.isPressBtnBack=false;
			sbg.enterState(0);
		}
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.stateId;
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if(source==btnBack) {
			this.isPressBtnBack=true;
		}
		
	}

}
