package shipyardsimulation;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;



public class Windowx extends JFrame {


	World display;
	JButton newShip;
	JButton start;
	JButton stop;
	
	public Window() {

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		display = new World();
		container.add("Center", display);
		newShip = new JButton("Add new ship");
		start = new JButton("Start simulation");
		stop = new JButton("Stop");


		ActionListener task = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double random = Math.random();
				if (random < 0.5) {
					display.addShip(0);
				} else {
					display.addShip(1);
				}
			}
		};
		Timer timer = new Timer(1500, task);
		
		start.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        timer.start();
		    }
		});
		stop.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        timer.stop();
		    }
		});
		
		
		newShip.addActionListener(task);
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.add(start);
		panel.add(stop);
		panel.add(newShip);
		
		container.add("South", panel);
		
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
