package telran.time;

import telran.util.Arrays;

public class FutureProximityAdjuster implements TimePointAdjuster {
    TimePoint[] timePoints;

    public FutureProximityAdjuster(TimePoint[] points) {
    	//i'd corrected code and remove equals timePoints from resulting array
      
    	this.timePoints = Arrays.removeDuplicates(points);
    
        Arrays.bubbleSort(this.timePoints, (a, b) -> a.compareTo(b));
    }

    @Override
    public TimePoint adjust(TimePoint point) {
        int res = Arrays.binarySearch(timePoints, point, (a, b) -> a.compareTo(b));
        TimePoint result = null;
        
      
        if (res >= timePoints.length - 1) {
            result = null;
        } 
       
        else if (res <= -1 && Math.abs(res) >= timePoints.length+1) {
            result = null;
        } 
        
        else if (res<=-1) {
            result = timePoints[-res - 1];
        } 
      
        else  result = timePoints[res + 1];
        

        return result;
    }
}
