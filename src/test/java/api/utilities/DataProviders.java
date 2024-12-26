package api.utilities;
import java.io.IOException;
import org.testng.annotations.DataProvider;

import base.BaseTest;

public class DataProviders extends BaseTest {
	//ExcelReader xl = new ExcelReader("./src/test/resources/excelData/UserData.xlsx");
	//String sheetName = "UsersDataSheet";
	
	@DataProvider(name = "UsersData")
	public String[][] getAllData() throws IOException {
		int rowcount = xl.getRowCount(sheetName);//3
		int colcount = xl.getCellCount(sheetName, 1);//7
		System.out.println(rowcount + "--------" + colcount);
		String data[][] = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j] = xl.getCellData(sheetName, i, j);
			}
		}
		return data;
	}
	
	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException {
		int rowcount = xl.getRowCount(sheetName);
		System.out.println(rowcount);
		String data[] = new String[rowcount];
		for(int i=1;i<=rowcount;i++) {
			
				data[i-1] = xl.getCellData(sheetName, i, 1);
			}
		
		return data;
	}
	
	@DataProvider(name = "UpdateUsersData")
	public String[][] UpdateUserData() throws IOException {
		sheetName = "UpdateUsersDataSheet";
		int rowcount = xl.getRowCount(sheetName);//3
		int colcount = xl.getCellCount(sheetName, 1);//7
		System.out.println(rowcount + "--------" + colcount);
		String data[][] = new String[rowcount][colcount];
		for(int i=1;i<=rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				data[i-1][j] = xl.getCellData(sheetName, i, j);
			}
		}
		return data;
	}

}
