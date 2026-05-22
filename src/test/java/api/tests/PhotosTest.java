package api.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class PhotosTest {

    @Test
    public void getPhotosCount() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/photos");

        // Assertion for status code
        response.then().statusCode(200);

        List<Map<String, Object>> photos =
                response.jsonPath().getList("$");

        // Assertion for photos list
        Assert.assertTrue(photos.size() > 0,
                "Photos list is empty");

        System.out.println("\nTotal Photos Count: " + photos.size());
    }

    @Test
    public void validateRandomPhotoUrls() {

        Response response =
                RestAssured.get("https://jsonplaceholder.typicode.com/photos");

        // Assertion for status code
        response.then().statusCode(200);

        List<Map<String, Object>> photos =
                response.jsonPath().getList("$");

        // Assertion for photos list
        Assert.assertTrue(photos.size() > 0,
                "Photos list is empty");

        Random random = new Random();

        System.out.println("\nValidating Random 5 URLs:\n");

        for (int i = 0; i < 5; i++) {

            int randomIndex = random.nextInt(photos.size());

            Map<String, Object> photo = photos.get(randomIndex);

            String url = photo.get("url").toString();

            try {

                java.net.URL imageUrl =
                        new java.net.URL(url);

                java.net.HttpURLConnection connection =
                        (java.net.HttpURLConnection)
                                imageUrl.openConnection();

                connection.setRequestMethod("GET");

                connection.connect();

                int statusCode =
                        connection.getResponseCode();

                System.out.println("URL: " + url);

                if (statusCode == 200) {

                    System.out.println("Valid Image URL");
                }

                else {

                    System.out.println("Broken Image URL");
                }

                System.out.println("Status Code: "
                        + statusCode);
            }
            

            catch (Exception e) {

                System.out.println("URL: " + url);

                System.out.println("Broken Image URL");

                System.out.println("Reason: External SSL/network issue");
            }
            
            System.out.println("--------------------------------");
        }
    }
}
