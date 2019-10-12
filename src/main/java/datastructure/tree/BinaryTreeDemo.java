package datastructure.tree;
/**
 * @date 2019-10-12
 * @author kcx
 * @description 
 */
public class BinaryTreeDemo {

	public static void main(String[] args) {
		
		BinaryTree tree = new BinaryTree();
		
		Node root = new Node(1, "宋江");
		Node node2 = new Node(2, "卢俊义");
		Node node3 = new Node(3, "吴用");
		Node node4 = new Node(4, "林冲");
		
		root.setLeft(node2);
		root.setRight(node3);
		
		node3.setRight(node4);
		
		root.postOrder();
		
		System.out.println("---------------");
		/**
		 * 设置根节点
		 */
		tree.setRoot(root);
		tree.postOrder();
	}

}

//创建二叉树
class BinaryTree{
	private Node root;

	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * 前序遍历
	 */
	public void preOrder() {
		if(root!=null) root.preOrder();
	}
	
	/**
	 * 中序遍历
	 */
	public void inOrder() {
		if(root!=null) root.inOrder();
	}
	
	/**
	 * 后序遍历
	 */
	public void postOrder() {
		if(root!=null) root.postOrder();
	}
	
	
	
	
}

//创建节点类
class Node{
	private int no;
	private String name;
	private Node left;
	private Node right;
	
	public Node(int no, String name) {
		super();
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name +  "]";
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


