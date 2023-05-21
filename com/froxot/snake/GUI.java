package com.froxot.snake;

import java.awt.*;

/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
class GUI extends Frame {
    private Frame frame;
    private Label[][] points;
    private Communicator listener;

    GUI(Communicator listener, Coordinates size) {
        this.points = new Label[size.x][size.y];
        this.listener = listener;
        this.frame = new Frame();
        new KeyReceiver(this.listener, this.frame);
        for (int y = 0; y < this.points[0].length; y++) {
            for (int x = 0; x < this.points.length; x++) {
                this.points[x][y] = new Label();
                this.points[x][y].setBackground(Color.lightGray);
                this.points[x][y].setPreferredSize(new Dimension(10, 10));
                this.frame.add(this.points[x][y]);
            }
        }
        this.frame.addWindowListener(new Closer());
        this.frame.setLayout(new GridLayout(size.y, size.x));
        this.frame.pack();
        this.frame.setVisible(true);
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
