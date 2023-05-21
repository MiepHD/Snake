package com.froxot.snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class KeyReceiver extends KeyAdapter {
    private Communicator listener;

    KeyReceiver(Communicator listener) {
        this.listener = listener;
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
    }
}