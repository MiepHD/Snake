import java.util.ArrayList;

import com.froxot.snake.Coordinates;
import com.froxot.snake.Item;
import com.froxot.snake.UserInterface;
import com.froxot.snake.Communicator;

public class Main implements Communicator {
    private Snake snake;
    private ArrayList<Food> foods;
    private final Coordinates size;
    private int highscore;

    public Main(Coordinates size) {
        this.highscore = 0;
        this.size = size;
        this.snake = new Snake(new Coordinates(size.x / 2, 0));
        this.foods = new ArrayList<Food>();
        for (int i = 0; i < 6; i++) {
            this.foods.add(new Food(this.size));
        }
    }

    public static void main(String[] args) {
        Coordinates size = new Coordinates(30, 30);
        new UserInterface(new Main(size), 500, size);
    }

    public void up() {
        this.snake.setDirection(Direction.UP);
    }

    public void down() {
        this.snake.setDirection(Direction.DOWN);
    }

    public void left() {
        this.snake.setDirection(Direction.LEFT);
    }

    public void right() {
        this.snake.setDirection(Direction.RIGHT);
    }

    public void update() {
        this.snake.extend();
        for (Food food : this.foods) {
            ArrayList<Coordinates> positions = this.snake.getPositions();
            if (positions.contains(food.getPositions().get(0))) {
                this.foods.remove(food);
                this.foods.add(new Food(this.size));
                return;
            } else {
                Coordinates last = positions.get(positions.size() - 1);
                if (last.x >= this.size.x
                        || last.y >= this.size.y
                        || last.x < 0
                        || last.y < 0
                        || positions.indexOf(last) != positions.lastIndexOf(last)) {
                    this.highscore = Math.max(this.getScore() - 1, this.highscore);
                    this.snake = new Snake(new Coordinates(size.x / 2, 0));
                    return;
                }
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

    public int getScore() {
        return this.snake.getPositions().size() - 3;
    }

    public int getHighscore() {
        return this.highscore;
    }
}