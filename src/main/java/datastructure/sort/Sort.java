package datastructure.sort;

/**
 * @date 2019-09-24
 * @author kcx
 * @description 排序算法案例
 */
public class Sort {
	
	public static void main(String[] args) {
		int[] text = {1,2,3,4,5,6,7,8};
		int[] arr = {3,9,-1,10,-2,4,7};
		
		/**
		 * 如果排序数组本身就是有序的，则只会进行一次循环
		 */
		bubble(arr);
		
		/**
		 * 选择排序测试
		 */
//		select(arr);
		
		
		
		
		System.out.println(2^3);
//		System.out.println(Arrays.toString(arr));
	}
	
	/**
	 * 冒泡排序，从小到大
	 * @param ori
	 */
	public static void bubble(int[] ori) {
		int temp = 0;
		/**
		 * 冒泡排序优化，如果在某次循环中没有进行交换，说明数组有序，没有必要再循环下去
		 */
		boolean flag = false;
		
		for(int i=0;i<ori.length-1;i++) {
			for(int j=0;j<ori.length-1-i;j++) {
				if(ori[j]>ori[j+1]) {
					flag = true;
					temp = ori[j+1];
					ori[j+1] = ori[j];
					ori[j] = temp;
				}
			}
			
			
			if(!flag) {
				break;
			}else {
				flag = false;
			}
		}
	}

	/**
	 * 选择排序,从小到大
	 */
	public static void select(int[] ori) {
		for(int i=0;i<ori.length-1;i++) {
			int target=ori[i];
			int index=i;
			for(int j=i;j<ori.length-1;j++) {
				if(target>ori[j+1]) {
					target = ori[j+1];
					index = j+1;
				}
			}
			ori[index]=ori[i];
			ori[i]=target;
		}
	}
	
	/**
	 * 插入排序,从小到大
	 */
	public static void insert(int[] ori) {
		
	}
	
	
	
}
