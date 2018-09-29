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
    public List<Interval> merge(List<Interval> intervals) {
        
        // sort based on start time
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        
        LinkedList<Interval> result = new LinkedList<Interval>();
        
        
        for(Interval interval : intervals) {
            if(result.isEmpty() || result.getLast().end < interval.start) {
                result.add(interval);
            }
            else {
                result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
        }
        
        return result;
    }
}
