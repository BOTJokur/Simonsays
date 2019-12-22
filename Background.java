package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Background {
		
	public int Checker(ArrayList<Integer> colororder, int place, int cinput) {
		if (colororder.get(place) == cinput) {
			if (place == colororder.size()-1) {
				return 2;
			}
			return 1;
		}else {
			return 0;
		}
	}
	
	public ArrayList<Integer> getOrder(int level) {
		//order.clear();
		ArrayList<Integer> colororder = new ArrayList<Integer>();
		Random color = new Random();
		for (int i = 0; i < level; i++) {
			colororder.add(color.nextInt(4));
		}
		System.out.println(colororder);
		return colororder;
	}
	
}




