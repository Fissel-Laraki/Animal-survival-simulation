import java.util.Hashtable;
import java.awt.Color;
import java.util.Random;

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
  protected Hashtable<Animal,Boolean> proies;

  public boolean manger(Animal proie){
    Random r = new Random();
    boolean attaquer = r.nextInt(this.bonus)+this.ATK > proie.DEF; 
    return attaquer;
  }

  

  public void se_reproduire(){
    System.out.println("salut");
  }
 
  public void se_deplacer(int hauteur, int largeur)
  {
    Random r = new Random();
    int nb;
    int i=0, temp_i;
    while(i<this.vitesse)
    {
      temp_i=i;
      nb = r.nextInt(8);
      if (nb==0 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosY(this.getPosY()-1);
        i++;
      }
      else if (nb==1 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()+1);
        this.setPosY(this.getPosY()-1);
        i++;
      }
      else if (nb==2 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()+1);
        i++;
      }
      else if (nb==3 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()+1);
        this.setPosY(this.getPosY()+1);
        i++;
      }
      else if (nb==4 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosY(this.getPosY()+1);
        i++;
      }
      else if (nb==5 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()-1);
        this.setPosY(this.getPosY()+1);
        i++;
      }
      else if (nb==6 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()-1);
        i++;
      }
      else if (nb==7 && this.getPosX()<hauteur && this.getPosY()<largeur && temp_i==i){
        this.setPosX(this.getPosX()-1);
        this.setPosY(this.getPosY()-1);
        i++;
      }
      else
        System.out.println("Erreur lors du déplacement!");
    } 
  }
  
  public void mourir(){
    System.out.println("salut");
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
}

