package datastructure.tree;

/**
 * @date 2019-10-27
 * @author kcx
 * @description 二叉搜索树
 */
public class BinarySearchTree {

	public static void main(String[] args) {
		int[] array = {5,0,3,4,6,8};
		TreeNode root = new TreeNode(array[0]);
		for(int i=1;i<array.length;i++) {
			insert(root, array[i]);
		}
		
		root.inOrder();
	}
	
	/**
	 * 插入
	 */
	public static void insert(TreeNode root,int data) {
		if(root.data<data) {
			if(root.right == null) {
				root.right = new TreeNode(data);
			}else {
				insert(root.right, data);
			}
		}else {
			if(root.left == null) {
				root.left = new TreeNode(data);
			}else {
				insert(root.left, data);
			}
		}
	}
}

//创建节点类
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data) {
		super();
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setNo(int data) {
		this.data = data;
	}



	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [data=" + data + "]";
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder() {
		
		System.out.println(this);
		
		//递归向左子树遍历
		if(this.left!=null) this.left.preOrder();
		
		//递归向右字数遍历
		if(this.right!=null) this.right.preOrder();
	}
	
	/**
	 * 中序遍历
	 */
	public void inOrder() {
		
		//递归向左子树遍历
		if(this.left!=null) this.left.preOrder();
		
		System.out.println(this);
		
		//递归向右字数遍历
		if(this.right!=null) this.right.preOrder();
	}
	
	/**
	 * 中序遍历
	 */
	public void postOrder() {
		
		//递归向左子树遍历
		if(this.left!=null) this.left.preOrder();
				
		//递归向右字数遍历
		if(this.right!=null) this.right.preOrder();
		
		System.out.println(this);
	}
	
	
}
