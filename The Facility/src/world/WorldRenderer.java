package world;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import main.GraphicsMain;

public abstract class WorldRenderer {
	public static BufferedImage airImage, stoneImage, dirtImage, woodImage, leafImage, concreteImage, concreteBackgroundImage, invalidImage;
	private static boolean firstRender = true;
	
	public static void renderWorld(World world, Graphics2D g, int viewX, int viewY) {
		if(firstRender) {
			try {
				airImage = ImageIO.read(new File("res/blocks/airBlock.png"));
				stoneImage = ImageIO.read(new File("res/blocks/stoneBlock.png"));
				dirtImage = ImageIO.read(new File("res/blocks/dirtBlock.png"));
				woodImage = ImageIO.read(new File("res/blocks/woodBlock.png"));
				leafImage = ImageIO.read(new File("res/blocks/leafBlock.png"));
				concreteImage = ImageIO.read(new File("res/blocks/concreteBlock.png"));
				concreteBackgroundImage = ImageIO.read(new File("res/blocks/concreteBackgroundBlock.png"));
				invalidImage = ImageIO.read(new File("res/blocks/invalidBlock.png"));
			} catch(IOException e) {
				JOptionPane.showMessageDialog(null, "CANNOT FIND BLOCK IMAGE, PLEASE CHECK THE RES/BLOCKS FOLDER");
			}
			firstRender = false;
		}
		
		for(int x = viewX/8; x < (viewX + GraphicsMain.WIDTH/GraphicsMain.ZOOM)/8; x++) {
			for(int y = viewY/8; y < (viewY + GraphicsMain.HEIGHT/GraphicsMain.ZOOM)/8; y++) {
				switch (world.getBlockSheet()[x][y]) {
				case 1: {
					g.drawImage(stoneImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, stoneImage.getWidth()/8*GraphicsMain.ZOOM, stoneImage.getHeight()/8*GraphicsMain.ZOOM, null);
					break;
				}
				case 2: {
					g.drawImage(dirtImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, dirtImage.getWidth()/8*GraphicsMain.ZOOM, dirtImage.getHeight()/8*GraphicsMain.ZOOM, null);
					break;
				}
				case 3: {
					g.drawImage(woodImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, woodImage.getWidth()/8*GraphicsMain.ZOOM, woodImage.getHeight()/8*GraphicsMain.ZOOM,null);
					break;
				}
				case 4: {
					g.drawImage(leafImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, leafImage.getWidth()/8*GraphicsMain.ZOOM, leafImage.getHeight()/8*GraphicsMain.ZOOM,null);
					break;
				}
				case 5: {
					g.drawImage(concreteImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, concreteImage.getWidth()/8*GraphicsMain.ZOOM, concreteImage.getHeight()/8*GraphicsMain.ZOOM,null);
					break;
				}
				case 6: {
					g.drawImage(concreteBackgroundImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, invalidImage.getWidth()/8*GraphicsMain.ZOOM, invalidImage.getHeight()/8*GraphicsMain.ZOOM,null);
					break;
				}
				case -1: {
					g.drawImage(invalidImage, x*GraphicsMain.ZOOM*8, y*GraphicsMain.ZOOM*8, invalidImage.getWidth()/8*GraphicsMain.ZOOM, invalidImage.getHeight()/8*GraphicsMain.ZOOM,null);
					break;
				}
				}
			}
		}
	}

}
