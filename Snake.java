import java.util.ArrayList;
import com.froxot.snake.Coordinates;
import com.froxot.snake.Item;
import java.awt.Color;

/**
 * Beschreiben Sie hier die Klasse Snake.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Snake implements Item {
    private Direction direction;
    private ArrayList<Coordinates> positions;
    private Color color;

    public Snake(Coordinates coor) {
        this.direction = Direction.DOWN;
        this.positions = new ArrayList<Coordinates>();
        this.positions.add(coor);
        coor.y++;
        this.positions.add(coor);
        coor.y++;
        this.positions.add(coor);
        this.color = Color.BLUE;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public ArrayList<Coordinates> getPositions() {
        return this.positions;
    }

    public Color getColor() {
        return color;
    }

    public void removeEnd() {
        this.positions.remove(0);
    }

    public void extend() {
        Coordinates lastelement = this.positions.get(this.positions.size() - 1);
        this.positions.add(new Coordinates(
                lastelement.x + this.direction.x,
                lastelement.y + this.direction.y));
    }
}
