package hw9.tests;

import hw9.Dto.ErrorDto;
import hw9.data.DataProviderTestClass;
import hw9.service.RequestParamsValues;
import hw9.service.RestSpellerService;
import hw9.service.SpellerAssertions;
import org.testng.annotations.Test;

public class CorrectRequestTests {
    private void checkTextCommon(RequestParamsValues paramsValues) {
        ErrorDto[] responses = RestSpellerService.INSTANCE.checkTextForGoodRequest(paramsValues);
        SpellerAssertions.INSTANCE
                .verifyBodyIsEmpty(responses);
    }

    private void checkTextsCommon(RequestParamsValues paramsValues) {
        ErrorDto[][] responsesArr = RestSpellerService.INSTANCE.checkTexts(paramsValues);
        SpellerAssertions.INSTANCE
                .verifyTextsBodyIsEmpty(responsesArr);
    }

    @Test(description = "Check sentence with no errors", dataProviderClass = DataProviderTestClass.class, dataProvider = "correctSentenceTextData")
    public void checkCorrectTextSentence(RequestParamsValues paramsValues) {
        checkTextCommon(paramsValues);
    }

    @Test(description = "Check sentence with no errors in few texts", dataProviderClass = DataProviderTestClass.class, dataProvider = "correctSentenceTextsData")
    public void checkCorrectTextsSentence(RequestParamsValues paramsValues) {
        checkTextsCommon(paramsValues);
    }

    @Test(description = "Check sentence with digits in words and option 'ignore digits'", dataProviderClass = DataProviderTestClass.class, dataProvider = "ignoreWordsWithDigitsTextData")
    public void checkWordsWithIgnoreDigitsOption(RequestParamsValues paramsValues) {
        checkTextCommon(paramsValues);
    }

    @Test(description = "Check few texts with digits in words and option 'ignore digits'", dataProviderClass = DataProviderTestClass.class, dataProvider = "ignoreWordsWithDigitsTextsData")
    public void checkTextsWithIgnoreDigitsOption(RequestParamsValues paramsValues) {
        checkTextsCommon(paramsValues);
    }

    @Test(description = "Check sentence with 'ignore capitalization' option", dataProviderClass = DataProviderTestClass.class, dataProvider = "ignoreCapitalizationTextData")
    public void checkSentenceWithIgnoreCapitalizationOption(RequestParamsValues paramsValues) {
        checkTextCommon(paramsValues);
    }

    @Test(description = "Check sentence with 'ignore URL' option", dataProviderClass = DataProviderTestClass.class, dataProvider = "ignoreURLTextData")
    public void checkSentenceWithIgnoreURLOption(RequestParamsValues paramsValues) {
        checkTextCommon(paramsValues);
    }
}
