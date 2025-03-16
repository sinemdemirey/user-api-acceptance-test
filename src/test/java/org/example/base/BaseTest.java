package org.example.base;

import org.example.controller.UserApiController;
import org.example.converter.UserApiControllerData;

public class BaseTest {
    protected UserApiController userApiController = new UserApiController();
    protected UserApiControllerData userApiControllerData = new UserApiControllerData();
}
