package com.froxot.snake;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyReceiver extends KeyAdapter {
    private Communicator listener;
    private Frame frame;

    KeyReceiver(Communicator listener, Frame frame) {
        this.listener = listener;
        this.frame = frame;
        this.addListener();
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                listener.up();
                break;
            case KeyEvent.VK_DOWN:
                listener.down();
                break;
            case KeyEvent.VK_LEFT:
                listener.left();
                break;
            case KeyEvent.VK_RIGHT:
                listener.right();
            default:
        }
        this.addListener();
    }

    void addListener() {
        this.frame.addKeyListener(this);
    }
}