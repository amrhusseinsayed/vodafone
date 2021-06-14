package stepDefinitionImplementation.api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utils.JsonFileUtil;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostsImpl {
    private String baseUrl;
    private Response response;
    private JSONObject posts = (JSONObject) JsonFileUtil
            .getJsonObject().get("posts");

    public PostsImpl() {
        baseUrl = "https://jsonplaceholder.typicode.com";
    }

    /**
     * This method is used to get the data of a post based
     * on its given key that exists inside the test data
     * json file
     *
     * @param postKey the key of the post inside the test
     *                data json file
     * @return the post data as a json
     */
    public JSONObject getPost(String postKey) {
        return (JSONObject) posts.get(postKey);
    }

    /**
     * This method is used to get the response of the last
     * called API
     *
     * @return the response of the last called API
     */
    public Response getResponse() {
        return response;
    }

    /**
     * This method is used to get all the posts using
     * Rest Assured
     */
    public void getAllPosts() {
        response = given().relaxedHTTPSValidation().when().log().all()
                .get(baseUrl + "/posts")
                .then().log().all().extract().response();
    }

    /**
     * This method is used to get the data of the post that
     * has the given id using Rest Assured
     *
     * @param postId the id of the desired post
     */
    public void getPostById(String postId) {
        response = given().relaxedHTTPSValidation().when().log().all()
                .get(baseUrl + "/posts/" + postId)
                .then().log().all().extract().response();
    }

    /**
     * This method is used to add a new post using the given post
     * data
     *
     * @param post the data of the post as a json string
     */
    public void addPost(String post) {
        response = given().contentType(ContentType.JSON).and()
                .relaxedHTTPSValidation().and().body(post)
                .when().log().all().post(baseUrl + "/posts")
                .then().log().all().extract().response();
    }

    /**
     * This method is used to assert that the post data that has the
     * given key exists in the response body of the called API
     *
     * @param actualPost the data of the post extracted from the last
     *                   called API response
     * @param postKey    the key of the post inside the test data json
     * @return true in case that the post data of the given key exists
     * in the response body of the last called API, otherwise, false
     */
    @SuppressWarnings("unchecked")
    public boolean isPostDataExistsInResponse(Map<String, Object> actualPost
            , String postKey) {
        actualPost.put("userId", Long.valueOf((Integer) actualPost
                .get("userId")));
        actualPost.remove("id");

        Map<String, Object> expectedPost = ((Map<String, Object>) posts
                .get(postKey));

        return expectedPost.equals(actualPost);
    }
}
