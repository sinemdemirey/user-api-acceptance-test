package api.tests;

import jdk.jfr.Description;
import org.example.base.BaseTest;
import org.example.helper.ReadableResponse;
import org.example.model.UserDTO;
import org.example.test.TestListener;
import org.json.JSONObject;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.apache.http.HttpStatus.SC_CREATED;

import static org.apache.http.HttpStatus.SC_NO_CONTENT;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@Listeners(TestListener.class)
public class UserApiCRUDTests extends BaseTest {

    //Scenario 1
    @Test()
    @Description("Creates user with valid data")
    public void shouldCreateUser() {
        UserDTO user = new UserDTO();
        user.setName("TestUser");
        user.setJob("TestJob");
        JSONObject mainData = userApiControllerData.prepareCreateUser(user);
        ReadableResponse createResponse = userApiController.createUser(mainData);

        assertThat("When user created successfully, response code should be '201'", createResponse.getStatusCode(), is(SC_CREATED));
        assertThat("Name should be", createResponse.getBodyMessage("name"), is(user.getName()));
        assertThat("Job should be", createResponse.getBodyMessage("job"), is(user.getJob()));
    }

    //Scenario 2
    @Test()
    @Description("Updates user with user id")
    public void shouldUpdateUser() {
        int userId = 2;
        String updatedName = "Sinem";
        String updatedJob = "Millionaire";

        JSONObject updatedUserInfo = new JSONObject().put("name", updatedName).put("job", updatedJob);
        ReadableResponse updatedUserInfoResponse = userApiController.updateUser(updatedUserInfo,userId);
        assertThat("When user updated successfully, response code should be '200'", updatedUserInfoResponse.getStatusCode(), is(SC_OK));
        assertThat("Name should be", updatedUserInfoResponse.getBodyMessage("name"), is(updatedName));
        assertThat("Job should be", updatedUserInfoResponse.getBodyMessage("job"), is(updatedJob));
    }

    //Scenario 3
    @Test
    @Description("Deletes user with user id")
    public void shouldDeleteUser() {
        int userId = 2;
        ReadableResponse deletedUserResponse = userApiController.deleteUserWithUserId(userId);
        assertThat("When user deleted successfully, response code should be '200'", deletedUserResponse.getStatusCode(), is(SC_NO_CONTENT));
    }
}