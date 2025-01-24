package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {
	File file;
	FileInputStream fis;
	static XSSFWorkbook wb;
	
	public DataReader() {
		file = new File("./TestData/testdata.xlsx");
		try {
			fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Issues with reading test data file. "+e.getMessage() );
		}	
	}
public static String readStringData(int rownum,int colnum) {
	String address = wb.getSheet("frontierdata").getRow(rownum).getCell(colnum).getStringCellValue();
	return address;
}

public static int readIntData(int rownum,int colnum) {
	int add = (int)wb.getSheet("frontierdata").getRow(rownum).getCell(colnum).getNumericCellValue();
	return add;
}
}
