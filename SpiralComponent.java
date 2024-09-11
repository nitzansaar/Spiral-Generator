import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.JComponent;

/**
 * SpiralComponent is a custom JComponent that handles the rendering of a rectangular spiral.
 * It uses a SpiralGenerator to generate the line segments of the spiral based on the
 * initial conditions provided.
 */
public class SpiralComponent extends JComponent {
    private SpiralGenerator generator;
    private int numberOfSegments;
    private int initialSegmentLength;

    /**
     * Constructs a SpiralComponent with specified segment length and number of segments.
     * @param initialSegmentLength The length of the initial segment in pixels.
     * @param numberOfSegments The total number of segments in the spiral.
     */
    public SpiralComponent(int initialSegmentLength, int numberOfSegments) {
        this.numberOfSegments = numberOfSegments;
        this.initialSegmentLength = initialSegmentLength;
    }

    /**
     * Paints the component by drawing the spiral. This method is called by the Swing framework
     * whenever the component needs to be rendered.
     * @param g The Graphics context used for drawing the component.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (generator == null) {
            int startX = getWidth() / 2;
            int startY = getHeight() / 2;
            generator = new SpiralGenerator(new Point(startX, startY), initialSegmentLength);
        }

        for (int i = 0; i < numberOfSegments; i++) {
            Line2D segment = generator.nextSegment();
            g2.draw(segment);
        }
    }
}