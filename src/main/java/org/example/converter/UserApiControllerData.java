package org.example.converter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.model.UserDTO;
import org.json.JSONObject;

import static java.lang.String.format;

public class UserApiControllerData {

    private static final Logger LOGGER = LogManager.getLogger(UserApiControllerData.class);
    public JSONObject prepareCreateUser(UserDTO user) {
        LOGGER.info(format("User dto created! Name: %s, Job: %s", user.getName(), user.getJob()));
        JSONObject jsonObject = new JSONObject();
        return jsonObject.put("name", user.getName())
                .put("job",user.getJob());
    }
}
