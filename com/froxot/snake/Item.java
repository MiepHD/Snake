package com.froxot.snake;

import java.awt.Color;
import java.util.ArrayList;

public interface Item {
    public Color getColor();

    public ArrayList<Coordinates> getPositions();
}
