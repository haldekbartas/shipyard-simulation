package shipyardsimulation;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

class World extends JPanel {
	

	Image shipyard;
	Image redShip;
	Image purpleShip;

	ArrayList<Ship> ships = new ArrayList<Ship>();

	public World() {
		try {
			redShip = ImageIO.read(ResourceLoader.load("redship.gif"));
			purpleShip = ImageIO.read(ResourceLoader.load("purpleship.gif"));
			shipyard =  ImageIO.read(ResourceLoader.load("shipyard.png"));
		} catch (IOException e1) {
			System.out.println("ERROR: Problem with loading one of the images.");
		}
		
		setPreferredSize(new Dimension(shipyard.getWidth(null), shipyard.getHeight(null)));
	}

	public void paintComponent(Graphics g) {
		g.drawImage(shipyard, 0, 0, this);
		for (Ship s : ships) {
			s.draw(g);
			new Thread(s).start();
		}
	}

	public void addShip(final int shiptype) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Ship s;
				if (shiptype == 0) {
					s = new Ship(shiptype, redShip);
					ships.add(s);
				} else if (shiptype == 1) {
					s = new Ship(shiptype, purpleShip);
					ships.add(s);
				}
			}
		});
	}

}
