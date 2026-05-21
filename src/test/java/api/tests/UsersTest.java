package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class UsersTest {

    @Test
    public void getJohnsGroupUser() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/users");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> users =
                response.jsonPath().getList("$");

        // Assertion for users list
        Assert.assertTrue(users.size() > 0,
                "Users list is empty");

        boolean userFound = false;

        for (Map<String, Object> user : users) {

            Map<String, Object> company =
                    (Map<String, Object>) user.get("company");

            String companyName =
                    company.get("name").toString();

            if (companyName.equalsIgnoreCase("Johns Group")) {

                userFound = true;

                Map<String, Object> address =
                        (Map<String, Object>) user.get("address");

                System.out.println("\nUser Details:\n");

                System.out.println("Name: "
                        + user.get("name"));

                System.out.println("Username: "
                        + user.get("username"));

                System.out.println("Email: "
                        + user.get("email"));

                System.out.println("City: "
                        + address.get("city"));

                System.out.println("Phone: "
                        + user.get("phone"));
            }
        }

        // Assertion to validate Johns Group user exists
        Assert.assertTrue(userFound,
                "No user found from Johns Group");
    }
}