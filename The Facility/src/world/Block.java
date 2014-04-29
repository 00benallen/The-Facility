package world;

import java.awt.image.BufferedImage;

public class Block {
	private int blockID;
	private BufferedImage image;
	
	public Block(int blockID) {
		if(blockID == World.AIR || blockID == World.STONE || blockID == World.DIRT || blockID == World.WOOD || blockID == World.LEAF) {
			this.blockID = blockID;
		}
		else {
			blockID = World.INVALID;
		}
		
		
		
		
	}
	
	public int getBlockID() {
		return blockID;
	}

}
