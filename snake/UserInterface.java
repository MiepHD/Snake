package snake;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Main class of the ui
 * When creating an object a new GUI is created
 */
public abstract class UserInterface {
    private GUI gui;
    protected Coordinates resolution;

    /**
     * @param speed    The speed of the snake in milliseconds
     * @param resolution     Defines the resolution for the window Note: x should never be less
     *                 than 23
     */
    public void start(int speed, Dimension size) {
        this.gui = new GUI(this, this.resolution, size);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runner(this);
        executor.scheduleAtFixedRate(runnable, 0, speed, TimeUnit.MILLISECONDS);
    }

    /**
     * Collects all items and converts them to a matrix of colors. This will be
     * written to the gui automatically
     */
    void update() {
        this.tick();
        Color[][] points = new Color[this.resolution.x][this.resolution.y];
        for (Item item : this.getItems()) {
            for (Coordinates coor : item.getPositions()) {
                if (coor.x < this.resolution.x && coor.x >= 0 && coor.y < this.resolution.y && coor.y >= 0) {
                    points[coor.x][coor.y] = item.getColor();
                }
            }
        }
        gui.repaint(points);
        this.gui.setScore(this.getScore());
        this.gui.setHighscore(this.getHighscore());
    }

    public abstract void up();

    public abstract void down();

    public abstract void left();

    public abstract void right();

    /**
     * Called every tick
     */
    public abstract void tick();

    /**
     * @return All Items that should be rendered on the GUI
     */
    public abstract ArrayList<Item> getItems();
    
    /**
     * @return Score displayed on the ui
     */
    public abstract int getScore();
    
    /**
     * @return Highscore displayed on the ui
     */
    public abstract int getHighscore();
}
