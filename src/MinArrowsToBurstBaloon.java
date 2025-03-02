import java.util.*;
public class MinArrowsToBurstBaloon {
	public static int findMinArrowShots(List<List<Integer>> points) {
		if (points ==null || points.size() ==0) return 0;
		
		points.sort(Comparator.comparingInt(a->a.get(1)));
		int arrows =1;
		int previousArrowPos = points.get(0).get(1); // get the y coordinate of the first element
		
		for(int i=0;i<points.size();i++) {
			if(points.get(i).get(0) > previousArrowPos ) {
				arrows++;
				previousArrowPos = points.get(i).get(1); //y coordinate of the ith element
			}
		}
		return arrows;
	}
	
    public static void main(String[] args) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(10, 16));
        points.add(Arrays.asList(2, 8));
        points.add(Arrays.asList(1, 6));
        points.add(Arrays.asList(7, 12));

        System.out.println(findMinArrowShots(points)); // Output: 2
    }

}

