class Solution {
    public List<List<String>> allPartition = new ArrayList<List<String>>();
    public List<String> onePartition = new ArrayList<String>();
    
    public List<List<String>> partition(String s) {
        
        travel(s.toCharArray(), 0);
        
        return allPartition;
    }
    
    public void travel(char[] arr, int startIdx) {
        for(int i = startIdx; i < arr.length; i++) {
            if(isPalindrome(arr, startIdx, i)) {
                String str = new String(Arrays.copyOfRange(arr, startIdx, i + 1));
                
                onePartition.add(str);
            
                // to the end
                if(i == arr.length - 1) {
                    allPartition.add(new ArrayList(onePartition));
                }
                else {
                    travel(arr, i + 1);
                }

                // backtracking
                onePartition.remove(onePartition.size() - 1);
            }
        }
    }
    
    public boolean isPalindrome(char[] arr, int startIdx, int endIdx) {
        while(startIdx <= endIdx && arr[startIdx] == arr[endIdx]) {
            startIdx++;
            endIdx--;
        }
        
        return startIdx >= endIdx;
    }
}
