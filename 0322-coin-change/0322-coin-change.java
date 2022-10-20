
/*
Using BFS
- Visited set - to avoid repetition
- Queue that we will populate with change after subtracting each coin

                11
              /  |  \
             /   |   \
            10   8    6
           / | \
          /  |  \  
         9   8   5
- Continuing with the tree, it is clear that we need to get the level with a zero and 
return that.
The above solution ran into a Time Limit Exceeded error and messed up my screen :( 

Optimization:
- Use dynamic programming - Bottom-up approach
- Basically, we are starting from zero and the storing the number of coins needed for each
    e.g say coins = [1, 2, 4, 5], CN = coins needed, 
    CN[0] = 0
    CN[1] = 1
    CN[3] = 3 / 1 + CN[2]
    etc
    Hence if we are asked to calculate for 7 it will be just 1 + CN[6]-> 1 + 1 + CN[5] -> 7
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinsNeeded = new int[amount + 1];
        
        Arrays.fill(coinsNeeded, amount + 1);
        
        // since coins needed for amount zero == 0
        coinsNeeded[0] = 0;
        
        //update coinesNeeded array
        
        for (int i = 1; i < coinsNeeded.length; i++) {
            for (int coin : coins) {
                if ((i - coin) >= 0) {
                    coinsNeeded[i] = Math.min((1 + coinsNeeded[i - coin]), coinsNeeded[i]);
                }
                
            }
        }
   
        return coinsNeeded[amount] == amount + 1 ? -1 : coinsNeeded[amount];
        
    }
}