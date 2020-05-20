package hw9.service;

import hw9.utils.PropertiesDataInitializer;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.Map;
import static hw9.service.RestSpellerService.TEXT_PARAM;
import static io.restassured.RestAssured.given;

public class BaseRestService {
    private RequestSpecification REQUEST_SPECIFICATION;

    public BaseRestService() {
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        REQUEST_SPECIFICATION = new RequestSpecBuilder()
                .setBaseUri(PropertiesDataInitializer.getDomain())
                .addFilter(new RequestLoggingFilter())
                .addFilter(new ResponseLoggingFilter())
                .build();
    }

    public Response getWithParams(String uri, String[] text, Map<String, Object> optionalParams) {
        RequestSpecification specification = given(REQUEST_SPECIFICATION);
        for (String el : text) {
            specification.param(TEXT_PARAM, el);
        }
        for (Map.Entry<String, Object> param : optionalParams.entrySet())
            specification.param(param.getKey(), param.getValue());

        return specification.get(uri);
    }
}
