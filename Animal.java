import java.util.Hashtable;
import java.awt.Color;
import java.util.Random;
import java.awt.Point;
import java.util.LinkedList;
import java.util.List;

abstract class Animal {
  
  protected int age;
  protected int pos_x;
  protected int pos_y;
  protected String type;
  protected String couleur;
  protected double p_detection_proie;
  protected double p_reproduction;
  protected int bonus;
  protected int ATK;
  protected int DEF;
  protected int vitesse;
  protected int endurance_alimentaire;
  protected int esperance_vie;
  protected boolean etat_mort;
  protected Hashtable<Animal,Boolean> proies;

  public boolean manger(Animal proie){
    Random r = new Random();
    boolean attaquer = r.nextInt(this.bonus)+this.ATK > proie.DEF; 
    return attaquer;
  }
 
  public void se_deplacer(int hauteur, int largeur,int[][] grille){
    Random r = new Random();
    Point tmp ; 
    LinkedList<Point> casesPossibles = new LinkedList<Point>();
    int x = this.getPosX();
    int y = this.getPosY();
    for(int i = 0; i<this.vitesse; i++)
    {
      tmp = nextCase(grille,casesPossibles,x,y,hauteur,largeur);
      x = tmp.x;
      y = tmp.y;
    } 
    this.setPosX(x);
    this.setPosY(y);
  }
  
  public void mourir(){
    if(this.endurance_alimentaire==0 || this.age==esperance_vie)
    {
      this.etat_mort=true;
      this.type="All";
      this.p_detection_proie=0;
      this.vitesse=0;
      this.p_reproduction=0;
      this.DEF=-1;
    } 
  }
 
  public void setProie(Animal a){
    //this.proies.put(a.type,true);
  }

  public int getPosX(){
    return this.pos_x;
  }

  public int getPosY(){
    return this.pos_y;
  }

  public void setPosX(int x){
    this.pos_x=x;
  }

  public void setPosY(int y){
    this.pos_y=y;
  }
  
  public Color getColor(){
    switch(this.couleur)
    {
      case "Jaune":
        return Color.YELLOW;
      case "Orange":
        return Color.ORANGE;
      case "Vert":
        return Color.GREEN;
      default:
        return Color.BLACK; 
    }
  }

  public String toString(){
    return "Je suis un(e) " + this.type + " je me positionne à  " + this.pos_x + " : " + this.pos_y;
  }

  private Point nextCase(int[][] grille,List<Point> casesPossibles,int x, int y,int hauteur,int largeur){
    
    Random r = new Random();

    int a= x-1 < 0 ? x : x-1;
    int b = y-1 < 0 ? y : y-1;
    int c = x+2 > largeur ? x+1 : x+2;
    int d = y+2 > hauteur ? y+1 : y+2;

    for (int i = a ; i < c ; i++){
      for (int j = b; j < d ; j++){
        if (grille[i][j] == 1){
          casesPossibles.add(new Point(i,j));
        }
      }
    }

    return casesPossibles.get(r.nextInt(casesPossibles.size()));
  }
}

