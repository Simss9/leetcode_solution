class Solution {
    Integer prev = null;
    int count = 0;
    int maxCount = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        inorder(root);

        int[] modes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }
        return modes;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        inorder(node.left);

        // process current node
        if (prev == null || node.val != prev) {
            count = 1;
        } else {
            count++;
        }

        if (count > maxCount) {
            maxCount = count;
            result.clear();
            result.add(node.val);
        } else if (count == maxCount) {
            result.add(node.val);
        }

        prev = node.val;

        inorder(node.right);
    }
}