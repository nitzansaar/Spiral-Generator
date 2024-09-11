import java.awt.*;
import java.awt.geom.Line2D;
import javax.swing.*;

/**
 * Class for testing SpiralGenerator independently.
 * This class has its own main method to execute tests on the SpiralGenerator class,
 * ensuring that it correctly generates segments of a rectangular spiral.
 */
public class SpiralGeneratorTester extends JComponent {
    private SpiralGenerator generator;
    private int numberOfSegments;
    
    /**
     * Constructs a SpiralGeneratorTester with the specified number of segments to draw.
     * @param initialSegmentLength the length of the first segment.
     * @param numberOfSegments the number of segments to draw in the spiral.
     */
    public SpiralGeneratorTester(int initialSegmentLength, int numberOfSegments) {
        this.numberOfSegments = numberOfSegments;
        // Initialize SpiralGenerator with a starting point at (300, 300) and unit length
        Point startPosition = new Point(300, 300);
        generator = new SpiralGenerator(startPosition, initialSegmentLength);
    }

    /**
     * Paints the component and draws the rectangular spiral using SpiralGenerator.
     * @param g the graphics context.
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw each segment using the SpiralGenerator
        for (int i = 0; i < numberOfSegments; i++) {
            Line2D segment = generator.nextSegment();
            g2.draw(segment);
        }
    }

    /**
     * Main method to run the SpiralGenerator tests.
     * This will display a window with the generated spiral.
     * @param args command line arguments (not used).
     */
    public static void main(String[] args) {
        // Set up JFrame to display the test
        JFrame frame = new JFrame("SpiralGenerator Tester");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of SpiralGeneratorTester and add it to the frame
        SpiralGeneratorTester tester = new SpiralGeneratorTester(20, 50); // Adjust segment length and number of segments
        frame.add(tester);

        // Make the frame visible
        frame.setVisible(true);
    }
}