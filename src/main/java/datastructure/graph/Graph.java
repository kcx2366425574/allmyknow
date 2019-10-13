package datastructure.graph;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @date 2019-10-13
 * @author kcx
 * @description 
 */
public class Graph {

	/**
	 *存储顶点 
	 */
	private ArrayList<String> vertexList;
	
	/**
	 * 存储图对应的邻接矩阵
	 */
	private int[][] edges;
	
	/**
	 * 表示边的数目
	 */
	private int numOfEdges;
	
	/**
	 * 构造器
	 */
	public Graph(int n) {
		vertexList = new ArrayList<String>(n);
		edges = new int[n][n];
		numOfEdges = 0;
	}
	
	
	public static void main(String[] args) {
		
		int n = 5;
		String[] vertexValue = {"A","B","C","D","E"};
		Graph graph = new Graph(n);
		
		/**
		 * 添加顶点
		 */
		for(String val:vertexValue) {
			graph.insertVertex(val);
		}
		
		/**
		 * 添加边 A-B A-C B-C B-D B-E
		 */
		graph.insertEdge(0, 1, 1);
		graph.insertEdge(0, 2, 1);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 1);
		graph.insertEdge(1, 4, 1);
		
		/**
		 * 显示邻接矩阵
		 */
		graph.showGraph();
		
	}
	
	/**
	 * 返回图中节点个数
	 */
	public int getNumOfVertex() {
		return vertexList.size();
	}
	
	/**
	 * 返回边的数目
	 */
	public int getNumOfEdge() {
		return numOfEdges;
	}
	
	/**
	 * 返回通过下标i得到的顶点值
	 */
	public String getVertex(int i) {
		return vertexList.get(i);
	}
	
	/**
	 * 显示图对应的矩阵
	 */
	public void showGraph() {
		for(int[] link:edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	
	/**
	 * 返回两个顶点之间的权重值
	 */
	public int getWeight(int v1,int v2) {
		return edges[v1][v2];
	}
	
	/**
	 * 插入节点
	 * @param vertex
	 */
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	/**
	 * 插入边
	 * @param v1
	 * @param v2
	 * @param weight
	 */
	public void insertEdge(int v1,int v2,int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;
	}
	
}
