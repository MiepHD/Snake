import com.froxot.snake.Coordinates;

public enum Direction {
    UP(new Coordinates(0, -1)),
    DOWN(new Coordinates(0, 1)),
    LEFT(new Coordinates(-1, 0)),
    RIGHT(new Coordinates(1, 0));

    private final Coordinates coor;

    private Direction(Coordinates coor) {
        this.coor = coor;
    }

    public Coordinates getCoordinates() {
        return this.coor;
    }

}
