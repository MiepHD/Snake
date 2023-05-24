package snake;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Tracks key's input and sends then to the listener
 */
class KeyReceiver extends KeyAdapter {
    private UserInterface ui;

    /**
     * @param listener The listener where the actions should be send
     */
    KeyReceiver(UserInterface ui) {
        this.ui = ui;
    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.ui.up();
                break;
            case KeyEvent.VK_DOWN:
                this.ui.down();
                break;
            case KeyEvent.VK_LEFT:
                this.ui.left();
                break;
            case KeyEvent.VK_RIGHT:
                this.ui.right();
            default:
        }
    }
}