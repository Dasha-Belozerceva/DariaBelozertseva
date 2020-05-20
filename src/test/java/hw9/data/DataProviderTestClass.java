package hw9.data;

import org.apache.commons.lang3.ArrayUtils;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import hw9.Dto.ErrorDto;
import hw9.service.RequestParamsValues;
import static hw9.data.TestData.*;
import static hw9.enums.ErrorCode.*;
import static hw9.enums.Languages.*;
import static hw9.service.SpellerConstants.*;

public class DataProviderTestClass {
    @DataProvider
    public Object[][] correctSentenceTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_EN_SENTENCE)
                                        .lang(EN.getLang()).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_RU_SENTENCE)
                                        .lang(RU.getLang()).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_UK_SENTENCE)
                                        .lang(UK.getLang()).build()
                        }
                };
    }

    @DataProvider
    public Object[][] correctSentenceTextsData() {
        return new Object[][]
                {
                    {
                            RequestParamsValues.builderMethod()
                                    .text(CORRECT_TEXTS1)
                                    .lang(EN_RU_UK.getLang()).build()
                    }
                    , {
                            RequestParamsValues.builderMethod()
                                    .text(CORRECT_TEXTS2)
                                    .lang(EN_RU.getLang()).build()
                    }
                    , {
                            RequestParamsValues.builderMethod()
                                    .text(CORRECT_TEXTS3)
                                    .lang(EN.getLang()).build()
                    }
                };
    }


    @DataProvider
    public Object[][] incorrectSentenceTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(INCORRECT_ENGLISH_SENTENCE)
                                        .lang(EN.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(CORRECT_VERSION_OF_ENGLISH_SENTENCE))
                                        .build()

                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(INCORRECT_RUSSIAN_SENTENCE)
                                        .lang(RU.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(CORRECT_VERSION_OF_RUSSIAN_SENTENCE))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(INCORRECT_UK_SENTENCE)
                                        .lang(UK.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(CORRECT_VERSION_OF_INCORRECT_UK_SENTENCE))
                                        .build()
                        }
                };
    }

    @DataProvider
    public Object[][] incorrectSentenceTextsData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(ArrayUtils.addAll(INCORRECT_ENGLISH_SENTENCE, INCORRECT_RUSSIAN_SENTENCE))
                                        .lang(EN_RU.getLang()).build()
                                , new ErrorDto[]
                                        {
                                                ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(CORRECT_VERSION_OF_ENGLISH_SENTENCE))
                                                        .build()
                                                , ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(CORRECT_VERSION_OF_RUSSIAN_SENTENCE))
                                                        .build()
                                        }

                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(INCORRECT_UK_SENTENCE)
                                        .lang(UK.getLang()).build()
                                , new ErrorDto[]
                                        {
                                                ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(CORRECT_VERSION_OF_INCORRECT_UK_SENTENCE))
                                                        .build()
                                        }
                        }
                };
    }

    @DataProvider
    public Object[][] wordsWithDigitsTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(EN_WORDS_WITH_DIGITS)
                                        .lang(EN.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(EN_WORDS_WITHOUT_DIGITS))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(RU_WORD_WITH_DIGITS)
                                        .lang(RU.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(RU_WORD_WITHOUT_DIGITS))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(UK_WORDS_WITH_DIGITS)
                                        .lang(UK.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(UK_WORDS_WITHOUT_DIGITS))
                                        .build()
                        }
                };
    }

    @DataProvider
    public Object[][] wordsWithDigitsTextsData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(ArrayUtils.addAll(EN_WORDS_WITH_DIGITS, RU_WORD_WITH_DIGITS))
                                        .lang(EN_RU.getLang()).build()
                                , new ErrorDto[]
                                        {
                                                ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(EN_WORDS_WITHOUT_DIGITS))
                                                        .build()
                                                , ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(RU_WORD_WITHOUT_DIGITS))
                                                        .build()
                                        }
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(UK_WORDS_WITH_DIGITS)
                                        .lang(UK.getLang()).build()
                                , new ErrorDto[]
                                        {
                                                ErrorDto.builderMethod()
                                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                                        .s(Collections.singletonList(UK_WORDS_WITHOUT_DIGITS))
                                                        .build()
                                        }
                        }
                };
    }

    @DataProvider
    public Object[][] ignoreWordsWithDigitsTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(RU_WORD_WITH_DIGITS)
                                        .lang(RU.getLang())
                                        .options(IGNORE_DIGITS).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(EN_WORDS_WITH_DIGITS)
                                        .lang(EN.getLang())
                                        .options(IGNORE_DIGITS).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(UK_WORDS_WITH_DIGITS)
                                        .lang(UK.getLang())
                                        .options(IGNORE_DIGITS).build()
                        }
                };
    }

    @DataProvider
    public Object[][] ignoreWordsWithDigitsTextsData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(ArrayUtils.addAll(RU_WORD_WITH_DIGITS, EN_WORDS_WITH_DIGITS))
                                        .lang(EN_RU.getLang())
                                        .options(IGNORE_DIGITS).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(UK_WORDS_WITH_DIGITS)
                                        .lang(UK.getLang())
                                        .options(IGNORE_DIGITS).build()
                        }
                };
    }

    @DataProvider
    public Object[][] fewLanguagesTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(FEW_LANGUAGES_CASE1)
                                        .build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(FEW_LANGUAGES_SEPARATED_CASE1))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(FEW_LANGUAGES_CASE2)
                                        .build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(FEW_LANGUAGES_SEPARATED_CASE2))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(FEW_LANGUAGES_CASE3)
                                        .build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(FEW_LANGUAGES_SEPARATED_CASE3))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(FEW_LANGUAGES_CASE4)
                                        .build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_UNKNOWN_WORD.getValue())
                                        .s(Collections.singletonList(FEW_LANGUAGES_SEPARATED_CASE4))
                                        .build()
                        }
                };
    }

    @DataProvider
    public Object[][] lightRepeatWordsTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(REPEAT_WORD_ENG)
                                        .lang(EN.getLang())
                                        .options(FIND_REPEAT_WORDS).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_REPEAT_WORD.getValue())
                                        .word(LIGHT_ENG_WORDS)
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(REPEAT_WORD_RU)
                                        .lang(RU.getLang())
                                        .options(FIND_REPEAT_WORDS).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_REPEAT_WORD.getValue())
                                        .word(LIGHT_RU_WORD)
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(REPEAT_WORD_UK)
                                        .lang(UK.getLang())
                                        .options(FIND_REPEAT_WORDS).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_REPEAT_WORD.getValue())
                                        .word(LIGHT_UK_WORD)
                                        .build()
                        }
                };
    }

    @DataProvider
    public Object[][] ignoreCapitalizationTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_RU)
                                        .lang(RU.getLang())
                                        .options(IGNORE_CAPITALIZATION).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_EN)
                                        .lang(EN.getLang())
                                        .options(IGNORE_CAPITALIZATION).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_UK)
                                        .lang(UK.getLang())
                                        .options(IGNORE_CAPITALIZATION).build()
                        }
                };
    }

    @DataProvider
    public Object[][] wrongCapitalizationTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_EN)
                                        .lang(EN.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_CAPITALIZATION.getValue())
                                        .s(new ArrayList<>(Arrays.asList(RIGHT_EN_CAPITALIZATION_WORDS)))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_RU)
                                        .lang(RU.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_CAPITALIZATION.getValue())
                                        .s(new ArrayList<>(Arrays.asList(RIGHT_RU_CAPITALIZATION_WORDS)))
                                        .build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(WRONG_CAPITALIZATION_UK)
                                        .lang(UK.getLang()).build()
                                , ErrorDto.builderMethod()
                                        .code(ERROR_CAPITALIZATION.getValue())
                                        .s(new ArrayList<>(Arrays.asList(RIGHT_UK_CAPITALIZATION_WORDS)))
                                        .build()
                        }
                };
    }

    @DataProvider
    public Object[][] ignoreURLTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(SENTENCE_WITH_URL_RU)
                                        .lang(RU.getLang())
                                        .options(IGNORE_URLS).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(SENTENCE_WITH_URL_EN)
                                        .lang(EN.getLang())
                                        .options(IGNORE_URLS).build()
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(SENTENCE_WITH_URL_UK)
                                        .lang(UK.getLang())
                                        .options(IGNORE_URLS).build()
                        }
                };
    }

    @DataProvider
    public Object[][] invalidLangTextData() {
        return new Object[][]
                {
                        {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_RU_SENTENCE)
                                        .lang(INVALID_LANG.getLang()).build()
                                , INVALID_LANG_EXPECTED_MESSAGE
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_EN_SENTENCE)
                                        .lang(INVALID_LANG.getLang()).build()
                                , INVALID_LANG_EXPECTED_MESSAGE
                        }
                        , {
                                RequestParamsValues.builderMethod()
                                        .text(CORRECT_UK_SENTENCE)
                                        .lang(INVALID_LANG.getLang()).build()
                                , INVALID_LANG_EXPECTED_MESSAGE
                        }
                };
    }
}