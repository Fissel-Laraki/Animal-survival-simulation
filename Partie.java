import java.util.Hashtable;
import java.util.Random;
import java.util.List;

public class Partie extends ChampGraphique{
  
  private int nb_tours;
  private List<Animal> animaux;
  private Hashtable<String,Animal> grille_animaux;
  private int[][] grille;
  
  public Partie(int nb_tours, int taille_x, int taille_y)
  {
    super(taille_x,taille_y);
    this.nb_tours = nb_tours;
    grille = new int[taille_x][taille_y];
    grille_animaux = new Hashtable<String,Animal>();
    this.remplir_grille();
  }

  private void remplir_grille(){
    for (int i=0; i<this.getHauteur(); i++)
      for (int j=0; j<this.getLargeur(); j++)
        // A modifier pour ne pas remplir tout le tableau (parametre int)
        this.grille[i][j]=1;
  }

  private void remplir_grille_animaux(){
    for (Animal a: this.animaux){
      grille_animaux.put(a.pos_x+","+a.pos_y,a); 
    }
  }

  public void simuler(){
    Animal proie = null;
    while (this.animaux.size() > 0){
      for(Animal a : this.animaux){
	      
        // Executer actions  
        //On essaye de detecter une proie dans les cases à cotés
       	proie = detecter_proie(a);
        //Si on a bien detecter une proie
        if (proie != null){
          if(!(a.manger(proie))){
		  // Si il n'a pas mangé la proie il peut alors essayer de se reproduire et la proie doit s'enfuir (se deplacer)
            maj(proie.getPosX(),proie.getPosY(),proie);
          }

        }
	super.colorierCase(a.getColor(),a.getPosX(),a.getPosY());
	try{
		Thread.sleep(500);
	}catch(InterruptedException e){
	       	e.printStackTrace();
	}

      }   
    }
  }

  private void maj(int x, int y, Animal a){
	  /*On enleve l'animal mort de la grille*/
	  this.grille[x][y] = 1;
	  /*On supprime l'animal de la table de hachage*/
	  this.grille_animaux.remove(x+","+y);
	  /*On supprime l'animal de la liste chainée*/
	  this.animaux.remove(a);
    
  }

  public void setAnimaux(List<Animal> animaux){
    this.animaux = animaux;
  }
  
  public int getCase(int x, int y)
  {
    return this.grille[x][y];
  }

  public void setCase(int x, int y)
  {
    this.grille[x][y]=2;
  }

  public int getTours()
  {
    return this.nb_tours;
  }

  public boolean se_reproduire(Animal ani){
    int a = ani.getPosX()-1 < 0 ? ani.getPosX() : ani.getPosX()-1;
    int b = ani.getPosY()-1 < 0 ? ani.getPosY() : ani.getPosY()-1;
    int c = ani.getPosX()+2 > this.getLargeur() ? ani.getPosX()+1 : ani.getPosX()+2;
    int d = ani.getPosY()+2 > this.getHauteur() ? ani.getPosY()+1 : ani.getPosY()+2;

    Random r = new Random();
    int hasard = 0;

    for (int i = a ; i < c ; i++){
      for (int j = b ; j < d ; j++){
        if ( this.grille[i][j] == 2  ){
          hasard = r.nextInt(100);
          if (hasard <= ani.p_reproduction*100 && ani.type.equals(grille_animaux.get(i+','+j).type)){
            return true;
          }
        }
      }
    }
    return false;
  }

  public Animal detecter_proie(Animal ani){
    int a= ani.getPosX()-1 < 0 ? ani.getPosX() : ani.getPosX()-1;
    int b = ani.getPosY()-1 < 0 ? ani.getPosY() : ani.getPosY()-1;
    int c = ani.getPosX()+2 > this.getLargeur() ? ani.getPosX()+1 : ani.getPosX()+2;
    int d = ani.getPosY()+2 > this.getHauteur() ? ani.getPosY()+1 : ani.getPosY()+2;

    Random r = new Random();
    int hasard = 0;

    for (int i = a ; i < c ; i++){
      for (int j=b ; j < d ; j++){
        if ( this.grille[i][j] == 2 ){
          hasard = r.nextInt(100);
          if (hasard <= ani.p_detection_proie*100){
            return grille_animaux.get(i+','+j);
          }
        } 
      }
    }
    return null;
  }
}
