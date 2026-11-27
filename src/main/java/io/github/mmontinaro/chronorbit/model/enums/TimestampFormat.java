package io.github.mmontinaro.chronorbit.model.enums;

import io.github.mmontinaro.chronorbit.constants.TimeConstants;

public enum TimestampFormat {
    TIMESTAMP(
        TimeConstants.FormatDenomination.TIMESTAMP,
        TimeConstants.FormatPattern.TIMESTAMP,
        TimeConstants.ForbiddenDelims.TIMESTAMP
    ),
    CCSDS_ASCII_TIME_CODE_A(
        TimeConstants.FormatDenomination.CCSDS_ASCII_TIME_CODE_A,
        TimeConstants.FormatPattern.CCSDS_ASCII_TIME_CODE_A,
        TimeConstants.ForbiddenDelims.CCSDS_ASCII_TIME_CODE_A
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
