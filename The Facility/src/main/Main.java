package main;

import player.Player;
import world.World;
import world.WorldGenerator;

public class Main implements Runnable{

	public static final String NAME = "The Facility";
	
	public boolean running = false;
	
	public static World world1;
	
	public static Listener listener = new Listener();
	
	GraphicsMain graphicsMain = new GraphicsMain();
	
	public static Player player;
	
	public synchronized void start() {
		running = true;
		new Thread(this).start();
	}
	
	public synchronized void stop() {
		running = false;
	}
	
	private void init() {
		world1 = WorldGenerator.createWorld(GraphicsMain.WIDTH*GraphicsMain.SCALE, GraphicsMain.HEIGHT*GraphicsMain.SCALE);
		player = new Player(5, WorldGenerator.dirtBoundary);
	}

	public void run() {
		long lastTime = System.nanoTime();
		double nanoPerUpdate = 1000000000D/60D;
		
		long lastTimer = System.currentTimeMillis();
		double delta = 0D;
		
		init();
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / nanoPerUpdate;
			lastTime = now;
			boolean shouldRender = false;
			
			while(delta >= 1) {
				update();
				delta--;
				shouldRender = true;
			}
			
			if(shouldRender) {
				graphicsMain.render();
				
			}
			
			if(System.currentTimeMillis() - lastTimer >= 1000) {
				lastTimer += 100;
			}
		}
	}
	
	public void update() {
		moveCamera();
		movePlayer();
	}
	
	public void moveCamera() {
		if(player.getX() > GraphicsMain.WIDTH - GraphicsMain.WIDTH/4) {
			GraphicsMain.right();
		}
		if(player.getX() < GraphicsMain.WIDTH/4) {
			GraphicsMain.left();
		}
	}
	
	public void movePlayer() {
		if(Listener.left) {
			player.moveLeft();
		}
		
		else if(Listener.right) {
			player.moveRight();
		}
	}

	public static void main(String[] args) {
		new Main().start();
	}

}
