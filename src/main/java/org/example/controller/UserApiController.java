package org.example.controller;

import org.example.config.ConfigReader;
import org.example.helper.GeneralApiController;
import org.example.helper.ReadableResponse;
import org.json.JSONObject;

public class UserApiController extends GeneralApiController {
     public UserApiController(){
         super(ConfigReader.getProperty("USER_API_URL"));
     }

    public ReadableResponse createUser(JSONObject mainData) {
         return postRequest(mainData, "/api/users");
    }

    public ReadableResponse updateUser(JSONObject mainData, int userId) {
        return putRequest(mainData, "/api/users/" + userId);
    }

    public ReadableResponse deleteUserWithUserId(int userId) {
        return deleteRequest("/api/users/" + userId);
    }

    public ReadableResponse getUserWithUserIdDelayed(int userId) {
         return getRequest("/api/users/" + userId + "?delay=5");
    }
}
