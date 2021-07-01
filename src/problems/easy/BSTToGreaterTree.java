package problems.easy;

import problems.utils.TreeNode;

public class BSTToGreaterTree {

    private int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode node) {
        if (node == null)
            return;
        convert(node.right);
        sum += node.val;
        node.val = sum;
        convert(node.left);

    }

}
