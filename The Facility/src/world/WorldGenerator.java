package world;

import java.util.Random;

public abstract class WorldGenerator {
	
	private static int[][] blockSheet;
	public static int stoneBoundary, dirtBoundary;
	private static final int tree[][] = {
		{World.LEAF, World.LEAF, World.LEAF, World.AIR, World.AIR, World.AIR, World.AIR},
		{World.LEAF, World.WOOD, World.WOOD, World.WOOD, World.WOOD, World.WOOD, World.WOOD},
		{World.LEAF, World.LEAF, World.LEAF, World.AIR, World.AIR, World.AIR, World.AIR}
	};
	
	
	public static World createWorld(int width, int height) {
		stoneBoundary = height - 2*(height/3);
		dirtBoundary = height - 2*(height/3) - height/12;
		
		blockSheet = new int[width][height];
		
		createStone(width, height);
		createDirt(width, height);
		createTrees(width, height);
		FacilityGenerator.createFacility(blockSheet);
		
		return new World(width, height, blockSheet);
	}
	
	private static void createStone(int width, int height) {
		
		for(int x = 0; x < width; x++) {
			for(int y = stoneBoundary; y < height; y++) {
				blockSheet[x][y] = World.STONE;
			}
		}
	}
	
	private static void createDirt(int width, int height) {
		
		for(int x = 0; x < width; x++) {
			for(int y = dirtBoundary + 1; y < stoneBoundary; y++) {
				blockSheet[x][y] = World.DIRT;
			}
		}
	}
	
	private static void createTrees(int width, int height) {
		Random rand = new Random();
		
		for(int i = 0; i < width; i++) {
			if(rand.nextInt(10) == 9) {
				if(blockSheet[i-1][dirtBoundary-1] == World.AIR) {
					for(int x = 0; x < tree.length; x++) {
						for(int y = 0; y < tree[x].length; y++) {
							if(x + i < width - tree.length && y + dirtBoundary < height) {
								blockSheet[x+i][y+dirtBoundary - 6] = tree[x][y];
							}
						}
					}
				}
			}
		}	
	}
}
