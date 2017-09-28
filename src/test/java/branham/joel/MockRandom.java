package branham.joel;

import java.util.Random;

public class MockRandom extends Random{
	
	public int[] nums;
	public int index = 0;
	
	public MockRandom(){
		nums = new int[]{100, 200, 50,
				100, 300, 50,
				900, 900, 50,
				300, 300, 100,
				300, 300, 50,
				300, 300, 60};
	}
	
	public int nextInt(int bounds){
		int nextInt = nums[index++];
		if (index + 1 == nums.length){
			index = 0;
		}
		return nextInt;
	}


//	for (int i = 0; i < circleArray.length; i++){
//		int x = r.nextInt(windowWidth - 1);
//		int y = r.nextInt(windowHeight - 1);
//
//		int biggestRadius = (windowHeight - y) / 2;
//		if ((windowWidth - x) / 2 < biggestRadius){
//			biggestRadius = (windowWidth - x) / 2;
//		}
//		int radius = 1 + r.nextInt(biggestRadius);
//
//		updateCircleModelAtIndex(i, new CircleModel(radius, x, y));
//		//	updateCircleColor(i);
//
//		System.out.println(x + " " +  y + " " + radius);
//	}
}