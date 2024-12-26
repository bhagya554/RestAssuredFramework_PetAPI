package api.endpoints;

import static io.restassured.RestAssured.given;
import java.util.ResourceBundle;
import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints_GettingUrlsFromRoutesPropertiesFile {

	//Additional method created to Load urls from Properties file
	
	static ResourceBundle getUrl(){
		ResourceBundle routes = ResourceBundle.getBundle("properties.routes");
		return routes;
	}
	public static Response createUser(User payload) {

		String createUserURL= getUrl().getString("createUserURL");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
			.when()
				.post(createUserURL);
		return response;
	}

	public static Response getUser(String uname) {
		String getUserURL= getUrl().getString("getUserURL");
		Response response = given()
				.pathParam("username", uname)
			.when()
				.get(getUserURL);
		return response;
	}
	
	public static Response updateUser(String uname,User payload) {

		String updateUserURL= getUrl().getString("updateUserURL");
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.body(payload)
			.when()
				.put(updateUserURL);
		return response;
	}

	public static Response deleteUser(String uname) {

		String deleteUserURL= getUrl().getString("deleteUserURL");
		Response response = given()
				.pathParam("username", uname)
			.when()
				.delete(deleteUserURL);
		return response;
	}
}
