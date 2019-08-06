import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode509 {


    static class Solution {
        public int fib(int N) {
            if(N == 0){
                return 0;
            }
            if(N== 1 ){
                return  1;

            }

            //F(4) = F(3) + F(2)
            return fib(N-1)+fib(N-2);
        }
    }
}