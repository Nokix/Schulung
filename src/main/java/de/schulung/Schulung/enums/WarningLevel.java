package de.schulung.Schulung.enums;

import java.awt.*;
import java.util.Arrays;

public enum WarningLevel {
    ERROR(3, Color.RED),
    DEBUG(2, Color.RED),
    INFO(1, Color.BLUE);

    private Integer code;
    private Color color;

    WarningLevel(Integer code, Color color) {
        this.code = code;
        this.color = color;
    }

    public Integer getCode() {
        return code;
    }

    public static WarningLevel getByCode(int code) {
        return Arrays.stream(values())
                .filter(warningLevel -> warningLevel.getCode() == code)
                .findFirst()
                .orElseThrow();
    }
}
