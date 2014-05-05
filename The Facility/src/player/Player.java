package player;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player {
	private int x, y, walkSpeed;
	public static final int width = 8, height = 16;
	BufferedImage image;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
		
		try {
			image = ImageIO.read(new File("res/player/playerSide.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void moveLeft() {
		x -= walkSpeed;
	}
	
	public void moveRight() {
		x += walkSpeed;
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

}
