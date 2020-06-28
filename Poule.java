
import java.util.Hashtable;
public class Poule extends Animal {
  public Poule (int age)
  {
    this.age=age;
    this.type="Poule";
    this.couleur="Jaune";
    this.p_detection_proie=0.1;
    this.p_reproduction=0.4;
    this.bonus=6;
    this.ATK=15;
    this.DEF=23;
    this.vitesse=2;
    this.endurance_alimentaire=20;
    this.esperance_vie=150;
    this.proies = new Hashtable();
  }
}