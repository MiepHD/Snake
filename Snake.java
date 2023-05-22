import java.util.ArrayList;
import snake.Coordinates;
import snake.Item;
import java.awt.Color;

/**
 * A snake that is an Item which can be displayed on the ui
 */
public class Snake implements Item {
    private Direction direction;
    private ArrayList<Coordinates> positions;
    private Color color;

    /**
     * @param coor Position where snake should spawn
     */
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

    /**
     * Extends the snake it the direction of this.direction with 
     */
    public void extend() {
        Coordinates lastelement = this.positions.get(this.positions.size() - 1);
        this.positions.add(new Coordinates(
                lastelement.x + this.direction.x,
                lastelement.y + this.direction.y));
    }
}
