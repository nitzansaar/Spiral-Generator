import java.awt.Point;
import java.awt.geom.Line2D;

/**
 * The SpiralGenerator class generates the segments of a rectangular spiral.
 * It calculates each line segment of the spiral based on the initial segment length and starting position,
 * moving in a counter-clockwise direction.
 */
public class SpiralGenerator {
    private Point currentPosition;
    private int unitLength;
    private int currentLength;
    private int direction;
    private int segmentCount;

    /**
     * Initializes a new SpiralGenerator with a starting position and unit length.
     * @param startPosition The starting point of the spiral.
     * @param unitLength The length of the first segment and the padding between layers.
     */
    public SpiralGenerator(Point startPosition, int unitLength) {
        this.currentPosition = startPosition;
        this.unitLength = unitLength;
        this.currentLength = unitLength;
        this.direction = 0;  // Start moving to the right
        this.segmentCount = 0;
    }

    /**
     * Returns the next segment of the spiral as a Line2D object.
     * @return The next segment in the spiral.
     */
    public Line2D nextSegment() {
        int x1 = currentPosition.x;
        int y1 = currentPosition.y;
        int x2 = x1;
        int y2 = y1;

        switch (direction % 4) {
            case 0:  // Right
                x2 += currentLength;
                break;
            case 1:  // Up
                y2 -= currentLength;
                break;
            case 2:  // Left
                x2 -= currentLength;
                break;
            case 3:  // Down
                y2 += currentLength;
                break;
        }

        currentPosition.setLocation(x2, y2);
        direction = (direction + 1) % 4;
        if (segmentCount % 2 == 0) {
            currentLength += unitLength;
        }
        segmentCount++;

        return new Line2D.Double(x1, y1, x2, y2);
    }
}