package snake;

import java.util.concurrent.*;
import java.awt.Color;
import java.awt.Dimension;

/**
 * Main class of the ui
 * When creating an object a new GUI is created
 */
public class UserInterface {
    private GUI gui;
    private Communicator listener;
    private Coordinates resolution;

    /**
     * @param listener Your main method where you collect the input
     * @param speed    The speed of the snake in milliseconds
     * @param resolution     Defines the resolution for the window Note: x should never be less
     *                 than 23
     */
    public UserInterface(Communicator listener, int speed, Coordinates resolution, Dimension size) {
        this.resolution = resolution;
        this.listener = listener;
        this.gui = new GUI(listener, resolution, size);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runner(this);
        executor.scheduleAtFixedRate(runnable, 0, speed, TimeUnit.MILLISECONDS);
    }

    /**
     * Collects all items and converts them to a matrix of colors. This will be
     * written to the gui automatically
     */
    void update() {
        this.listener.update();
        Color[][] points = new Color[this.resolution.x][this.resolution.y];
        for (Item item : this.listener.getItems()) {
            for (Coordinates coor : item.getPositions()) {
                if (coor.x < this.resolution.x && coor.x >= 0 && coor.y < this.resolution.y && coor.y >= 0) {
                    points[coor.x][coor.y] = item.getColor();
                }
            }
        }
        gui.repaint(points);
        this.gui.setScore(this.listener.getScore());
        this.gui.setHighscore(this.listener.getHighscore());
    }
}
