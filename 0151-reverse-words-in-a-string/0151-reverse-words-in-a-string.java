class Solution {
    public String reverseWords(String s) {
        
        ArrayList<String> resArr = new ArrayList<>();
        
        for (String word : s.split(" ")) {
            if (word.strip().length() != 0) {
                resArr.add(word.strip());
            }
        }
        
        Collections.reverse(resArr);
        
        String result = String.join(" ", resArr);
        
        return result;
    }
}