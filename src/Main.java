import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Integer[] arr = {27, null, 34, null, 58, 50, null, 44};
//        TreeNode root = initTreeNode(arr);
//        MinimumDistanceBetweenBstNodes a = new MinimumDistanceBetweenBstNodes();
//        System.out.println(a.minDiffInBST(root));

        //int[] arr = {100,77,83};
        //MinimumAmountOfTimeToFillCups a = new MinimumAmountOfTimeToFillCups();
        //System.out.println(a.fillCups(arr));
//////////////
        //int[] arr = {3,3,3,3,5,5,5,2,2,7};
        //int[] arr = {1,9};
        //int[] arr = {13,13,13,13,15,15,15,12,12,17,18,19,22,22,22,22};

        //ReduceArraySizeToTheHalf a = new ReduceArraySizeToTheHalf();
        //System.out.println(a.minSetSize(arr));
 ////////////
        //YandexContestAutumn y = new YandexContestAutumn();
        //y.alisaPlagiarism();
        //y.alisaPlagiarismArrChar();
////////////
        //YandexAerobatics y = new YandexAerobatics();
        //y.getInfoAerobatics();
////////////
        //YandexCunningCipher y = new YandexCunningCipher();
        //y.getCipher();
////////////
        //YandexLogRocket y = new YandexLogRocket();
        //y.sortLog();
////////////
        //HeadHunter h = new HeadHunter();
        //h.getSumGame();
        //h.getSquareRegion();
////////////
        WeekendOfferYandex y = new WeekendOfferYandex();
        //y.EvenOddMatrix();
        y.PhotoFeed();
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
