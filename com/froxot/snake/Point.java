package com.froxot.snake;

import java.awt.*;

/**
 * Beschreiben Sie hier die Klasse Point.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
class Point {
    public int x;
    public int y;
    public Color color;

    Point(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    Point(Coordinates coor, Color color) {
        this.x = coor.x;
        this.y = coor.y;
        this.color = color;
    }
}