package api.testcases;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.github.javafaker.Faker;
import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints_GettingUrlsFromRoutesPropertiesFile;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest_UserEndpoints_GettingUrlsFromRoutesPropertiesFile {

	Faker faker;
	User userPayload;
	@BeforeClass
	public void setUpData() {
		faker=new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		userPayload.setEmail(faker.internet().emailAddress());
		userPayload.setPassword(faker.internet().password(2, 6));
		userPayload.setPhone(faker.phoneNumber().cellPhone());
		userPayload.setUsername(faker.name().username());
		
		}
	
	@AfterMethod
	public void endTestcase(ITestResult result) {
		System.out.println(result.getName() + " ended");
	}
	
	@Test(priority=1)
	public void createUserTest() {
		
		Response res=UserEndpoints_GettingUrlsFromRoutesPropertiesFile.createUser(userPayload);
		Assert.assertEquals(res.statusCode(), 200);
		
		res.then().log().body();
	}
	
	@Test(priority=2)
	public void getUserByUsernameTest() {
		Response res=UserEndpoints_GettingUrlsFromRoutesPropertiesFile.getUser(this.userPayload.getUsername());
		Assert.assertEquals(res.statusCode(), 200);
		res.then().log().body();
	}
	
	@Test(priority=3)
	public void updateUserByUsernameTest() {
		//update data using payload
		userPayload.setFirstName(faker.name().firstName());
		userPayload.setLastName(faker.name().lastName());
		
		Response res=UserEndpoints_GettingUrlsFromRoutesPropertiesFile.updateUser(this.userPayload.getUsername(),userPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		res.then().log().body();
		
		System.out.println("Updated user details");
		getUserByUsernameTest();
		
		
	}
	
		
	@Test(priority=4)
	public void deleteUserByUsernameTest() {
		Response res = UserEndpoints_GettingUrlsFromRoutesPropertiesFile.deleteUser(this.userPayload.getUsername());
		Assert.assertEquals(res.getStatusCode(),200);
		System.out.println(this.userPayload.getUsername() +" user has been deleted");
		res.then().log().body();
		
	}
	
	
}
