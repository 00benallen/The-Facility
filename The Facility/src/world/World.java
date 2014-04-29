package world;


public class World {
	private int width, height;
	private int[][] blockSheet;
	static public final int AIR = 0, STONE = 1, DIRT = 2, WOOD = 3, LEAF = 4, CONCRETE = 5, CONCRETEBACKGROUND = 6, INVALID = -1;
	
	public World(int width, int height, int[][] blockSheet) {
		this.width = width;
		this.height = height;
		this.blockSheet = blockSheet;
	}
	
	public void setBlockSheet(int[][] blockSheet) {
		this.blockSheet = blockSheet;
	}
	
	public int[][] getBlockSheet() {
		return blockSheet;
	}
	
	public void setBlock(int x, int y, Block newBlock) {
		blockSheet[x][y] = newBlock.getBlockID();
	}
	
	public Block getBlock(int x, int y) {
		return new Block(blockSheet[x][y]);
	}
	
	public int getWidth() {
		return width;
	}
	
	public int getHeight() {
		return height;
	}

}
