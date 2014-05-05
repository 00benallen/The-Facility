package main;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import player.Player;
import world.WorldRenderer;

public class GraphicsMain extends Canvas {
	public static final int WIDTH = 1024, HEIGHT = 768, SCALE = 1, ZOOM = 16;
	private Graphics2D g;
	private JFrame frame;
	static int viewX = 0;
	static int viewY = 0;
	
	public GraphicsMain() {
		setMinimumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setMaximumSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		setIgnoreRepaint(true);
		
		frame = new JFrame(Main.NAME);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		frame.add(this, BorderLayout.CENTER);
		frame.addKeyListener(Main.listener);
		frame.pack();
		
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		if((Main.player.getX() - (WIDTH/ZOOM)/2) > 0) {
			viewX = (Main.player.getX() - (WIDTH/ZOOM)/2) ;
		}
		else {
			viewX = 0;
		}
		
		if((Main.player.getY() - (HEIGHT/ZOOM)/2) > 0) {
			viewY = (Main.player.getY() - (HEIGHT/ZOOM)/2) ;
		}
		else {
			viewY = 0;
		}
	}
	
	public static void left() {
		if(GraphicsMain.viewX - 100 > 0) {
			viewX -= 1;
		}
	}
	
	public static void right() {
		if(viewX + 100 < WIDTH - 100) {
			viewX += 1;
		}
	}
	
	public static void up() {
		if(viewY - 100 > 0) {
			viewY -= 1;
		}
	}
	
	public static void down() {
		if(viewY + 100 < HEIGHT - 100) {
			viewY += 1;
		}
	}
	
	public void render() {
		BufferStrategy bs = getBufferStrategy(); //method from Canvas class
		
		if(bs == null) {
			createBufferStrategy(3); //creates it only for the first time the loop runs (trip buff)
			return;
		}
		
		
		g = (Graphics2D)bs.getDrawGraphics();
		draw();
		
		
 		g.dispose();
 		bs.show();
	}
	
	private void draw() {
		drawBackground();
		drawWorld();
		drawPlayer();
		
	}
	
	private void drawBackground() {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
	}
	private void drawWorld() {
		WorldRenderer.renderWorld(Main.world1, g, viewX, viewY);
		
	}
	private void drawPlayer() {
		g.drawImage(Main.player.getImage(), (Main.player.getX() - viewX)*ZOOM, (Main.player.getY() - viewY)*ZOOM, Player.width/8*ZOOM, Player.height/8*ZOOM, null);
	}

}
