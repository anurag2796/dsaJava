package trees;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    /**
     * Definition for a binary tree node.
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) return List.of();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int min = 0, max = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(root, 0));
        while(!queue.isEmpty()){
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int index = pair.getValue();
            map.putIfAbsent(index, new ArrayList<>());
            map.get(index).add(node.val);
            if(node.left != null){
                queue.add(new Pair<>(node.left, index - 1));
                min = Math.min(min, index-1);
            }
            if(node.right != null){
                queue.add(new Pair<>(node.right, index + 1));
                max = Math.max(max, index+1);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for(int i=min; i<=max;i++){
            result.add(map.get(i));
        }
        return result;
    }

    // Helper methods to build nodes
    private TreeNode n(int val) {
        return new TreeNode(val);
    }
    private TreeNode n(int val, TreeNode l, TreeNode r) {
        return new TreeNode(val, l, r);
    }

    public static void main(String[] args) {
        BinaryTreeVerticalOrderTraversal solution = new BinaryTreeVerticalOrderTraversal();

        // Test 1: Standard tree
        //      3
        //     / \
        //    9   8
        //   / \ / \
        //  4  0 1  7
        TreeNode root1 = solution.n(3,
                solution.n(9, solution.n(4), solution.n(0)),
                solution.n(8, solution.n(1), solution.n(7))
        );
        System.out.println("Test 1: " + solution.verticalOrder(root1)); // Expected: [[4], [9], [3,0,1], [8], [7]]

        // Test 2: Single node
        TreeNode root2 = solution.n(1);
        System.out.println("Test 2: " + solution.verticalOrder(root2)); // Expected: [[1]]

        // Test 3: Left skewed
        TreeNode root3 = solution.n(1, solution.n(2, solution.n(3), null), null);
        System.out.println("Test 3: " + solution.verticalOrder(root3)); // Expected: [[3], [2], [1]]

        // Test 4: Right skewed
        TreeNode root4 = solution.n(1, null, solution.n(2, null, solution.n(3)));
        System.out.println("Test 4: " + solution.verticalOrder(root4)); // Expected: [[1], [2], [3]]

        // Test 5: Null root
        System.out.println("Test 5: " + solution.verticalOrder(null)); // Expected: []

        // Test 6: Tree with duplicate values
        TreeNode root6 = solution.n(1, solution.n(2, solution.n(2), null), solution.n(2));
        System.out.println("Test 6: " + solution.verticalOrder(root6)); // Expected: [[2], [2], [1,2]]

        // Test 7: Tree with only left and right children
        TreeNode root7 = solution.n(1, solution.n(2), solution.n(3));
        System.out.println("Test 7: " + solution.verticalOrder(root7)); // Expected: [[2], [1], [3]]
    }
}