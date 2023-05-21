import java.util.ArrayList;

import com.froxot.snake.Coordinates;
import com.froxot.snake.Item;
import com.froxot.snake.UserInterface;
import com.froxot.snake.Communicator;

public class Main implements Communicator {
    private Direction direction;
    private Snake snake;
    private ArrayList<Food> foods;
    private final Coordinates size;

    public Main(Coordinates size) {
        this.size = size;
        this.direction = Direction.DOWN;
        this.snake = new Snake(new Coordinates(size.x / 2, 0));
        this.foods = new ArrayList<Food>();
        for (int i = 0; i < 6; i++) {
            this.foods.add(new Food(this.size));
        }
    }

    public static void main(String[] args) {
        Coordinates size = new Coordinates(90, 60);
        new UserInterface(new Main(size), 500, size);
    }

    public void up() {
        this.direction = Direction.UP;
    }

    public void down() {
        this.direction = Direction.DOWN;
    }

    public void left() {
        this.direction = Direction.LEFT;
    }

    public void right() {
        this.direction = Direction.RIGHT;
    }

    public void update() {
        Coordinates coor = direction.getCoordinates();
        this.snake.extend(coor);
        for (Food food : this.foods) {
            if (this.snake.getPositions().contains(food.getPositions().get(0))) {
                this.foods.remove(food);
                this.foods.add(new Food(this.size));
                return;
            }
        }
        this.snake.removeEnd();
    }

    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(snake);
        for (Food food : this.foods) {
            items.add(food);
        }
        return items;
    }
}