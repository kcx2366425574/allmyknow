package proxy.dynamicproxy.anotherdynamictest;
/**
 * @date 2019-12-09
 * @author kcx
 * @description 
 */
public class CountImpl implements Count {

	@Override
	public void queryCount() {
		System.out.println("这是查询count");
	}

}
