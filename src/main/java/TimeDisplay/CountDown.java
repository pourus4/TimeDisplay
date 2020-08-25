package TimeDisplay;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		c.setForeground( new Color(0,0,0) );
		c.setOpaque(true);
		add(c, BorderLayout.CENTER);
		JButton pauseButton = new JButton("Pause/Resume");
		pauseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				c.pause();
			}
		});
		add(pauseButton, BorderLayout.SOUTH);
	}
	
	public boolean isRunning() {
		return c.isRunning();
	}

}
