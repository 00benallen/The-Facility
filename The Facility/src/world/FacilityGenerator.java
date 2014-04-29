package world;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import main.GraphicsMain;

public class FacilityGenerator {
	
	public static void createFacility(int[][] blockSheet) {
		
		Scanner s = null;
		try {
			s = new Scanner(new File("res/facility/FacilityInfo.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		ArrayList<ArrayList<Integer>> textInfo = new ArrayList<ArrayList<Integer>>();
		while(s.hasNext()) {
			String line = s.nextLine();
			ArrayList<Integer> lineNumbers = new ArrayList<Integer>();
			for(int i = 0; i < line.length(); i++) {
				lineNumbers.add(Integer.parseInt(line.substring(i, i+1)));
			}
			textInfo.add(lineNumbers);
		}
		
		for(int x = 0; x < textInfo.size(); x++) {
			for(int y = 0; y < textInfo.get(x).size(); y++) {
				blockSheet[y + GraphicsMain.WIDTH/2][x + WorldGenerator.dirtBoundary - 38] = textInfo.get(x).get(y);
			}
		}
		
	}

}
