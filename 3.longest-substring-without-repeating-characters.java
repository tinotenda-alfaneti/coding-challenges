/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> uniqChars = new HashSet<>();
        int L = 0, R = 0, maxLen = 0;

        while (R < s.length()) {
            while (uniqChars.contains(s.charAt(R))) {
                uniqChars.remove(s.charAt(L));
                L++;
            }
            uniqChars.add(s.charAt(R));
            maxLen = Math.max(maxLen, R - L + 1);
            R++;
        }

        return maxLen;
        
    }
}
// @lc code=end

