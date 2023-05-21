import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Snake.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Snake {
    private ArrayList<Coordinates> positions;

    public Snake() {
        (this.positions = new ArrayList<Coordinates>()).add(new Coordinates(7, 0));
    }

    public ArrayList<Coordinates> getPositions() {
        return this.positions;
    }
}
