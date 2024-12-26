package api.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.UserEndpoints;
import api.endpoints.UserEndpoints_GettingUrlsFromRoutesPropertiesFile;
import api.payload.User;
import api.utilities.DataProviders;
import base.BaseTest;
import extentlisteners.ExtentListeners;
import io.restassured.response.Response;

public class DataDrivenTests_UserEndpoints_GettingUrlsFromRoutesPropertiesFile extends BaseTest {
	
	@BeforeClass
	public void setUp() {
		System.setProperty("log4j.configurationFile", "src/test/resources/log4j2.xml");
	}
	//User userPayload = new User();

	@Test(priority = 1, dataProviderClass = DataProviders.class, dataProvider = "UsersData")
	public void createUsersUsingDP(String userID, String userName, String firstName, String lastName, String email,
					String password, String phone) {
		log.info("Creating user: " + userName);
		userPayload.setId(Integer.parseInt(userID));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		Response res = UserEndpoints_GettingUrlsFromRoutesPropertiesFile.createUser(userPayload);
		Assert.assertEquals(res.statusCode(), 200);
		System.out.println(userName + " username has been created");
		res.then().log().body();
		log.info(userName + " username has been created");
		ExtentListeners.test.info(userName + " username has been created");
		
	}

	@Test(priority = 2, dataProviderClass = DataProviders.class, dataProvider = "UserNames")
	public void getUserByUsernameUsingDP(String userName) {
		log.info("Retrieving information of user: " + userName);
		Response res = UserEndpoints_GettingUrlsFromRoutesPropertiesFile.getUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Retrieval of " + userName + " details");
		res.then().log().body();
		log.info("Retrieval of " + userName + " details");
		ExtentListeners.test.info("Retrieval of " + userName + " details");
		

	}

	@Test(priority = 3, dataProviderClass = DataProviders.class, dataProvider = "UpdateUsersData")
	public void updateUsersUsingDP(String userName, String firstName, String lastName, String email) {
		log.info("Updating user: " + userName);
		// update data using payload
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);

		Response res = UserEndpoints_GettingUrlsFromRoutesPropertiesFile.updateUser(userName, userPayload);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println("Updated user details for : " + userName);
		res.then().log().body();
		log.info("Updated user details for : " + userName);
		ExtentListeners.test.info("Updated user details for : " + userName);
		
	}

	@Test(priority = 4, dataProviderClass = DataProviders.class, dataProvider = "UserNames")
	public void deleteUserByUsernameUsingDP(String userName) {
		log.info("Deleting user: " + userName);
		Response res = UserEndpoints_GettingUrlsFromRoutesPropertiesFile.deleteUser(userName);
		Assert.assertEquals(res.getStatusCode(), 200);
		System.out.println(userName + " user has been deleted");
		res.then().log().body();
		log.info(userName + " user has been deleted");
		ExtentListeners.test.info(userName + " user has been deleted");
		

	}
}
