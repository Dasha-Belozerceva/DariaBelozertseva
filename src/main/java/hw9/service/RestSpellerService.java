package hw9.service;

import com.google.gson.Gson;
import hw9.Dto.ErrorDto;
import hw9.utils.PropertiesDataInitializer;
import java.util.*;

public enum RestSpellerService {
    INSTANCE;

    public static final String TEXT_PARAM = "text";
    public static final String LANG_PARAM = "lang";
    public static final String OPTIONS_PARAM = "options";


    private String checkCommon(RequestParamsValues values, boolean forText) {
        Map<String, Object> optionalParams = new HashMap<String, Object>();
        if (values.getLang() != null) {
            optionalParams.put(LANG_PARAM, values.getLang());
        }
        if (values.getOptions() != null) {
            optionalParams.put(OPTIONS_PARAM, values.getOptions());
        }

        String endpoint = forText ? PropertiesDataInitializer.getCheckTextMethod() :
                PropertiesDataInitializer.getCheckTextsMethod();
        return new BaseRestService()
                .getWithParams(endpoint, values.getText(), optionalParams)
                .getBody().asString();
    }

    public String checkTextForInvalidRequest(RequestParamsValues values) {
        return checkCommon(values, true);
    }

    public ErrorDto[] checkTextForGoodRequest(RequestParamsValues values) {
        return new Gson().fromJson(
                checkCommon(values, true), ErrorDto[].class);
    }

    public ErrorDto[][] checkTexts(RequestParamsValues values) {
        return new Gson().fromJson(
                checkCommon(values, false), ErrorDto[][].class);
    }
}
