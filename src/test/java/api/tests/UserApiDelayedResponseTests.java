package api.tests;

import jdk.jfr.Description;
import org.example.base.BaseTest;
import org.example.helper.AwaitilityUtils;
import org.example.helper.ReadableResponse;
import org.example.model.UserDTO;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserApiDelayedResponseTests extends BaseTest {

    //Scenario 1
    @Test()
    @Description("Creates user with valid data and retrieves user with user id")
    //TODO: The API returns a 404 error when I try to retrieve a user using my newly created user ID.
    public void shouldNotGetUserWithDelayedResponseWithNewUser() {
        UserDTO user = new UserDTO();
        user.setName("NewUser");
        user.setJob("NewJob");
        JSONObject mainData = userApiControllerData.prepareCreateUser(user);
        ReadableResponse createResponse = userApiController.createUser(mainData);
        assertThat("When user created successfully, response code should be '201'", createResponse.getStatusCode(), is(SC_CREATED));
        int userId = Integer.parseInt(createResponse.getBodyMessage("id"));

        AwaitilityUtils.waitForCondition(
                () -> userApiController.getUserWithUserIdDelayed(userId).getStatusCode(),
                SC_NOT_FOUND, 10
        );
    }
}
