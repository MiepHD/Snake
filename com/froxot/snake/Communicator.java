package com.froxot.snake;

import java.util.ArrayList;

public interface Communicator {
    public void up();

    public void down();

    public void left();

    public void right();

    public void update();

    public ArrayList<Item> getItems();
}
