class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);

        int i = 0, j = list.size() - 1;

        while (i < j) {
            int sum = list.get(i) + list.get(j);

            if (sum == k) return true;
            else if (sum < k) i++;
            else j--;
        }

        return false;
    }

    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;

        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}