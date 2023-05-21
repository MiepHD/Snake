package com.froxot.snake;

import java.util.concurrent.*;
import java.awt.Color;

/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class UserInterface {
    private GUI gui;
    private Communicator listener;
    private Coordinates size;

    public UserInterface(Communicator listener, int speed, Coordinates size) {
        this.size = size;
        this.listener = listener;
        this.gui = new GUI(listener, size);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runner(this);
        executor.scheduleAtFixedRate(runnable, 0, speed, TimeUnit.MILLISECONDS);
    }

    void update() {
        this.listener.update();
        Color[][] points = new Color[this.size.x][this.size.y];
        for (Item item : this.listener.getItems()) {
            for (Coordinates coor : item.getPositions()) {
                if (coor.x < this.size.x && coor.x >= 0 && coor.y < this.size.y && coor.y >= 0) {
                    points[coor.x][coor.y] = item.getColor();
                }
            }
        }
        gui.repaint(points);
        this.gui.setScore(this.listener.getScore());
        this.gui.setHighscore(this.listener.getHighscore());
    }
}
