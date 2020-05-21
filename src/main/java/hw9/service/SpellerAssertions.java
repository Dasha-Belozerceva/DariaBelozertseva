package hw9.service;

import hw9.Dto.ErrorDto;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

public enum SpellerAssertions {
    INSTANCE;

    public SpellerAssertions verifyBodyIsEmpty(ErrorDto[] responses) {
        assertThat(responses).isEmpty();
        return this;
    }

    public SpellerAssertions verifyTextsBodyIsEmpty(ErrorDto[][] responsesArr) {
        Arrays.stream(responsesArr)
                .forEach(response -> assertThat(response)
                        .isEmpty());
        return this;
    }

    public SpellerAssertions verifyInvalidRequestBody(String invalidResponse, String expectedBody) {
        assertThat(invalidResponse)
                .isEqualTo(expectedBody);
        return this;
    }

    public SpellerAssertions verifyCode(ErrorDto[] responses, int expectedCode) {
        assertThat(responses[0].getCode())
                .isEqualTo(expectedCode);
        return this;
    }

    public SpellerAssertions verifyCorrection(ErrorDto[] responses, String expectedS) {
        assertThat(responses[0].getS())
                .contains(expectedS);
        return this;
    }

    public SpellerAssertions verifyErroredWord(ErrorDto[] responses, String expectedWord) {
        assertThat(responses[0].getWord())
                .isEqualTo(expectedWord);
        return this;
    }

    public SpellerAssertions verifyResponseAndExpectedErrorsLengthsAreEqual(ErrorDto[][] responsesArr, ErrorDto[] expectedBody) {
        assertThat(responsesArr.length == expectedBody.length).isTrue();
        return this;
    }
}
