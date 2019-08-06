import java.util.HashMap;
import java.util.HashSet;

public class Leetcode760 {


    static class Solution {
        public int[] anagramMappings(int[] A, int[] B) {

            //convert B to hashMaps
            HashMap<Integer, Integer> BMapper = new HashMap<>();

            for (int i = 0; i < B.length; i++) {
                BMapper.put(B[i], i);
            }
            int[] result = new int[A.length];
            for (int i = 0; i < A.length; i++) {
                result[i] = BMapper.get(A[i]);
            }
            return result;
        }
    }
}
