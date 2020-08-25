package TimeDisplay;

import javax.swing.JFrame;

public class StopWatchTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");

        Stopwatch stopwatch = new Stopwatch("start/stop", true);
        stopwatch.Start();
        frame.add(stopwatch);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}