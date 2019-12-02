import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.AbstractComponent;
import org.newdawn.slick.gui.ComponentListener;
import org.newdawn.slick.gui.MouseOverArea;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuGame extends BasicGameState implements ComponentListener{

	private MouseOverArea btnPlay, btnExit, btnParam;
	private Image backgroundBtnPlay, backgroundBtnExit, backgroundBtnParam, farWestWallpaper, nomJeu, spaceWallpaper;
	private boolean isPressBtnParam, isPressBtnPlay;
	private GameContainer jeu;
	private int stateId=-1;
	private String typeGame="FW";
	private PartieDeJeu partie;
	
	public MenuGame(GameContainer gc, int stateId, PartieDeJeu partie) {
		jeu=gc;
		this.isPressBtnParam=false;
		this.isPressBtnPlay=false;
		this.stateId=stateId;
		this.partie=partie;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		farWestWallpaper=new Image("res/wild_west.png");
		backgroundBtnPlay=new Image("res/btn1.png");
		backgroundBtnExit=new Image("res/btn2.png");
		backgroundBtnParam=new Image("res/btn3.png");
		nomJeu=new Image("res/nomJeu.png").getScaledCopy(0.7f);
		spaceWallpaper=new Image("res/space_wallpaper.jpg").getScaledCopy(1.2f);
		
		
		btnPlay=new MouseOverArea(gc, backgroundBtnPlay, 50,600,100,100,this);
		btnParam=new MouseOverArea(gc, backgroundBtnParam, 330, 600,100,100, this);
		btnExit=new MouseOverArea(gc, backgroundBtnExit,620 , 600, 100, 100, this);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(typeGame=="FW")
			g.drawImage(farWestWallpaper,0,0);
		else
			g.drawImage(spaceWallpaper,0,0);
		
		btnPlay.render(gc, g);
		btnParam.render(gc, g);
		btnExit.render(gc, g);
		g.drawImage(nomJeu, 0, 0);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(isPressBtnParam) {
			this.isPressBtnParam=false;
			sbg.enterState(1);
		} else if(isPressBtnPlay) {
			this.isPressBtnPlay=false;
			sbg.enterState(2);
		}
		
		partie.setTypeGame(typeGame);

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return this.stateId;
	}

	@Override
	public void componentActivated(AbstractComponent source) {
		if(source==this.btnPlay) 
			this.isPressBtnPlay=true;
		else if(source==btnParam)
			isPressBtnParam=true;
		else if(source==btnExit)
			jeu.exit();
		
	}
}
