import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Leetcode746 {
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int f1 = cost[0];
            int f2 = cost[1];
            int tot =0;
            for(int i =2 ; i < cost.length; i++){
                tot = cost[i]+Math.min(f1,f2);
                f1=f2;
                f2= tot;
            }
            return Math.min(f1,f2);
        }
    }



}