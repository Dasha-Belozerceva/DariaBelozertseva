package hw9.Dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder(builderMethodName = "builderMethod")
public class ErrorDto {
    private int code;
    private int pos;
    private int row;
    private int col;
    private int len;
    private String word;
    private List<String> s;
}
