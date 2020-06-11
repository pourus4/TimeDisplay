package timeDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JPanel;

public class CountDown extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CountDownDisplay c;
	private int time;
	private String timeOut;
	
	public CountDown(int t, String str) {
		time = t;
		timeOut = str;
	}
	
	public void Start() {
		c = new CountDownDisplay(time, timeOut);
		
		c.setFont( new Font("SansSerif", Font.BOLD, 24) );
		c.setBackground(Color.white);
		c.setForeground( new Color(180,0,0) );
		c.setOpaque(true);
		add(c, BorderLayout.CENTER);
	}
	
	public boolean isRunning() {
		return c.isRunning();
	}

}
