package snake;

import java.awt.Color;
import java.util.ArrayList;

/**
 * Structure for an Element that can be rendered on the GUI
 */
public interface Item {
    /**
     * @return The color that should be used to represent this element
     */
    public Color getColor();

    /**
     * @return The Coordinates where the pieces of the Element are
     */
    public ArrayList<Coordinates> getPositions();
}
