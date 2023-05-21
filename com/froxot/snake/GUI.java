package com.froxot.snake;

import java.awt.*;

/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
class GUI extends Frame {
    private Label[][] points;
    private Communicator listener;

    GUI(Communicator listener, Coordinates size) {
        this.points = new Label[size.x][size.y];
        this.listener = listener;
        this.addKeyListener(new KeyReceiver(this.listener));
        for (int y = 0; y < this.points[0].length; y++) {
            for (int x = 0; x < this.points.length; x++) {
                this.points[x][y] = new Label();
                this.points[x][y].setBackground(Color.lightGray);
                this.points[x][y].setPreferredSize(new Dimension(10, 10));
                this.add(this.points[x][y]);
            }
        }
        this.addWindowListener(new Closer());
        this.setLayout(new GridLayout(size.y + 1, size.x));
        this.pack();
        this.setVisible(true);
        System.out.println("");
    }

    void repaint(Color[][] points) {
        for (int y = 0; y < this.points[0].length; y++) {
            for (int x = 0; x < this.points.length; x++) {
                if (!this.points[x][y].getBackground().equals(points[x][y])) {
                    this.points[x][y].setBackground(points[x][y]);
                }
            }
        }
    }
}
