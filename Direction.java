import com.froxot.snake.Coordinates;

public enum Direction {
    UP(new Coordinates(0, -1)),
    DOWN(new Coordinates(0, 1)),
    LEFT(new Coordinates(-1, 0)),
    RIGHT(new Coordinates(1, 0));

    public final int x;
    public final int y;

    private Direction(Coordinates coor) {
        this.x = coor.x;
        this.y = coor.y;
    }
}
