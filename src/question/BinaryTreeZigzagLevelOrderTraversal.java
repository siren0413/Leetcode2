package question;

import java.util.*;
import beans.*;

/**
 * Created by siren0413 on 1/29/14.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root){
        if(root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> totalList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean reverse = false;
        while(!queue.isEmpty()){
            ArrayList<Integer> subList = new ArrayList<>();
            Queue<TreeNode> subQ = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                subList.add(node.val);
                if(node.left!=null) subQ.add(node.left);
                if(node.right!=null) subQ.add(node.right);
            }
            if(reverse) Collections.reverse(subList);
            reverse = !reverse;
            totalList.add(subList);
            queue = subQ;
        }
        return totalList;
    }
}
