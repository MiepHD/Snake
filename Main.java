import java.util.ArrayList;
import java.awt.Dimension;

import snake.Coordinates;
import snake.Item;
import snake.UserInterface;

public class Main extends UserInterface {
    private Snake snake;
    private ArrayList<Food> foods;
    private int highscore;

    private Main(int speed, Coordinates resolution, Dimension size) {
        super(speed, resolution, size);
        this.highscore = 0;
        this.resetSnake();

        this.foods = new ArrayList<Food>();
        for (int i = 0; i < 6; i++) {
            this.foods.add(new Food(this.resolution));
        }
        this.runAtFixedSpeed();
    }

    public static void main(String[] args) {
        int speed = 500;
        Coordinates resolution = new Coordinates(30, 30);
        Dimension size = new Dimension(10, 10);
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "--speed":
                    speed = Integer.parseInt(args[i + 1]);
                    break;
                case "--resolution":
                    resolution = new Coordinates(Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
                    break;
                case "--size":
                    size = new Dimension(Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
                    break;
                default:
            }
        }
        new Main(speed, resolution, size);
    }

    private void resetSnake() {
        this.snake = new Snake(new Coordinates[] {
            new Coordinates(resolution.getX() / 2, 0),
            new Coordinates(resolution.getX() / 2, 0),
            new Coordinates(resolution.getX() / 2, 0)
        });
    }

    protected void up() {
        this.snake.setDirection(Direction.UP);
    }

    protected void down() {
        this.snake.setDirection(Direction.DOWN);
    }

    protected void left() {
        this.snake.setDirection(Direction.LEFT);
    }

    protected void right() {
        this.snake.setDirection(Direction.RIGHT);
    }

    protected void tick() {
        this.snake.extend();
        ArrayList<Coordinates> positions = this.snake.getPositions();
        for (Food food : this.foods) {
            if (positions.contains(food.getPositions().get(0))) {
                this.foods.remove(food);
                this.foods.add(new Food(this.resolution));
                return;
            }
        }
        Coordinates last = positions.get(positions.size() - 1);
        if (last.getX() >= this.resolution.getX()
                || last.getY() >= this.resolution.getY()
                || last.getX() < 0
                || last.getY() < 0
                || positions.indexOf(last) != positions.lastIndexOf(last)) {
            this.highscore = Math.max(this.getScore() - 1, this.highscore);
            this.resetSnake();
            return;
        }
        this.snake.removeEnd();
    }

    protected ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(snake);
        for (Food food : this.foods) {
            items.add(food);
        }
        return items;
    }

    protected int getScore() {
        return this.snake.getPositions().size() - 3;
    }

    protected int getHighscore() {
        return this.highscore;
    }
}