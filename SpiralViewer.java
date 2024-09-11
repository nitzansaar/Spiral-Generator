import java.util.Scanner;
import javax.swing.JFrame;

/**
 * The SpiralViewer class serves as the entry point for the application.
 * It prompts the user for input parameters to define the spiral,
 * creates a JFrame to hold the SpiralComponent, and initializes the
 * spiral drawing.
 */
public class SpiralViewer {
    /**
     * The main method that sets up and displays the spiral drawing frame.
     * It prompts the user for the initial segment length and the total number
     * of segments to draw, and then it sets up the JFrame containing the SpiralComponent.
     * @param args Command line arguments, not used in this application.
     */
    public static void main(String[] args) {
        int seg_length;
        int num_of_segs;
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Enter initial segment length: ");
            seg_length = input.nextInt();
            System.out.println("Enter number of segments: ");
            num_of_segs = input.nextInt();
        }

        JFrame frame = new JFrame();
        frame.setTitle("Rectangular Spiral Viewer");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        SpiralComponent spiral = new SpiralComponent(seg_length, num_of_segs);
        frame.add(spiral);
        frame.setVisible(true);
    }
}