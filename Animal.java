import java.util.Hashtable;

abstract class Animal {
  protected int age;
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

  public String toString(){
    return "Je suis un(e) " + this.type;
  }
}

