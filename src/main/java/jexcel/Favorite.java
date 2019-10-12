package jexcel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * @date 2019-08-28
 * @author kcx
 *
 */
public class Favorite {
	public static void createExcel(OutputStream os) throws WriteException,IOException{
        int count = 2500;
		//创建工作薄
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //创建新的一页
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //创建要显示的内容,创建一个单元格，第一个参数为列坐标，第二个参数为行坐标，第三个参数为内容
        for(int i = 0;i<count;i++) {
        	
//        	/**
//        	 * 方差，均值
//        	 */
//        	String string = getGaussianNumber(20,100);
        	Random r = new Random();
        	String date = null;
        	String car = null;
        	String qudao = null;
        	String qianyue = null;
        	String color = null;
        	String city = null;
        	String bank = null;
        	
        	/**
        	 * 签约时间
        	 */
        	int datecount = r.nextInt(723);
        	if(datecount<294) date="2019-07";
        	else if (datecount<723) {
				date = "2019-08";
			}
        	
        	/**
        	 * 车辆型号
        	 */
        	int carcount = r.nextInt(100);
        	if(carcount<23) car = "豪华";
        	else if (carcount<79) {
				car = "商务";
			}else {
				car = "家用";
			}
        	
        	/**
        	 * 颜色
        	 */
        	int colorcount = r.nextInt(100);
        	if(car.equals("豪华")) {
        		if(colorcount<90) color="蓝色";
        		else if (colorcount<99) {
					color="绿色";
				}else {
					color="其他";
				}
        	}else if (car.equals("商务")) {
        		if(colorcount<76) color="蓝色";
        		else if (colorcount<99) {
					color="绿色";
				}else {
					color="其他";
				}
			}else if (car.equals("家用")) {
				if(colorcount<64) color="蓝色";
        		else if (colorcount<99) {
					color="绿色";
				}else {
					color="其他";
				}
			}
        	
        	/**
        	 * 进件渠道
        	 */
        	int qudaocount = r.nextInt(100);
        	if(qudaocount<2) qudao="买单吧";
        	else if (qudaocount<42) {
				qudao = "手机银行";
			}else if (qudaocount<65) {
				qudao="网上银行";
			}else {
				qudao = "PDA";
			}
        	
        	/**
        	 * 签约状态
        	 */
        	int qianyuecount = r.nextInt(1000);
        	if(qianyuecount<950) qianyue = "签约成功";
        	else if (qianyuecount<965) {
				qianyue="签约失败";
			}else {
				qianyue = "已解约";
			}
        	
        	/**
        	 * city
        	 */
        	int  citycount = r.nextInt(1000);
        	if(citycount<90) city="上海";
        	else if (citycount<178) {
				city="北京";
			}else if (citycount<263) {
				city="深圳";
			}else if (citycount<343) {
				city="广州";
			}else if (citycount<420) {
				city="重庆";
			}else if (citycount<495) {
				city="杭州";
			}else if (citycount<565) {
				city="南京";
			}else if (citycount<632) {
				city="武汉";
			}else if (citycount<696) {
				city="成都";
			}else if (citycount<758) {
				city="宁波";
			}else if (citycount<818) {
				city="青岛";
			}else if (citycount<871) {
				city="天津";
			}else if (citycount<921) {
				city="厦门";
			}else {
				city="其他";
			}
        	
        	/**
        	 * bank
        	 */
        	int bankcount = r.nextInt(2500);
        	if(bankcount<723) bank="交通银行";
        	else if (bankcount<1573) {
				bank="工商银行";
			}else if (bankcount<2173) {
				bank="建设银行";
			}else {
				bank="其他";
			}
        	
        	Label daterank = new Label(0,i,date);
        	Label carrank = new Label(1, i, car);
        	Label qudaorank = new Label(2, i, qudao);
        	Label qianyuerank = new Label(3, i, qianyue);
        	Label colorrank = new Label(4, i, color);
        	Label cityrank = new Label(5,i,city);
        	Label bankrank = new Label(6, i, bank);
        	
        	sheet.addCell(daterank);
        	sheet.addCell(carrank);
        	sheet.addCell(qudaorank);
        	sheet.addCell(qianyuerank);
        	sheet.addCell(colorrank);
        	sheet.addCell(cityrank);
        	sheet.addCell(bankrank);
        }
        
        
        //把创建的内容写入到输出流中，并关闭输出流
        workbook.write();
        workbook.close();
        os.close();
    }
	
	public static String getGaussianNumber(int a,int average) {
    	Random random =new Random();
		return String.valueOf(Math.sqrt(a)*random.nextGaussian()+average);
	}
	
	public static void main(String[] args) throws WriteException, IOException {
		String fileName = "E:/要的数据.xls";
        File file = new File(fileName);//根据文件名创建一个文件对象
        OutputStream outputStream = new FileOutputStream(file);
        createExcel(outputStream);
	}
}
