import java.util.concurrent.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Main {
    public static void main(String[] args){
        GUI gui = new GUI();
        Snake snake = new Snake();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            public void run() {
                ArrayList<Point> points = new ArrayList<Point>();
                for (Coordinates coor : snake.getPositions()) {
                    points.add(new Point(coor, Color.BLUE));
                }
                gui.repaint();
            }
        };
        executor.scheduleAtFixedRate(runnable, 0, 10, TimeUnit.MILLISECONDS);
    } 
}
