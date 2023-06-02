/*
126000    255



*/

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int lastIdx = m + n - 1;
        int n1 = m-1;
        int n2 = n-1;
        
        for (int i = lastIdx; i >= 0; i--) {
            
            if (n2 < 0) {
                return;
            }
            
            if (n1 < 0 && n2 > -1) {
                
                nums1[i] = nums2[n2];
                n2--;
                continue;
            }
            
            if (nums1[n1] >= nums2[n2]) {
                
                nums1[i] = nums1[n1];
                n1--;
                
            } else {
                nums1[i] = nums2[n2];
                n2--;
            }
            
        }
            
    }
}