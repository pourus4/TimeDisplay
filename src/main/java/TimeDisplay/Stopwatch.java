package TimeDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JPanel {

	private static final long serialVersionUID = 1931099373284641987L;
	private String ButtonLable;
	private StopwatchDisplay t;

	public Stopwatch(String a) {
		ButtonLable = a;
	}

	public void Start() {
		t = new StopwatchDisplay();

		t.setFont(new Font("SansSerif", Font.BOLD, 24));
		t.setBackground(Color.white);
		t.setForeground(new Color(0, 0, 0));
		t.setOpaque(true);
		add(t, BorderLayout.CENTER);
		JButton onOffSwitch = new JButton(ButtonLable);
		onOffSwitch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.start();
			}
		});
		if (ButtonLable.length() != 0){
			add(onOffSwitch, BorderLayout.SOUTH);
		}
		JButton pauseButton = new JButton("Pause/Resume");
		pauseButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				t.pause();
			}
		});
		add(pauseButton, BorderLayout.SOUTH);

	}

	public void Stop() {
		t.start();
	}

	public String runTime() {
		return t.runTime();
	}

}
