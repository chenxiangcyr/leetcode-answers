ass Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length;
        int n = B.length;
        
        // 确保数组A长度小于等于数组B长度m <= n，因此确保 j 不会为负数
        if (m > n) {
            int[] temp = A;
            A = B;
            B = temp;
            
            int tmp = m;
            m = n;
            n = tmp;
        }
        
        int iMin = 0;
        int iMax = m;
        int halfLen = (m + n + 1) / 2;
        
        while (iMin <= iMax) {
            // 初始从数组A的中间分隔
            int i = (iMin + iMax) / 2;
            
            // 确保条件1：`i + j == m + n - i - j`
            int j = halfLen - i;
            
            // i 太小，j 太大
            if (i < iMax && B[j-1] > A[i]) {
                iMin = iMin + 1;
            }
            // i 太大，j 太小
            else if (i > iMin && A[i-1] > B[j]) {
                iMax = iMax - 1;
            }
            // 确保条件2：`A[i - i] <= B[j] && B[j - 1] <= A[i]`
            else {
                // 找到左边集合最大的数
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = B[j-1];
                }
                else if (j == 0) {
                    maxLeft = A[i-1];
                }
                else {
                    maxLeft = Math.max(A[i-1], B[j-1]);
                }
                
                // 总共有奇数个数字，直接返回中间的数字
                if ( (m + n) % 2 == 1 ) {
                    return maxLeft;
                }

                // 找到右边集合最小的数
                int minRight = 0;
                if (i == m) {
                    minRight = B[j];
                }
                else if (j == n) {
                    minRight = A[i];
                }
                else {
                    minRight = Math.min(B[j], A[i]);
                }

                // 总共有偶数个数字，返回中间的数字的平均数
                return (maxLeft + minRight) / 2.0;
            }
        }
        
        return 0.0;
    }
}
