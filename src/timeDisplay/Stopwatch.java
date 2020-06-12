package timeDisplay;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stopwatch extends JPanel{



	private static final long serialVersionUID = 1931099373284641987L;
	private String RunningButton, StoppedButton;
	private StopwatchDisplay t;

	public Stopwatch(String a, String b) {
		RunningButton = b;
		StoppedButton = a;
	}

	public void Start() {
		t = new StopwatchDisplay(StoppedButton, RunningButton);

		t.setFont( new Font("SansSerif", Font.BOLD, 24) );
		t.setBackground(Color.white);
		t.setForeground( new Color(180,0,0) );
		t.setOpaque(true);
		add(t, BorderLayout.CENTER);
			JButton onOffSwitch = new JButton(RunningButton);
			onOffSwitch.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					t.start();
					onOffSwitch.setText(t.getButtonText());
					if(t.getButtonText().length() == 0) remove(onOffSwitch);
				}
			});
			if(t.getButtonText().length() != 0) add(onOffSwitch, BorderLayout.SOUTH);
		
		
	}

	public void Stop() {
		t.start();
	}
	public long MillisRunning() {
		return t.runTime();
	}

}
