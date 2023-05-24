package snake;

public class Coordinates {
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private final int x;
    private final int y;
    
    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    @Override
    public boolean equals(Object o) {
        Coordinates coor = (Coordinates) o;
        return coor.x == this.x && coor.y == this.y;
    }
}
