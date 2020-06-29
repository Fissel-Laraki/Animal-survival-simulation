import java.util.Hashtable;
import java.awt.Color;

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
  protected Hashtable proies;

  public void chasser(){
    System.out.println("salut");
  }
  public void se_deplacer(){
    System.out.println("salut");
  }
  public void mourir(){
    System.out.println("salut");
  }
  public void se_reproduire(){
    System.out.println("salut");
  }
  public void setProie(Animal a){
    this.proies.put(a.type,true);
  }

  public int getPosX(){
    return this.pos_x;
  }

  public int getPosY(){
    return this.pos_y;
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

