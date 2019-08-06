class LeetCode344 {
    class Solution {
        public void reverseString(char[] s) {
            if(s.length==0){
                return;
            }
            for(int i =0 , j= s.length -1 ; i <s.length/2 +1 ;i++ ){
                char temp = s[i];
                s[i] = s[j];
                s[j]= temp;
                j--;

            }

        }
    }


}