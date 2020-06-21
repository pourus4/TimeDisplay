package timeDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class CountDownDisplay extends JLabel implements ActionListener {
	private static final long serialVersionUID = 1L;

	private long startTime, runTime;

	private String MilliSeconds, Seconds, Minutes, Hours, timeRemaining, endString;
	private boolean running;

	private Timer timer;

	public CountDownDisplay(int s, String str) {
		super("  time  ", JLabel.CENTER);
		runTime = s * 1000;
		endString = str;
		start();
	}

	public void actionPerformed(ActionEvent e) {
		long currentTime = System.currentTimeMillis() - startTime;
		long time = (runTime - currentTime);
		if (time <= 0) {
			running = false;
			setText(endString);
			timer.stop();
		} else {
			timeRemaining = "";
			Hours(time);
			Minutes(time);
			Seconds(time);
			MilliSeconds(time);
			if (Hours.equals("00") && Minutes.equals("00") && Seconds.equals("00") && MilliSeconds.equals("000")) {
				timeRemaining = "Error";
			} else {
				if (!Hours.equals("00")) {
					timeRemaining += Hours + ":" + Minutes + ":" + Seconds + "." + MilliSeconds;
				} else if (!Minutes.equals("00"))
					timeRemaining += Minutes + ":" + Seconds + "." + MilliSeconds;

				else
					timeRemaining += Seconds + "." + MilliSeconds;
			}
			setText(timeRemaining);
		}
	}

	private void start() {
		if (timer == null) {
			timer = new Timer(3, this);
			startTime = System.currentTimeMillis();
			timer.start();
			running = true;
		} else {
			startTime = System.currentTimeMillis();
			timer.restart();
			running = true;
		}
	}

	private void Hours(long t) {

		if (t < 86400000) {
			t /= 3600000;
			if (t < 10)
				Hours = "0" + String.valueOf(t);
			else
				Hours = String.valueOf(t);
		} else {
			timer.stop();
			JOptionPane.showMessageDialog(null, "This isn't coded for days, work faster.", "Timeout",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void Minutes(long t) {

		if (t < 3600000) {
			t /= 60000;
			if (t < 10)
				Minutes = "0" + String.valueOf(t);
			else
				Minutes = String.valueOf(t);
		} else {
			Minutes(t % 3600000);
		}
	}

	private void Seconds(long t) {

		if (t < 60000) {
			t /= 1000;
			if (t < 10)
				Seconds = "0" + String.valueOf(t);
			else
				Seconds = String.valueOf(t);
		} else if (t >= 60000) {
			Seconds(t % 60000);
		}

	}

	private void MilliSeconds(long t) {
		if (t < 1000) {
			if (t < 100 && t >= 10)
				MilliSeconds = "0" + String.valueOf(t);
			else if (t < 10)
				MilliSeconds = "00" + String.valueOf(t);
			else
				MilliSeconds = String.valueOf(t);
		} else {
			MilliSeconds(t % 1000);
		}

	}

	public boolean isRunning() {
		return running;
	}

}
