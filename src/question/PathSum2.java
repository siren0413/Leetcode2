package question;

import java.util.*;

import beans.*;

/**
 * Created by siren0413 on 1/28/14.
 */
public class PathSum2 {
    public static ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        ArrayList<Integer> subList = new ArrayList<>();
        pathSumHelper(root, sum, subList, totalList);
        return totalList;
    }

    private static void pathSumHelper(TreeNode root, int sum, ArrayList<Integer> subList, ArrayList<ArrayList<Integer>> totalList) {
        if (root == null) return;
        if (root.left == null && root.right == null && sum - root.val == 0) {
            subList.add(root.val);
            totalList.add(new ArrayList<Integer>(subList));
            subList.remove(subList.size() - 1);
            return;
        }
        subList.add(root.val);
        pathSumHelper(root.left, sum - root.val, subList, totalList);
        pathSumHelper(root.right, sum - root.val, subList, totalList);
        subList.remove(subList.size() - 1);
    }


    //test
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(8);
        TreeNode n4 = new TreeNode(11);
        TreeNode n5 = new TreeNode(13);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(2);
        TreeNode n9 = new TreeNode(1);
        TreeNode n10 = new TreeNode(5);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n4.left = n7;
        n4.right = n8;
        n3.left = n5;
        n3.right = n6;
        n6.right = n9;
        n6.left = n10;
        System.out.println(pathSum(n1, 22));
    }


}
