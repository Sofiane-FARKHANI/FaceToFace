import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {
	
	private PartieDeJeu partie=new PartieDeJeu(2);

	public Game(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		addState(new MenuGame(gc,0, partie));
		addState(new Parametre(1));
		addState(partie);
		addState(new EcranFinJeu(3));

	}

	public static void main(String[] args) {
		AppGameContainer app;
		try {
			app = new AppGameContainer(new Game("FaceToFace"));
			app.setDisplayMode(800, 700, false);
			app.setShowFPS(false);
			app.setTargetFrameRate(60);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		

	}

}
