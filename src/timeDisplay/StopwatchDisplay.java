package timeDisplay;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class StopwatchDisplay extends JLabel implements MouseListener, ActionListener {

	private static final long serialVersionUID = 8264351721076098056L;
	private long startTime, endTime;
	private String MilliSeconds, Seconds, Minutes, Hours, endString, onOffSwitchText, RunningButton, StoppedButton;
	private boolean running;
	private Timer timer;

	public StopwatchDisplay(String a, String b) {
		super("  00:00:00.000  ", JLabel.CENTER);
		RunningButton = b;
		StoppedButton = a;
		start();
	}

	public void actionPerformed(ActionEvent evt) {
		long time = (System.currentTimeMillis() - startTime);
		Hours(time);
		Minutes(time);
		Seconds(time);
		MilliSeconds(time);
		setText(Hours + ":" + Minutes + ":" + Seconds + "." + MilliSeconds);
	}

	public void mousePressed(MouseEvent evt) {
		if (running == false) {
			running = true;
			startTime = evt.getWhen();
			setText("00:00:00.000");
			if (timer == null) {
				timer = new Timer(3, this);
				timer.start();
			} else
				timer.restart();
		} else {
			timer.stop();
			running = false;
			endTime = evt.getWhen();
			long m = (endTime - startTime);
			endTime(m);
			setText("Time: " + endString);
		}
	}

	public void start() {
		if (running == false) {
			running = true;
			onOffSwitchText = RunningButton;
			startTime = System.currentTimeMillis();
			setText("00:00:00.000");
			if (timer == null) {
				timer = new Timer(3, this);
				timer.start();
			} else
				timer.restart();
		} else {
			timer.stop();
			running = false;
			onOffSwitchText = StoppedButton;
			long endTime = System.currentTimeMillis();
			long m = (endTime - startTime);
			endTime(m);
			setText("Time: " + endString);
		}
	}

	private void endTime(long t) {
		Hours(t);
		Minutes(t);
		Seconds(t);
		MilliSeconds(t);
		endString = "";
		if (Hours.equals("00") && Minutes.equals("00") && Seconds.equals("00") && MilliSeconds.equals("000")) {
			endString = "StopWatch was stopped instantly.";
		} else {
			if (!Hours.equals("00")) {
				endString += Hours + ":" + Minutes + ":" + Seconds + "." + MilliSeconds;
			}
			else{
				endString += Minutes + ":" + Seconds + "." + MilliSeconds;
			}
		}
	}

	public String getButtonText() {
		return onOffSwitchText;
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

	public String runTime() {
		return endString;
	}

	public void mouseReleased(MouseEvent evt) {
	}

	public void mouseClicked(MouseEvent evt) {
	}

	public void mouseEntered(MouseEvent evt) {
	}

	public void mouseExited(MouseEvent evt) {
	}

}