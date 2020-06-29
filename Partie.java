public class Partie extends ChampGraphique{
  int nb_tours;
  int[][] grille;

  public Partie(int nb_tours, int taille_x, int taille_y)
  {
    super(taille_x,taille_y);
    this.nb_tours = nb_tours;
    grille = new int[taille_x][taille_y];
  }

  public void remplir_grille()
  {
    for (int i=0; i<this.getHauteur(); i++)
      for (int j=0; j<this.getLargeur(); j++)
        // A modifier pour ne pas remplir tout le tableau (parametre int)
        this.grille[i][j]=1;
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

  /*
  public void ajouter_animaux(int nombre_animaux)
  {
    ArrayList animaux = new ArrayList();
    int i=0;
    while (i<nombre_animaux)
    {
      animaux.add(new );
    }  
  }
*/
}