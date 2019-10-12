package datastructure.list;
/**
 * @date 2019-09-23
 * @author kcx
 * @description 
 */
public class SingleLinkedList {

	/**
	 * 定义一个头结点,不存放数据
	 */
	private Node head = new Node();
	
}

class Node {
	private int no;
	private String name;
	private Node next;
	
	
	public Node() {
		super();
	}

	public Node(int no,String name) {
		this.no = no;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [no=" + no + ", name=" + name + ", next=" + next + "]";
	}
	
	
}
