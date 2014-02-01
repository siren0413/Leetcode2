package question;

import java.util.*;
import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class BinaryTreeLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            Queue<TreeNode> subQ = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left!=null) subQ.add(node.left);
                if(node.right!=null) subQ.add(node.right);
            }
            totalList.add(subList);
            queue = subQ;
        }
        return totalList;
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(20);
        TreeNode n4 = new TreeNode(15);
        TreeNode n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(levelOrder(n1));
    }
}
