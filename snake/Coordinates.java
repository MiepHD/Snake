package snake;

public class Coordinates {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    public int x;
    public int y;
    
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
