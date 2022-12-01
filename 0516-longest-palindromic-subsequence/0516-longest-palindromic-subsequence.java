/*
The Recursive Relationship
If the first and last letters are equal then the 
 we call our method with 2 + longest palindromic subsequence of string without the first and last letter
 Else we call without the first and without the second and get the maximum for the 2
 
 The base cases are 2, since we can move by 1 and by 2
 First if the length of the substring is 1 then we return 1
 Otherwise if the length is 2 we return 1 or 2 depending on whether the letters are equal of not
 
 To reduce duplicate calculations, the value for every i and j will be stored in a map
 
 Time Complexity = O(n2)
 Space Complexity = O(n2)
*/

class Solution {
    public int longestPalindromeSubseq(String s) {
        
        return LPSUtil(s, 0, s.length() - 1, new HashMap<String, Integer>());
        
    }
    
    public int LPSUtil(String s, int i, int j, HashMap<String, Integer> memo) {
        
        //when length of string is equal to 1
        if (i == j) {
            return 1;
        }
        //when length of string is equal to 2
        if (j - i == 1) {
            if(s.charAt(i) == s.charAt(j)) {
                return 2;
            } else {
                return 1;
            }
        }
        String ij = i + "-" + j;
        if (memo.containsKey(ij)) {
            return memo.get(ij);
        }
        
        //if last and first letters are equal
        if (s.charAt(i) == s.charAt(j)) {
            int ans = 2 + LPSUtil(s, i + 1, j - 1, memo);
            memo.put(ij, ans);
            return ans;
        } else {
            int ans = Math.max(LPSUtil(s, i + 1, j, memo), LPSUtil(s, i, j - 1, memo));
            memo.put(ij, ans);
            return ans;
        }
    }
}