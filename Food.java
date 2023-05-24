import java.awt.Color;
import java.util.ArrayList;

import snake.Coordinates;
import snake.Item;

public class Food implements Item {
    private Coordinates position;
    private Color color;

    public Food(Coordinates resolution) {
        this.position = new Coordinates((int) (Math.random() * resolution.getX()), (int) (Math.random() * resolution.getY()));
        this.color = Color.BLACK;
    }

    public ArrayList<Coordinates> getPositions() {
        ArrayList<Coordinates> coor = new ArrayList<Coordinates>();
        coor.add(this.position);
        return coor;
    }

    public Color getColor() {
        return this.color;
    }
}
