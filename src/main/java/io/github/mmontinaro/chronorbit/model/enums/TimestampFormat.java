package io.github.mmontinaro.chronorbit.model.enums;

import io.github.mmontinaro.chronorbit.common.Constants;

public enum TimestampFormat {
    TIMESTAMP(Constants.TIMESTAMP_FORBIDDEN_DELIMS),
    CCSDS_ASCII_TIME_CODE_A(Constants.CCSDS_ASCII_TIME_CODE_A_FORBIDDEN_DELIMS);

    private final String forbiddenDelims;
    TimestampFormat(String forbiddenDelims) {
        this.forbiddenDelims = forbiddenDelims;
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

}
