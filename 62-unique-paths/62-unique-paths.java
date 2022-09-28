import java.util.HashMap;
class Solution {
    
    static class Pair {
            
            int m = 0;
            int n = 0;
            
            Pair (int n, int m) {
                this.m = m;
                this.n = n;
            }
            @Override
            public boolean equals(Object obj) {
                if (obj == this) return true;
                if (!(obj instanceof Pair)) return false;
                
                Pair newObj = (Pair) obj;
                
                return newObj.m == m && newObj.n == n;
                    
            }
            @Override
            public String toString() {
                return this.m + ", " + this.n;
            }
            @Override
            public int hashCode(){
                int favNum = 5;
                int code = 1;
                String nm = n+""+m;
                code = favNum * code + (nm.equals("00") ? 0 : nm.hashCode());
                return code;
            }
        }
    public int uniquePaths(int m, int n) {
        
        HashMap<Pair, Integer> memo = new HashMap<>();
        
        return findPath(m - 1, n - 1, memo);
    }
    
    public int findPath(int m, int n, HashMap<Pair, Integer> memo) {
        
        Pair temp = new Pair(n, m);
        if (m < 0 || n < 0)
            return 0;
        else if (m == 0 || n == 0)
            return 1;
        else if (memo.containsKey(temp)){
            return memo.get(temp);
        }
        else{
            memo.put(temp, findPath(m - 1, n, memo) + findPath(m, n - 1, memo));
            return memo.get(temp);
        }
        
    }
}