package hw9.tests;

import hw9.Dto.ErrorDto;
import hw9.data.DataProviderTestClass;
import hw9.service.RequestParamsValues;
import hw9.service.RestSpellerService;
import hw9.service.SpellerAssertions;
import org.testng.annotations.Test;

public class RequestWithMistakesTests {
    private void checkCodeAndCorrectionForText(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        ErrorDto[] responses = RestSpellerService.INSTANCE.checkTextForGoodRequest(paramsValues);
        SpellerAssertions.INSTANCE
                .verifyCode(responses, expectedValues.getCode())
                .verifyCorrection(responses, expectedValues.getS().get(0));
    }

    private void checkCodeAndRepeatedWordForText(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        ErrorDto[] responses = RestSpellerService.INSTANCE.checkTextForGoodRequest(paramsValues);
        SpellerAssertions.INSTANCE
                .verifyCode(responses, expectedValues.getCode())
                .verifyErroredWord(responses, expectedValues.getWord());
    }

    private void checkCodeAndCorrectionForTexts(RequestParamsValues paramsValues, ErrorDto[] expectedValues) {
        ErrorDto[][] responses = RestSpellerService.INSTANCE.checkTexts(paramsValues);
        SpellerAssertions.INSTANCE.verifyResponseAndExpectedErrorsLengthsAreEqual(responses, expectedValues);
        for (int i = 0; i < expectedValues.length; ++i) {
            SpellerAssertions.INSTANCE
                    .verifyCode(responses[i], expectedValues[i].getCode())
                    .verifyCorrection(responses[i], expectedValues[i].getS().get(0));
        }
    }

    @Test(description = "Check sentence with some syntax errors", dataProviderClass = DataProviderTestClass.class, dataProvider = "incorrectSentenceTextData")
    public void checkIncorrectTextSentence(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        checkCodeAndCorrectionForText(paramsValues, expectedValues);
    }

    @Test(description = "Check sentence with no syntax errors in few texts", dataProviderClass = DataProviderTestClass.class, dataProvider = "incorrectSentenceTextsData")
    public void checkIncorrectTextsSentence(RequestParamsValues paramsValues, ErrorDto[] expectedValues) {
        checkCodeAndCorrectionForTexts(paramsValues, expectedValues);
    }

    @Test(description = "Check word with digit", dataProviderClass = DataProviderTestClass.class, dataProvider = "wordsWithDigitsTextData")
    public void checkTextWithDigits(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        checkCodeAndCorrectionForText(paramsValues, expectedValues);
    }

    @Test(description = "Check word with digit in texts", dataProviderClass = DataProviderTestClass.class, dataProvider = "wordsWithDigitsTextsData")
    public void checkTextsWithDigits(RequestParamsValues paramsValues, ErrorDto[] expectedValues) {
        checkCodeAndCorrectionForTexts(paramsValues, expectedValues);
    }

    @Test(description = "Check word with mixed two languages", dataProviderClass = DataProviderTestClass.class, dataProvider = "fewLanguagesTextData")
    public void checkFewLanguagesText(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        checkCodeAndCorrectionForText(paramsValues, expectedValues);
    }

    @Test(description = "Check word with lighted repeat words", dataProviderClass = DataProviderTestClass.class, dataProvider = "lightRepeatWordsTextData")
    public void checkRepeatedWordsInText(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        checkCodeAndRepeatedWordForText(paramsValues, expectedValues);
    }

    @Test(description = "Check word with wrong capitalization", dataProviderClass = DataProviderTestClass.class, dataProvider = "wrongCapitalizationTextData")
    public void checkWrongCapitalizationText(RequestParamsValues paramsValues, ErrorDto expectedValues) {
        checkCodeAndCorrectionForText(paramsValues, expectedValues);
    }
}
