import java.awt.Color;
import java.util.ArrayList;

import snake.Coordinates;
import snake.Item;

public class Food implements Item {
    private Coordinates position;
    private Color color;

    public Food(Coordinates size) {
        this.position = new Coordinates((int) (Math.random() * size.x), (int) (Math.random() * size.y));
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
