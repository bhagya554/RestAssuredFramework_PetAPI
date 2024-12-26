package base;
import java.io.FileInputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import api.payload.User;
import api.utilities.ExcelReader;

public class BaseTest {

	public ExcelReader xl = new ExcelReader("./src/test/resources/excelData/UserData.xlsx");
	public String sheetName = "UsersDataSheet";
	public User userPayload = new User();
	public FileInputStream fis;
	public Logger log = LogManager.getLogger(this.getClass());
	
}
