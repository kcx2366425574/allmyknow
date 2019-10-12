package datastructure.array;

import java.util.Arrays;

/**
 * @date 2019-09-12
 * @author kcx
 * @description 稀疏数组的代码实现
 */
public class SparseArray {

	public static void main(String[] args) {
		
		/**
		 * 将二维数组转换为稀疏数组
		 */
//		int[][] a = new int[11][11];
//		a[3][3]=99;
//		a[7][2]=37;
//		a[9][1]=44;
//		System.out.println(Arrays.deepToString(getSparse(a)));
		
		/**
		 * 将稀疏数组转换为二维数组
		 */
		int[][] a = new int[][] {{11, 11, 3}, {3, 3, 99}, {7, 2, 37}, {9, 1, 44}};
		int[][] result = getOri(a);
		for(int i=0;i<result.length;i++) {
			for(int j=0;j<result[0].length;j++) {
				System.out.print(result[i][j]+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 将二维数组转化为稀疏数组
	 */
	public static int[][] getSparse(int[][] ori){
		
		/**
		 * 得到二维数组有效数据总数
		 */
		int len = 0;
		for(int i=0;i<ori.length;i++) {
			for(int j=0;j<ori[0].length;j++){
				if(ori[i][j]!=0) {
					len++;
				}
			}
		}
		
		/**
		 * 创建对应的稀疏数组
		 */
		int[][] result = new int[len+1][3];
		
		/**
		 * 给稀疏数组赋值
		 */
		result[0][0] = 11;
		result[0][1] = 11;
		result[0][2] = len;
		
		/**
		 * 遍历二维数组，给非0的值存入稀疏数组
		 */
		int count = 0;
		for(int i=0;i<ori.length;i++) {
			for(int j=0;j<ori[0].length;j++){
				if(ori[i][j]!=0) {
					count++;
					result[count][0]=i;
					result[count][1]=j;
					result[count][2]=ori[i][j];
				}
			}
		}
		
		/**
		 * 输出稀疏数组的值
		 */
		return result;
	}
	
	
	
	/**
	 * 将稀疏数组转化为二维数组
	 */
	public static int[][] getOri(int[][] ori){
		/**
		 * 初始化二维数组的大小
		 */
		int[][] a = new int[ori[0][0]][ori[0][1]];
		for(int i=1;i<ori.length;i++) {
			a[ori[i][0]][ori[i][1]]=ori[i][2];
		}
		
		return a;
	}
}
