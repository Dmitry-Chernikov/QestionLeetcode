import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Integer[] arr = {27, null, 34, null, 58, 50, null, 44};
//        TreeNode root = initTreeNode(arr);
//        MinimumDistanceBetweenBstNodes a = new MinimumDistanceBetweenBstNodes();
//        System.out.println(a.minDiffInBST(root));
        int[] arr = {100,77,83};
        MinimumAmountOfTimeToFillCups a = new MinimumAmountOfTimeToFillCups();
        System.out.println(a.fillCups(arr));
    }

    static TreeNode initTreeNode(Integer[] arr) {
        boolean left = true;
        boolean right = false;
        TreeNode root = null;
        Queue<TreeNode> list = new LinkedList<TreeNode>();

        for (Integer a : arr) {
            if (list.isEmpty()) {
                list.offer(new TreeNode(a));
                root = list.peek();
            } else {
                if (a != null) {
                    if (left && list.peek().left == null) {
                        list.peek().left = new TreeNode(a);
                        list.offer(list.peek().left);
                        left = false;
                        right = true;
                        continue;
                    }
                    if (right && list.peek().right == null) {
                        list.peek().right = new TreeNode(a);
                        list.offer(list.peek().right);
                        list.remove();
                        right = false;
                        left = true;
                        continue;
                    }
                } else {
                    if (left && list.peek().left == null) {
                        left = false;
                        right = true;
                        continue;
                    }
                    if (right && list.peek().right == null) {
                        list.remove();
                        right = false;
                        left = true;
                        continue;
                    }
                }
            }
        }
        list.clear();
        return root;
    }
}
