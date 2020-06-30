import javax.swing.JFrame;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main 
{
	public static void main(String[] args)
	{
	  // Constantes des nombres d'animaux
	  int nb_poule = 11;
	  int nb_renard = 12;
	  int nb_vipere = 13;

	  // Constantes de la taille du plateau
	  int hauteur = 60;
	  int largeur = 60;

	  // La liste permettant de stocker tout les animaux au départ
	  List<Animal> animaux = new LinkedList<Animal>();
	  /*ListIterator animauxIterator;
	  animauxIterator = animaux.listIterator();*/

	  // Le random qui nous permettra de disperser les animaux dans le plateau
	  Random r = new Random();

	  // Les postions x et y de chaque animal
	  int x;
	  int y;

    Partie p = new Partie(100,largeur,hauteur);

	  // On remplit la liste en fonction des nb_<animal> 
	  for (int i = 0 ; i < nb_poule + nb_vipere + nb_renard ; i++ )
    {
	    // On met a jour x et y
	    x = r.nextInt(largeur);
	    y = r.nextInt(hauteur);
	      
	    // Vérifie si une case n'est pas déjà occuppée.
	    while(p.getCase(x,y)==2){
		    x = r.nextInt(largeur);
		    y = r.nextInt(hauteur);
	    }

	    if (i < nb_poule)
      {
		    animaux.add(new Poule(0,x,y));
	    }
      else if (i-nb_poule < nb_renard)
      {
		    animaux.add(new Renard(0,x,y));
	    }
      else
      {
		    animaux.add(new Vipere(0,x,y));
      }
      p.setCase(x,y);
    }

	  p.setAnimaux(animaux);
    p.simuler();
	  
	}
}
