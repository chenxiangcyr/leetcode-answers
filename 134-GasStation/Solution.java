class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = gas.length - 1;
        int end = 0;
        
        int sum = gas[start] - cost[start];
        
        while (start > end) {
            if (sum >= 0) {
                sum += gas[end] - cost[end];
                end++;
            }
            else {
                start--;
                sum += gas[start] - cost[start];
            }
        }
        
        return sum >= 0 ? start : -1;
    }
}
