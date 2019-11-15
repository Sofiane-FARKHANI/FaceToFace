import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LireFichier {
	private BufferedReader lecteur = null;
	private String ligne;
	private ArrayList<String> dico;
	
	/**
	 * Constructeur surchargee
	 * 
	 * Le constructeur permet d acceder au contenu du fichier
	 * 
	 * @param cheminFichier : chemin du fichier
	 */
	public LireFichier(String cheminFichier) {
		try {
			this.lecteur = new BufferedReader(new FileReader(new File(cheminFichier)));
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Erreur lors de l ouverture");
		}
		this.dico = new ArrayList<String>();
	}
	
	/**
	 * Methode permettant de lire l ensemble des lignes d un fichier texte
	 * @return : retourne l ensemble des lignes
	 * @throws IOException
	 */
	public ArrayList<String> lecturesDesLignes() throws IOException {
		while((this.ligne = this.lecteur.readLine()) != null) {
			this.dico.add(ligne);
		}
		this.lecteur.close();
		return this.dico;
	}
}
