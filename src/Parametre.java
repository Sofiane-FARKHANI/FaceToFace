import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

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
	
	private MouseOverArea btnBack, modeFW, modeSP, modeBob;
	private int stateId = -1;
	private boolean isPressBtnBack, isPressBtnModeFW, isPressBtnModeSP,isPressBtnModeBob;
	private Image backgroundBtnBack, FWMode, SPMode, farWestWallpaper, spaceWallpaper, bobMode, BSMode;
	private LireFichier fileReader;
	private String typeGame;
	private Path fichier = Paths.get("res/info.txt");
	private List<String> lignes;

	public Parametre(int state) {
		this.stateId=state;
		this.isPressBtnBack=false;
		this.isPressBtnModeFW=false;
		this.isPressBtnModeSP=false;
		this.isPressBtnModeBob=false;
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		backgroundBtnBack=new Image("res/btn3Back.png");
		FWMode=new Image("res/farWestMode.png");
		SPMode=new Image("res/spaceMode.png");
		bobMode=new Image("res/bobLand.png");
		BSMode=new Image("res/bikini_bottom.png").getScaledCopy(800, 600);
		btnBack=new MouseOverArea(gc, backgroundBtnBack, 0,0,100,100,this);
		modeFW=new MouseOverArea(gc, FWMode,300,300,100,100, this);
		modeSP=new MouseOverArea(gc, SPMode, 400, 300, 100, 100, this);
		modeBob=new MouseOverArea(gc, bobMode, 500, 300, 100, 100, this);
		fileReader=new LireFichier("res/info.txt");
		
		farWestWallpaper=new Image("res/wild_west.png");
		spaceWallpaper=new Image("res/space_wallpaper.jpg").getScaledCopy(1.2f);
		
		try {
			typeGame = fileReader.lectureDUneLigne();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		
		if(typeGame.equalsIgnoreCase("FW"))
			g.drawImage(farWestWallpaper,0,0);
		else if (typeGame.equalsIgnoreCase("SP"))
			g.drawImage(spaceWallpaper,0,0);
		else
			g.drawImage(BSMode, 0, 0);
		
		btnBack.render(gc, g);
		modeFW.render(gc, g);
		modeSP.render(gc, g);
		modeBob.render(gc,g);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		if(isPressBtnBack || isPressBtnModeFW || isPressBtnModeSP || isPressBtnModeBob){
			this.isPressBtnBack=false;
			this.isPressBtnModeFW=false;
			this.isPressBtnModeSP=false;
			this.isPressBtnModeBob=false;
			sbg.getState(0).init(gc,sbg);
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
		if(source==btnBack)
			this.isPressBtnBack=true;
		else if(source==modeFW) {
			this.isPressBtnModeFW=true;
			if(!typeGame.equalsIgnoreCase("FW")) {
				lignes = Arrays.asList("FW");
				try {
					Files.write(fichier, lignes, Charset.forName("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else if(source==modeSP) {
			if(!typeGame.equalsIgnoreCase("SP")) {
				lignes = Arrays.asList("SP");
				try {
					Files.write(fichier, lignes, Charset.forName("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			this.isPressBtnModeSP=true;
		} else if(source == modeBob) {
			if(!typeGame.equalsIgnoreCase("BS")) {
				lignes = Arrays.asList("BS");
				try {
					Files.write(fichier, lignes, Charset.forName("UTF-8"));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			this.isPressBtnModeBob = true;
		}
		
	}

}
