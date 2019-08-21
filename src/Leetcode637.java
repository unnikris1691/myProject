import com.sun.source.tree.Tree;

import java.util.*;

class Leetcode637 {

    public static void main(String[] args){

        TreeNode root = new TreeNode(2147483647);
        root.right = new TreeNode(2147483647);
        root.left = new TreeNode(2147483647);

        System.out.println(averageOfLevels(root));
    }
    public static  List<Double> averageOfLevels(TreeNode root) {
        List<Double> averageLevels = new ArrayList<>();

        Queue<TreeNode> treeQ = new LinkedList<>();
        treeQ.add(root);

        while(!treeQ.isEmpty()){
            long sum = 0L;
            int divisor = treeQ.size();
            Queue<TreeNode> temp = new LinkedList<>(treeQ);

            for(int i =0; i< temp.size();i++) {
                TreeNode node = treeQ.poll() ;
                sum = sum+ node.val;

                if (node.left != null) {
                    treeQ.add(node.left);

                }

                if (node.right != null) {
                    treeQ.add(node.right);

                }
            }

                averageLevels.add((double) (sum) / divisor);

        }
        return averageLevels;
    }

}