package shipyardsimulation;
import java.awt.Graphics;
import java.awt.Image;
import java.util.concurrent.Semaphore;

public class Ship implements Runnable {

	Semaphore semaphore = new Semaphore(1);

	Image image;
	int xposition, yposition;
	int velocity;

	public Ship(int shiptype, Image image) {
		this.image = image;
		this.xposition = -130;
		this.yposition = 175;
		if (shiptype == 0) {
			this.velocity = 1;
		} else {
			this.velocity = 2;
		}
	}

	@Override
	public void run() {
		move();
		stop();
		
	}

	public void move(){
		if (xposition < 400) {
			xposition = xposition + velocity;
		} 
		else if (xposition > 400){
			xposition = xposition + velocity;
		}
	}
	
	public void stop(){
		if(xposition ==400){
			try {
				semaphore.acquire(1);
				Thread.sleep((long) (Math.random() * 3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				semaphore.release();
				xposition = xposition + velocity;
			}
		}
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(image, xposition, yposition, null);
	}

}
