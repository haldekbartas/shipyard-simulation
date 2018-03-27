package shipyardsimulation;
/* Shipyard Simulation 
 * App for "PWIR" classes 2017/2018
 * 
 * @authors Bart³omiej Ha³daœ, Mateusz Kalfas
 * KrDzIs3011io
 *  
 * 
 */

public class App {

	public static void main(String[] args) {

		final Windowx window = new Windowx();

		window.pack();
		window.setVisible(true);
		window.setLocationRelativeTo(null);
	
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
					}
					window.repaint();
				}
			}
		}).start();
	

	}

}
