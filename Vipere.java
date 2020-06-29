import java.util.Hashtable;

public class Vipere extends Animal {
  public Vipere (int age, int pos_x, int pos_y)
  {
    this.pos_x = pos_x;
    this.pos_y = pos_y;
    this.age=age;
    this.type="Vipère";
    this.couleur="Vert";
    this.p_detection_proie=0.5;
    this.p_reproduction=0.5;
    this.bonus=8;
    this.ATK=5;
    this.DEF=17;
    this.vitesse=1;
    this.endurance_alimentaire=35;
    this.esperance_vie=120;
    this.etat_mort=false;
    this.proies = new Hashtable();
  }
}