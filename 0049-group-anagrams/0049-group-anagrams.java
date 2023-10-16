class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        HashMap<String, ArrayList<String>> strsSortedMap = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        
        for (String str : strs) {
            
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sorted = new String(strArr);
            
            ArrayList<String> tmp = new ArrayList<>();
            
            if (strsSortedMap.containsKey(sorted)) {
                tmp = strsSortedMap.get(sorted);
                tmp.add(str);
                strsSortedMap.put(sorted, tmp);
            } else {
                tmp.add(str);
                strsSortedMap.put(sorted, tmp);
            }
        }
        
        for (String str : strsSortedMap.keySet()) {
            result.add(strsSortedMap.get(str));
        }
        
        return result;
        
        
    }
}