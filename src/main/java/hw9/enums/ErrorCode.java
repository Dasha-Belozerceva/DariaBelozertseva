package hw9.enums;

import lombok.Getter;

public enum ErrorCode {
    ERROR_UNKNOWN_WORD(1),
    ERROR_REPEAT_WORD(2),
    ERROR_CAPITALIZATION(3);

    @Getter
    private int value;

    ErrorCode(int i) {
        this.value = i;
    }


}
