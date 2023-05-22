package snake;

import java.util.ArrayList;

/**
 * API to the User Interface
 */
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
    
    /**
     * @return Score displayed on the ui
     */
    public int getScore();
    
    /**
     * @return Highscore displayed on the ui
     */
    public int getHighscore();
}
