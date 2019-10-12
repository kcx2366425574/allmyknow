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
		//����������
        WritableWorkbook workbook = Workbook.createWorkbook(os);
        //�����µ�һҳ
        WritableSheet sheet = workbook.createSheet("First Sheet",0);
        //����Ҫ��ʾ������,����һ����Ԫ�񣬵�һ������Ϊ�����꣬�ڶ�������Ϊ�����꣬����������Ϊ����
        for(int i = 0;i<count;i++) {
        	
//        	/**
//        	 * �����ֵ
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
        	 * ǩԼʱ��
        	 */
        	int datecount = r.nextInt(723);
        	if(datecount<294) date="2019-07";
        	else if (datecount<723) {
				date = "2019-08";
			}
        	
        	/**
        	 * �����ͺ�
        	 */
        	int carcount = r.nextInt(100);
        	if(carcount<23) car = "����";
        	else if (carcount<79) {
				car = "����";
			}else {
				car = "����";
			}
        	
        	/**
        	 * ��ɫ
        	 */
        	int colorcount = r.nextInt(100);
        	if(car.equals("����")) {
        		if(colorcount<90) color="��ɫ";
        		else if (colorcount<99) {
					color="��ɫ";
				}else {
					color="����";
				}
        	}else if (car.equals("����")) {
        		if(colorcount<76) color="��ɫ";
        		else if (colorcount<99) {
					color="��ɫ";
				}else {
					color="����";
				}
			}else if (car.equals("����")) {
				if(colorcount<64) color="��ɫ";
        		else if (colorcount<99) {
					color="��ɫ";
				}else {
					color="����";
				}
			}
        	
        	/**
        	 * ��������
        	 */
        	int qudaocount = r.nextInt(100);
        	if(qudaocount<2) qudao="�򵥰�";
        	else if (qudaocount<42) {
				qudao = "�ֻ�����";
			}else if (qudaocount<65) {
				qudao="��������";
			}else {
				qudao = "PDA";
			}
        	
        	/**
        	 * ǩԼ״̬
        	 */
        	int qianyuecount = r.nextInt(1000);
        	if(qianyuecount<950) qianyue = "ǩԼ�ɹ�";
        	else if (qianyuecount<965) {
				qianyue="ǩԼʧ��";
			}else {
				qianyue = "�ѽ�Լ";
			}
        	
        	/**
        	 * city
        	 */
        	int  citycount = r.nextInt(1000);
        	if(citycount<90) city="�Ϻ�";
        	else if (citycount<178) {
				city="����";
			}else if (citycount<263) {
				city="����";
			}else if (citycount<343) {
				city="����";
			}else if (citycount<420) {
				city="����";
			}else if (citycount<495) {
				city="����";
			}else if (citycount<565) {
				city="�Ͼ�";
			}else if (citycount<632) {
				city="�人";
			}else if (citycount<696) {
				city="�ɶ�";
			}else if (citycount<758) {
				city="����";
			}else if (citycount<818) {
				city="�ൺ";
			}else if (citycount<871) {
				city="���";
			}else if (citycount<921) {
				city="����";
			}else {
				city="����";
			}
        	
        	/**
        	 * bank
        	 */
        	int bankcount = r.nextInt(2500);
        	if(bankcount<723) bank="��ͨ����";
        	else if (bankcount<1573) {
				bank="��������";
			}else if (bankcount<2173) {
				bank="��������";
			}else {
				bank="����";
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
        
        
        //�Ѵ���������д�뵽������У����ر������
        workbook.write();
        workbook.close();
        os.close();
    }
	
	public static String getGaussianNumber(int a,int average) {
    	Random random =new Random();
		return String.valueOf(Math.sqrt(a)*random.nextGaussian()+average);
	}
	
	public static void main(String[] args) throws WriteException, IOException {
		String fileName = "E:/Ҫ������.xls";
        File file = new File(fileName);//�����ļ�������һ���ļ�����
        OutputStream outputStream = new FileOutputStream(file);
        createExcel(outputStream);
	}
}
