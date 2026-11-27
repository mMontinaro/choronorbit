package io.github.mmontinaro.chronorbit.cli;

import io.github.mmontinaro.chronorbit.constants.TimeConstants;
import io.github.mmontinaro.chronorbit.model.enums.TimestampFormat;

public record InputConfig(TimestampFormat timestampFormat, String delimiter) {

    public InputConfig{
        if(!timestampFormat.isValidDelim(delimiter)){
            throw new IllegalArgumentException(TimeConstants.ForbiddenDelims.INVALID_DELIMITER);
        }
    }

    public static InputConfig defaultConfig(){
        return new InputConfig(TimestampFormat.TIMESTAMP, ",");
    }
}
