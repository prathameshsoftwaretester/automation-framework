package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommentsTest {

    @Test
    public void getCommentsCount() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/comments");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> comments =
                response.jsonPath().getList("$");

        // Assertion for comments list
        Assert.assertTrue(comments.size() > 0,
                "Comments list is empty");

        System.out.println("\nTotal Comments Count: "
                + comments.size());
    }

    @Test
    public void groupEmailsByTLD() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/comments");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> comments =
                response.jsonPath().getList("$");

        // Assertion for comments list
        Assert.assertTrue(comments.size() > 0,
                "Comments list is empty");

        Map<String, List<String>> tldMap =
                new HashMap<>();

        for (Map<String, Object> comment : comments) {

            String email =
                    comment.get("email").toString();

            String[] parts =
                    email.split("\\.");

            String tld =
                    parts[parts.length - 1];

            if (!tldMap.containsKey(tld)) {

                tldMap.put(tld,
                        new ArrayList<>());
            }

            tldMap.get(tld).add(email);
        }

        // Assertion for grouped TLD data
        Assert.assertTrue(tldMap.size() > 0,
                "TLD grouping failed");

        System.out.println("\nEmails Grouped By TLD:\n");

        for (String tld : tldMap.keySet()) {

            System.out.println(tld
                    + " : "
                    + tldMap.get(tld));
        }
    }
}