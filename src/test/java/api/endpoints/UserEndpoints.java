package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;

public class UserEndpoints {

	public static Response createUser(User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).body(payload)
			.when()
				.post(Routes.createUserURL);
		return response;
	}

	public static Response getUser(String uname) {

		Response response = given()
				.pathParam("username", uname)
			.when()
				.get(Routes.getUserURL);
		return response;
	}
	
	public static Response updateUser(String uname,User payload) {

		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username", uname)
				.body(payload)
			.when()
				.put(Routes.updateUserURL);
		return response;
	}

	public static Response deleteUser(String uname) {

		Response response = given()
				.pathParam("username", uname)
			.when()
				.delete(Routes.deleteUserURL);
		return response;
	}
}
