package com.froxot.snake;

import java.util.ArrayList;

public interface Communicator {
    public void up();

    public void down();

    public void left();

    public void right();

    /**
     * Called every tick
     */
    public void update();

    /**
     * @return All Items that should be rendered on the GUI
     */
    public ArrayList<Item> getItems();

    public int getScore();

    public int getHighscore();
}
