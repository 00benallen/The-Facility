package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Listener implements KeyListener {
	public static boolean left = false, right = false, up = false, down  = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = true;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			right = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			left = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_UP) {
			up = false;
		}
		else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
			down = false;
		}
		
	}
}
