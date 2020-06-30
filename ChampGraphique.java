import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

//Merci à StackOverflow pour sa précieuse contribution !


public class ChampGraphique extends JPanel
{
	private int largeur, hauteur;
	
	protected List<Coord> casesAColorier;

	/**
	 * Constructeur.
	 * @param largeur La largeur (en nombre de cases) de la grille affichée.
	 * @param hauteur La hauteur (en nombre de cases) de la grille affichée.
	 */
	public ChampGraphique(int largeur, int hauteur) 
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		casesAColorier = new ArrayList<Coord>();

		JFrame window = new JFrame();
		window.setSize(largeur*10+50, hauteur*10+50);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.add(this);
		window.setVisible(true);
	}

	@Override
	//Fonction d'affichage de la grille.
	protected void paintComponent(Graphics g) 
	{	
		int cellX = 0; 
		int cellY = 0;
		
		super.paintComponent(g);

		for (Coord fillCell : casesAColorier) 
		{
			cellX = 10 + (fillCell.x * 10);
			cellY = 10 + (fillCell.y * 10);

			g.setColor(fillCell.color);
			g.fillRect(cellX, cellY, 10, 10);
		}
		
		g.setColor(Color.BLACK);
		g.drawRect(10, 10, largeur*10, hauteur*10);

		for (int i = 10; i <= largeur*10; i += 10) {
			g.drawLine(i, 10, i, hauteur*10+10);
		}

		for (int i = 10; i <= hauteur*10; i += 10) {
			g.drawLine(10, i, largeur*10+10, i);
		}
	}

	/**
	 * Fonction permettant de colorier, en rouge, une case de la grille
	 * @param x Abscisse de la case à colorier (entre 0 et largeur de grille - 1).
	 * @param y Ordonnée de la case à colorier (entre 0 et hauteur de grille - 1).
	 */
	public void colorierCase(Coord c) 
	{
		casesAColorier.add(c);
		repaint();
	}
	
	/**
	 * Accesseur.
	 * @return Renvoie la largeur de la grille
	 */
	public int getLargeur()
	{
		return largeur;
	}
	
	/**
	 * Accesseur.
	 * @return Renvoie la hauteur de la grille
	 */
	public int getHauteur()
	{
		return hauteur;
	}
}
