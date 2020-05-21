package hw9.service;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderMethodName = "builderMethod")
public class RequestParamsValues {
    private String[] text;
    private String lang;
    private Integer options;
}
