class Solution {
     public boolean wordPattern(String pattern, String str) {
         
        String[] sArray= str.split(" ");
         
        HashMap<Character, String> patternMap = new HashMap<>();
         
        if (sArray.length != pattern.length())
            return false;
         
        for (int i=0; i<sArray.length; i++) {
            char c = pattern.charAt(i);
            
            if (patternMap.containsKey(c)){
                if(!patternMap.get(c).equals(sArray[i]))
                    return false;
            } else {
                
                if(patternMap.containsValue(sArray[i]))
                    return false;
                
                patternMap.put(c, sArray[i]);
            }    
        }
        return true;
    }
}