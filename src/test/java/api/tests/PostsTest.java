package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class PostsTest {

    @Test
    public void getPostsCount() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> posts =
                response.jsonPath().getList("$");

        // Assertion for posts list
        Assert.assertTrue(posts.size() > 0,
                "Posts list is empty");

        System.out.println("\nTotal Posts Count: "
                + posts.size());
    }

    @Test
    public void findRepellatPosts() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/posts");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> posts =
                response.jsonPath().getList("$");

        // Assertion for posts list
        Assert.assertTrue(posts.size() > 0,
                "Posts list is empty");

        boolean keywordFound = false;

        System.out.println("\nPosts containing keyword 'repellat':\n");

        for (Map<String, Object> post : posts) {

            String title =
                    post.get("title").toString().toLowerCase();

            String body =
                    post.get("body").toString().toLowerCase();

            if (title.contains("repellat")
                    || body.contains("repellat")) {

                keywordFound = true;

                System.out.println(post);

                System.out.println("--------------------------------");
            }
        }

        // Assertion to validate keyword exists
        Assert.assertTrue(keywordFound,
                "No posts found containing keyword 'repellat'");
    }
}