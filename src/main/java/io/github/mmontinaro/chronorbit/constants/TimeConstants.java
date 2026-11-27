package io.github.mmontinaro.chronorbit.constants;

public final class TimeConstants {
    public final class FormatDenomination{
        public final static String TIMESTAMP = "TIMESTAMP";
        public final static String CCSDS_ASCII_TIME_CODE_A = "CCSDS ASCII Time Code A";
    }
    
    public final class FormatPattern {
        public final static String TIMESTAMP = "HH:mm:ss.SSS";
        public final static String CCSDS_ASCII_TIME_CODE_A = "YYYY-MM-DDThh:mm:ss.d→dZ";
    }

    public final class ForbiddenDelims{
        public final static String INVALID_DELIMITER = "Invalid Delimiter";
        public final static String TIMESTAMP = "0123456789:.";
        public final static String CCSDS_ASCII_TIME_CODE_A = "0123456789:.-TZ";
    }
}
