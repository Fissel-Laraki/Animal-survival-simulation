import java.awt.Point;
import java.awt.Color;

public class Coord extends Point{
  Color color;

  public Coord(Color color, int pos_x, int pos_y){
    super(pos_x, pos_y);
    this.color = color;
  }  
}