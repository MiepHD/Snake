import java.awt.*;
import javax.swing.*;
/**
 * Beschreiben Sie hier die Klasse GUI.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class GUI extends Frame {
    private Frame frame;
    private Label[][] points = new Label[16][16];
    public GUI()
    {
        this.frame = new Frame();
        for (int y = 0; y < this.points.length; y++) {
            for (int x = 0; x < this.points[0].length; x++) {
                this.points[x][y] = new Label();
                this.points[x][y].setBackground(Color.lightGray);
                this.points[x][y].setPreferredSize(new Dimension(10, 10));
                this.frame.add(this.points[x][y]);
            }
        }
        this.frame.setLayout(new GridLayout(16, 16));
        this.frame.pack();
    }

    public void repaint(ArrayList<Point> points) {
        for (Point point : points) {
            if (!(this.points[point.x][point.y] == point.color)) {

            }
        }
    }
}
