import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GoRestAPITest {
    // Base URL of the GoRest API
    private String baseURL = "https://gorest.co.in/public/v2/";

    @Test
    public void testGetUsers() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer 505aeca1732815e9d3b70fa798dc836e35fe5a106101978166d367c7d1d25abf");
        Response response = request.get(baseURL + "users/5454465");

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println(response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(statusCode, 200, "Status code is not equal");
    }

    @Test
    public void testGetPosts() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer 505aeca1732815e9d3b70fa798dc836e35fe5a106101978166d367c7d1d25abf");
        Response response = request.get(baseURL + "posts");

        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));

        // Validate the response status code
        assert(statusCode == 200);
    }

    @Test
    public void testCreateUser() {
        String userBody = "{\"name\":\"Mr. SQA\",\"email\":\"emap_sqa_@conn.example\",\"gender\":\"male\",\"status\":\"active\"}";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer 505aeca1732815e9d3b70fa798dc836e35fe5a106101978166d367c7d1d25abf");
        request.header("Content-Type", "application/json");
        request.body(userBody);
        Response response = request.post(baseURL + "users");


        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println(response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(statusCode, 201, "User is not created");
    }

    @Test
    public void testUpdateUser() {
        String userBody = "{\"name\":\"Mr. SQA\",\"email\":\"epam_sqa_@conn.example\",\"gender\":\"male\",\"status\":\"inactive\"}";
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer 505aeca1732815e9d3b70fa798dc836e35fe5a106101978166d367c7d1d25abf");
        request.header("Content-Type", "application/json");
        request.body(userBody);
        Response response = request.put(baseURL + "users/5456392");


        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println(response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(statusCode, 200, "User is not updated");
    }

    @Test
    public void testDeleteUser() {
        RequestSpecification request = RestAssured.given();
        request.header("Authorization", "Bearer 505aeca1732815e9d3b70fa798dc836e35fe5a106101978166d367c7d1d25abf");
        request.header("Content-Type", "application/json");
        Response response = request.delete(baseURL + "users/5456392");


        int statusCode = response.getStatusCode();
        System.out.println("Status Code: " + statusCode);
        System.out.println(response.getBody().asString());

        // Validate the response status code
        Assert.assertEquals(statusCode, 204, "User is not deleted");
    }
}
