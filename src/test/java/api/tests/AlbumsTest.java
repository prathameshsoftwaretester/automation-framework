package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AlbumsTest {

    @Test
    public void getAlbumsCount() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/albums");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> albums =
                response.jsonPath().getList("$");

        // Assertion for albums list
        Assert.assertTrue(albums.size() > 0,
                "Albums list is empty");

        System.out.println("\nTotal Albums Count: "
                + albums.size());
    }

    @Test
    public void getNonDivisibleAlbums() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/albums");

        // Status code assertion
        response.then().statusCode(200);

        List<Map<String, Object>> albums =
                response.jsonPath().getList("$");

        // Assertion for albums list
        Assert.assertTrue(albums.size() > 0,
                "Albums list is empty");

        List<Map<String, Object>> filteredAlbums =
                new ArrayList<>();

        for (Map<String, Object> album : albums) {

            int userId =
                    (Integer) album.get("userId");

            int id =
                    (Integer) album.get("id");

            if (id % userId != 0) {

                filteredAlbums.add(album);
            }
        }

        // Assertion for filtered results
        Assert.assertTrue(filteredAlbums.size() > 0,
                "No filtered albums found");

        System.out.println(
                "\nAlbums where id is NOT divisible by userId:\n");

        for (Map<String, Object> album : filteredAlbums) {

            System.out.println(album);
        }

        System.out.println(
                "\nFinal Filtered Count: "
                        + filteredAlbums.size());
    }
}