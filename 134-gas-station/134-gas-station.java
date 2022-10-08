class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sumGas = 0, sumCost = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sumGas += gas[i];
            sumCost += cost[i];
        }
        
        if (sumGas < sumCost) {
            return -1;
        }
        int totalGas = 0;
        int start = 0;
        for (int i = 0; i < cost.length; i++) {
            totalGas += (gas[i] - cost[i]);
            
            if (totalGas < 0) {
                totalGas = 0;
                start = i + 1;
            }
        }
        return start;
        
    }
}