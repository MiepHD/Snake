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
    private int speed;
    private boolean speededitable;
    protected final Coordinates resolution;
    private final GUI gui;
    private final ScheduledExecutorService executor;

    /**
     * @param speed    The speed of the snake in milliseconds
     * @param resolution     Defines the resolution for the window Note: x should never be less
     *                 than 23
     */
    protected UserInterface(int speed, Coordinates resolution, Dimension size) {
        this.speededitable = true;
        this.speed = speed;
        this.resolution = resolution;
        this.gui = new GUI(this, this.resolution, size);
        this.executor = Executors.newScheduledThreadPool(2);
    }

    /**
     * The speed is not editable but has better performance
     */
    protected void runAtFixedSpeed() {
        if (!this.speededitable) return;
        this.speededitable = false;
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runner(this);
        executor.scheduleAtFixedRate(runnable, 0, this.speed, TimeUnit.MILLISECONDS);
    }

    /**
     * Speed can be changed through increaseSpeed(int) and decreaseSpeed(int)
     */
    protected void runAtEditableSpeed() {
        if (!this.speededitable) return;
        Runnable runnable = new Runner(this);
        this.executor.schedule(runnable, this.speed, TimeUnit.MILLISECONDS);
    }

    

    /**
     * Collects all items and converts them to a matrix of colors. This will be
     * written to the gui automatically
     */
    void update() {
        if (speededitable) runAtEditableSpeed();
        this.tick();
        Color[][] points = new Color[this.resolution.getX()][this.resolution.getY()];
        for (Item item : this.getItems()) {
            for (Coordinates coor : item.getPositions()) {
                if (coor.getX() < this.resolution.getX() && coor.getX() >= 0 && coor.getY() < this.resolution.getY() && coor.getY() >= 0) {
                    points[coor.getX()][coor.getY()] = item.getColor();
                }
            }
        }
        gui.repaint(points);
        this.gui.setScore(this.getScore());
        this.gui.setHighscore(this.getHighscore());
    }

    protected abstract void up();

    protected abstract void down();

    protected abstract void left();

    protected abstract void right();

    /**
     * Called every tick
     */
    protected abstract void tick();

    /**
     * @return All Items that should be rendered on the GUI
     */
    protected abstract ArrayList<Item> getItems();
    
    /**
     * @return Score displayed on the ui
     */
    protected abstract int getScore();
    
    /**
     * @return Highscore displayed on the ui
     */
    protected abstract int getHighscore();
}
