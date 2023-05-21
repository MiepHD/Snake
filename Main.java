import java.util.concurrent.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Beschreiben Sie hier die Klasse Main.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {

            }
        });
        Snake snake = new Snake();
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("Tick");
                ArrayList<Point> points = new ArrayList<Point>();
                for (Coordinates coor : snake.getPositions()) {
                    points.add(new Point(coor, Color.BLUE));
                }
                gui.repaint(points);
            }
        };
        executor.scheduleAtFixedRate(runnable, 0, 1000, TimeUnit.MILLISECONDS);
    }
}
