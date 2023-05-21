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
    private Label[] numbers;

    /**
     * 
     * @param listener
     * @param size     Width must be at least 23
     */
    GUI(Communicator listener, Coordinates size) {
        this.points = new Label[size.x][size.y];
        this.listener = listener;
        this.addKeyListener(new KeyReceiver(this.listener));
        String[] vals = new String[] { "S", "c", "o", "r", "e", ":", " ", "0", "0", "0", " ", "H", "i", "g", "h", "e",
                "s", "t", ":", " ", "0", "0", "0" };
        this.numbers = new Label[6];
        int i = 5;
        for (String val : vals) {
            Label label = new Label(val);
            if (val.equals("0")) {
                numbers[i] = label;
                i--;
            }
            label.setBackground(Color.lightGray);
            label.setPreferredSize(new Dimension(10, 10));
            this.add(label);
        }
        for (i = 23; i < size.x; i++) {
            Label label = new Label();
            label.setBackground(Color.lightGray);
            label.setPreferredSize(new Dimension(10, 10));
            this.add(label);
        }
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

    void setScore(int score) {
        if (score < 1000 && score >= 0) {
            char[] chars = this.splitInt(score);
            for (int i = 0; i < 3; i++) {
                this.numbers[i + 3].setText(Character.toString(chars[i]));
            }
        }
    }

    void setHighscore(int score) {
        if (score < 1000 && score >= 0) {
            char[] chars = this.splitInt(score);
            for (int i = 0; i < 3; i++) {
                this.numbers[i].setText(Character.toString(chars[i]));
            }
        }
    }

    private char[] splitInt(int i) {
        char[] chars = new char[3];
        chars[0] = (char) ((i % 10) + '0');
        i /= 10;
        chars[1] = (char) ((i % 10) + '0');
        i /= 10;
        chars[2] = (char) ((i % 10) + '0');
        return chars;
    }
}
