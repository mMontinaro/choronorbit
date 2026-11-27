package io.github.mmontinaro.chronorbit.model.enums;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import io.github.mmontinaro.chronorbit.constants.TimeConstants;
import io.github.mmontinaro.chronorbit.io.TimeCodec;

public enum TimestampFormat {
    TIMESTAMP(
        TimeConstants.FormatDenomination.TIMESTAMP,
        TimeConstants.FormatPattern.TIMESTAMP,
        TimeConstants.ForbiddenDelims.TIMESTAMP,
        new TimeCodec<>(
            LocalTime::parse,
            (LocalTime time) -> 
                time.format(DateTimeFormatter.ofPattern(TimeConstants.FormatPattern.TIMESTAMP))
        )
    ),
    CCSDS_ASCII_TIME_CODE_A(
        TimeConstants.FormatDenomination.CCSDS_ASCII_TIME_CODE_A,
        TimeConstants.FormatPattern.CCSDS_ASCII_TIME_CODE_A,
        TimeConstants.ForbiddenDelims.CCSDS_ASCII_TIME_CODE_A,
        new TimeCodec<>(
            value -> LocalDateTime.parse(
                value, DateTimeFormatter.ISO_DATE_TIME
            ),
            (LocalDateTime time) -> 
                time.format(DateTimeFormatter.ofPattern(TimeConstants.FormatPattern.CCSDS_ASCII_TIME_CODE_A))
        )
    );

    private final String format;
    private final String pattern;
    private final String forbiddenDelims;
    TimestampFormat(String format, String structure, String forbiddenDelims) {
        this.format = format;
        this.pattern = structure;
        this.forbiddenDelims = forbiddenDelims;
    }

    public String getFormat(){
        return format;
    }

    public String getPattern(){
        return pattern;
    }

    public String getForbiddenDelims() {
        return forbiddenDelims;
    }

    public boolean isValidDelim(String delim){
        return delim != null 
            && delim.length() == 1
            && !forbiddenDelims.contains(delim)
            && !delim.equals("\n")
            && !delim.equals("\r");
    }

    public static TimestampFormat getDefault(){
        return TIMESTAMP;
    }

}
