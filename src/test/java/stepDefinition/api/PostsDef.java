package stepDefinition.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.JSONObject;
import org.junit.Assert;
import stepDefinitionImplementation.api.PostsImpl;
import utils.ActionsUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PostsDef extends ActionsUtil {
    private PostsImpl posts = new PostsImpl();

    /**
     * This method is used to get all the posts
     */
    @Given("admin gets all the posts")
    public void admin_get_all_the_posts() {
        try {
            logInfo("Getting all the posts data");

            posts.getAllPosts();

            logInfo("All the posts data has been successfully retrieved");
        } catch (Exception e) {
            logError("Exception while trying to retrieve all the posts");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to get the data of a specific post
     * by its given id
     *
     * @param postId the id of the post
     */
    @Given("admin gets the post with id {string}")
    public void admin_gets_the_post_with_id(String postId) {
        try {
            logInfo(String.format("Getting the data of the post with id as '%s'", postId));

            posts.getPostById(postId);

            logInfo(String.format("The data of the post with id as '%s' has been successfully retrieved"
                    , postId));
        } catch (Exception e) {
            logError(String.format("Exception while trying to retrieve the post with id '%s'"
                    , postId));
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to add a new post using its given key
     *
     * @param postKey the key of the post json inside the test
     *                data json
     */
    @Given("admin adds a post with the key {string}")
    public void admin_adds_a_post_with_the_key(String postKey) {
        try {
            JSONObject post = posts.getPost(postKey);

            logInfo(String.format("Adding a new post with the data: '%s'"
                    , post));

            posts.addPost(post.toJSONString());

            logInfo("The new post has been successfully added");
        } catch (Exception e) {
            logError("Exception while trying to add a new post");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to assert that the given status code matches
     * the status code of the called API
     *
     * @param statusCode the expected status code
     */
    @Then("verify that a status code of {int} is received from the called API")
    public void verify_that_a_status_code_of_is_received_from_the_called_API(
            int statusCode) {
        try {
            logInfo(String.format("Asserting that the retrieved status code from the called API is '%s'"
                    , statusCode));

            Assert.assertEquals(statusCode, getStatusCode(posts.getResponse()));

            logInfo(String.format("The retrieved status code is '%s'"
                    , statusCode));
        } catch (Exception | AssertionError e) {
            logError("Exception while trying to assert on the status code of the called API");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to assert that the number of the posts
     * of the response body of the called api matches the given number
     *
     * @param postsNumber the expected posts number
     */
    @SuppressWarnings({"unchecked"})
    @Then("the number of posts in the response equals {int}")
    public void the_number_of_posts_in_the_response_equals(int postsNumber) {
        try {
            logInfo(String.format("Asserting that the number of posts in the response body of the called API is '%s'"
                    , postsNumber));

            Assert.assertEquals(postsNumber, ((List<Map<String, Object>>)
                    getResponseBody(posts.getResponse())).size());

            logInfo(String.format("The number of the retrieved posts is '%s'"
                    , postsNumber));
        } catch (Exception | AssertionError e) {
            logError("Exception while trying to assert on the number of the retrieved posts");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to assert that the given value of the given
     * key exists in the response body of the called API
     *
     * @param key   the expected key
     * @param value the expected value
     */
    @Then("the {string} in the response json equals {int}")
    public void the_in_the_response_json_equals(String key, int value) {
        try {
            logInfo(String.format("Asserting that the %s value in the response body is '%s'"
                    , key, value));

            Assert.assertEquals(String.format("The %s value in the response json does not match the expected one"
                    , key), value,
                    getValueFromResponseJson(posts.getResponse(), key));

            logInfo(String.format("The %s value in the response body is '%s'"
                    , key, value));
        } catch (Exception | AssertionError e) {
            logError(String.format("Exception while trying to assert on the value of the %s"
                    , key));
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }

    /**
     * This method is used to assert that the post data that has the
     * given key exists in the response body of the called API
     *
     * @param postKey the post key
     */
    @SuppressWarnings("unchecked")
    @Then("the response json contains all the data of {string}")
    public void the_response_json_contains_all_the_data_of(String postKey) {
        try {
            logInfo("Asserting that the data of the added post exists in the response body");

            Assert.assertTrue(posts.isPostDataExistsInResponse((Map<String, Object>)
                            getResponseBody(posts.getResponse())
                    , postKey));

            logInfo("The data of the added post exists in the response body");
        } catch (Exception | AssertionError e) {
            logError("Exception while trying to assert on the existence of the post data in the response body");
            logError(String.format("Stack Trace: %s"
                    , Arrays.toString(e.getStackTrace())));
            throw e;
        }
    }
}
