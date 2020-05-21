package hw9.tests;

import hw9.data.DataProviderTestClass;
import hw9.service.RequestParamsValues;
import hw9.service.RestSpellerService;
import hw9.service.SpellerAssertions;
import org.testng.annotations.Test;

public class InvalidRequestTests {
    @Test(description = "Test with invalid language in request", dataProviderClass = DataProviderTestClass.class, dataProvider = "invalidLangTextData")
    public void checkInvalidLangRequest(RequestParamsValues paramsValues, String expectedBody) {
        String response = RestSpellerService.INSTANCE.checkTextForInvalidRequest(paramsValues);
        SpellerAssertions.INSTANCE
                .verifyInvalidRequestBody(response, expectedBody);
    }
}
