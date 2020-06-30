import java.awt.Point;
import java.awt.Color;

public class Coord extends Point{
  Color color;

  public Coord(Color color, int pos_x, int pos_y){
    super(pos_x, pos_y);
    this.color = color;
  }  

  public boolean equals(Object o){
	if ( o == this){
		return true;
	}
	if (!( o instanceof Coord)){
		return false;
	}	

	Coord c = (Coord) o;
	return this.x==c.x && this.y==c.y && this.color == c.color;

  }
}
