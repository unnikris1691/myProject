
public class Leetcode104 {



    static class Solution {
        public int maxDepth(TreeNode root) {

            return returnMaxDepth(root,0);
        }

        private int returnMaxDepth(TreeNode root, int depth) {
            int rDepth = depth;
            int lDepth =depth;
            if(root == null){
                return  0;
            }

            rDepth +=returnMaxDepth(root.right,++rDepth);
            lDepth += returnMaxDepth(root.left,++lDepth);

            return Math.max(rDepth,lDepth);

        }
    }
}
