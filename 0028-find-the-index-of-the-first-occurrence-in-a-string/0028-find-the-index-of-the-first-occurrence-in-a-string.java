class Solution {
    public int strStr(String haystack, String needle) {
        int L = 0;
        int S = L;
        int nIndex = 0;
        while (L < haystack.length()) {
            
            if (S < haystack.length() && nIndex <haystack.length() && haystack.charAt(S) == needle.charAt(nIndex)) {
                if (nIndex == needle.length() - 1) {
                   return S - (needle.length() - 1); 
                }
                    
                nIndex++;
                S++;
            } else {
                nIndex = 0;
                L ++;
                S = L;
            }
        }
        return -1;
        
    }
}

/*
                       *
hs = "blessingvfdf", nd = "sing"
          ^  ^                  
"sadbutsad"
"sad"

*/