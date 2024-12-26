package api.endpoints;

public class Routes {
	/*
	 * Swagger URI: https://petstore.swagger.io/ Create user:
	 * https://petstore.swagger.io/v2/user Get User:
	 * https://petstore.swagger.io/v2/user/{username} Update user:
	 * https://petstore.swagger.io/v2/user/{username} Delete user:
	 * https://petstore.swagger.io/v2/user/{username}
	 * 
	 */
	public static String baseURL = "https://petstore.swagger.io/v2";

	// User Model
	public static String createUserURL = baseURL + "/user";
	public static String getUserURL = baseURL + "/user/{username}";
	public static String updateUserURL = baseURL + "/user/{username}";
	public static String deleteUserURL = baseURL + "/user/{username}";

	// Store Model
	

	// Pet Model
	
}
