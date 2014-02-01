package beans;

public class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode parent;
	public boolean visited = false;
	
	public TreeNode(){}
	public TreeNode(int data){
		this.val = data;
	}
	public TreeNode(int data, TreeNode left, TreeNode right){
		this.val = data;
		this.left = left;
		this.right = right;	
	}
	
	public String toString(){
		return ""+val;
	}
}
