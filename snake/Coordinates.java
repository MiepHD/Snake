package snake;

/**
 * Beschreiben Sie hier die Klasse Coordinate.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Coordinates {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public int x;
    public int y;

    /**
     * Konstruktor für Objekte der Klasse Coordinate
     */
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        Coordinates coor = (Coordinates) o;
        return coor.x == this.x && coor.y == this.y;
    }
}
