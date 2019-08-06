public class DFS {

    // create the tree node structure
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

    }

    public static void main(String[] args) {

        int[] a = {5, 3, 2, 8, 11, 15, 6,  12, 10, 9, 1, -1};
        int[] b = {3, 5};

        Node root = new Node(4);

        root = createTree(root, a);
        sortTree(root);
        root = deleteNode(root,4);
        sortTree(root);

    }

    private static void sortTree(Node root) {


        if (root.left != null) {
            sortTree(root.left);
        }
        System.out.println(root.value);
        if (root.right != null) {
            sortTree(root.right);

        }

    }

    private static Node createTree(Node rootNode, int[] array) {
        for (int ele : array) {
            rootNode = insert(rootNode, ele);
        }
        return rootNode;
    }

    private static Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        }
        if (value > currentNode.value) {
            currentNode.right = insert(currentNode.right, value);
        } else {
            currentNode.left = insert(currentNode.left, value);
        }
        return currentNode;
    }

    private static Node deleteNode(Node rootNode, int deleteVal) {

        if (rootNode == null) {
            return null;
        }

        if (rootNode.value == deleteVal) {

            if(rootNode.right == null && rootNode.left == null){
                //case 1
                return null;
            }

            //case 2
            if(rootNode.left == null){
                return rootNode.right;
            }

            if(rootNode.right == null){
                return rootNode.left;
            }

            //case 3

            int smallestValue =  findMinNode(rootNode.right);
            rootNode.value = smallestValue;
            rootNode.right = deleteNode(rootNode.right,smallestValue);

        }

        if (deleteVal < rootNode.value) {
            rootNode.left = deleteNode(rootNode.left, deleteVal);
            return rootNode;
        }
        rootNode.right = deleteNode(rootNode.right, deleteVal);


        return rootNode;

    }

    private static int findMinNode(Node node){
       return node.left == null ? node.value : findMinNode(node.left);
    }
}
