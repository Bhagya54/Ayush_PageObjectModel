package utility;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataUtils extends BaseTest {
	@DataProvider(name="dp")
	public Object[][] getData(Method m){
		
		String sheetName=m.getName();
		int noOfRows=excel.getRowCount(sheetName);//4
		int noOfCols=excel.getColumnCount(sheetName);//2
		
		System.out.println(noOfRows + " " + noOfCols);
		
		Object[][] data = new Object[noOfRows-1][noOfCols];
		for(int row=2;row<=noOfRows;row++) {
			for(int col=0;col<noOfCols;col++) {
				data[row-2][col]=excel.getCellData(sheetName,col,row);
			}
		}
		
		return data;
	}
}
