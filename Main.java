import java.util.ArrayList;
import java.awt.Dimension;

import snake.Coordinates;
import snake.Item;
import snake.UserInterface;

public class Main extends UserInterface {
    private Snake snake;
    private ArrayList<Food> foods;
    private int highscore;

    public Main(int speed, Coordinates resolution, Dimension size) {
        this.resolution = resolution;
        this.highscore = 0;
        this.snake = new Snake(new Coordinates(resolution.x / 2, 0));
        this.foods = new ArrayList<Food>();
        for (int i = 0; i < 6; i++) {
            this.foods.add(new Food(this.resolution));
        }
        this.start(speed, size);
    }

    public static void main(String[] args) {
        Coordinates resolution = new Coordinates(30, 30);
        new Main(500, resolution, new Dimension(10, 10));
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

    public void tick() {
        this.snake.extend();
        for (Food food : this.foods) {
            ArrayList<Coordinates> positions = this.snake.getPositions();
            if (positions.contains(food.getPositions().get(0))) {
                this.foods.remove(food);
                this.foods.add(new Food(this.resolution));
                return;
            } else {
                Coordinates last = positions.get(positions.size() - 1);
                if (last.x >= this.resolution.x
                        || last.y >= this.resolution.y
                        || last.x < 0
                        || last.y < 0
                        || positions.indexOf(last) != positions.lastIndexOf(last)) {
                    this.highscore = Math.max(this.getScore() - 1, this.highscore);
                    this.snake = new Snake(new Coordinates(resolution.x / 2, 0));
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