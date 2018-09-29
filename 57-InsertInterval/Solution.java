/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        // the intervals were initially sorted according to their start times
        Iterator<Interval> itr = intervals.iterator();
        
        int originalSize = intervals.size();
        
        int idx = 0;
        while(itr.hasNext()) {
            Interval curInterval = itr.next();
            
            if(newInterval.end < curInterval.start) {
                break;
            }
            
            // merge if overlap
            if(isOverlapped(curInterval, newInterval)) {
                newInterval = mergeOverlapped(curInterval, newInterval);
                itr.remove();
            }
            
            idx++;
        }
        
        
        int newSize = intervals.size();
        
        int diff = originalSize - newSize;
        
        intervals.add(idx - diff, newInterval);
        
        
        return intervals;
    }
    
    public boolean isOverlapped(Interval i1, Interval i2) {
        
        if(i1.start <= i2.end && i2.start <= i1.end) {
            return true;
        }
        
        return false;
    }
    
    public Interval mergeOverlapped(Interval i1, Interval i2) {
        return new Interval(
            Math.min(i1.start, i2.start), 
            Math.max(i1.end, i2.end)
        );
    }
}
