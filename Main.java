import javax.swing.JFrame;
import java.util.Random;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main 
{
  
	public static void main(String[] args)
	{
    // Constantes des nombres d'animaux
    int nb_poule = 10;
    int nb_renard = 12;
    int nb_vipere = 13;

    // Constantes de la taille du plateau
    int hauteur = 60;
    int largeur = 60;

    // La liste permettant de stocker tout les animaux au départ
    List<Animal> animaux = new LinkedList<Animal>();
    ListIterator animauxIterator;

    // Le random qui nous permettra de disperser les animaux dans le plateau
    Random r = new Random();

    // Les postions x et y de chaque animal
    int x;
    int y;

    // On remplit la liste en fonction des nb_<animal> 
    for (int i = 0 ; i < nb_poule + nb_vipere + nb_renard ; i++ ){
      // On met a jour x et y
      x = r.nextInt(largeur);
      y = r.nextInt(hauteur);

      if (i< nb_poule){
          animaux.add(new Poule(0,x,y));
      }else if (i-nb_poule < nb_renard){
          animaux.add(new Renard(0,x,y));
      }else{
          animaux.add(new Vipere(0,x,y));
      }
    }

    Partie p = new Partie(100,largeur,hauteur);
    animauxIterator = animaux.listIterator();
    for(Animal a : animaux){
      p.colorierCase(a.getPosX(),a.getPosY());
    }
    /*
		int posx, posy;
		//On crée un objet ChampGraphique de 50 cases de large, et 60 de haut
		ChampGraphique grid = new ChampGraphique(400, 600);
		
		Random r = new Random();
		
		int i;
		//Trente fois...
		for(i=0; i<30; i++)
		{
			//on tire une case au hasard dans la grille
			posx = r.nextInt(grid.getLargeur());

      
			//et on la colorie en rouge
			grid.colorierCase(posx, posy);
			
			//Puis, pause de 2s
			try 
			{
	            Thread.sleep(500);
	        } 
			catch (InterruptedException e) 
			{
	            e.printStackTrace();
	        }
		}
         
  */
  
        
	}
}
