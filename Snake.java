import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Snake.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Snake {
    private ArrayList<Coordinates> positions;
    private GUI gui;
    public Snake() {
        this.positions.add(new Coordinates(7, 0));
    }
    
    public ArrayList<Coordinates> getPositions() {
        return this.positions;
    }
}
