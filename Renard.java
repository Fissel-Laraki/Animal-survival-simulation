import java.util.Hashtable;

public class Renard extends Animal {
  public Renard (int age, int pos_x, int pos_y)
  {
    this.pos_x = pos_x;
    this.pos_y = pos_y;
    this.age=age;
    this.type="Renard";
    this.couleur="Orange";
    this.p_detection_proie=0.2;
    this.p_reproduction=0.14;
    this.bonus=12;
    this.ATK=20;
    this.DEF=7;
    this.vitesse=3;
    this.endurance_alimentaire=8;
    this.esperance_vie=250;
    this.etat_mort=false;
    this.proies = new Hashtable();
  }
}