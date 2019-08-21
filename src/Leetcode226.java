class Leetcode226 {
    class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return null;
            }
            TreeNode tempNode = root.left;
            root.left = root.right;
            root.right = tempNode;

            invertTree(root.left);
            invertTree(root.right);


            return root;
        }
    }



}