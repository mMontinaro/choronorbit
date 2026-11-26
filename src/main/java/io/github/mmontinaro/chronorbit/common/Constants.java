package io.github.mmontinaro.chronorbit.common;

public final class Constants {
    public final static String ARG_NUM_INVALID = "Usage: chronorbit <input_file>";
    public final static String INVALID_FILE_PATH = "Invalid File Path.";
    public final static String COULD_NOT_RETRIEVE_FILE = "Could not retrieve file: ";
    public final static String INVALID_TIME_FORMAT = "Invalid Time Format";
    public final static String INVALID_LINE_SKIPPING = "Invalid interval where line contains: ";
    public final static String LOADED_FILE = "Loaded file: ";
    public final static String RECORDS_LOADED = "Records loaded.";
    public final static String TIMESTAMP_FORMAT = "HH:mm:ss.SSS";
    public final static String TIMESTAMP_FORBIDDEN_DELIMS = "0123456789:.";
    public final static String CCSDS_ASCII_TIME_CODE_A_FORBIDDEN_DELIMS = "0123456789:.-TZ";
    public final static String INVALID_DELIMITER = "Invalid Delimiter";
    
    public final static class Cli{
        public final static String ENTER_SELECTION = "Enter Selection => ";
        public final static String INVALID_SELECTION = "Invalid Selection. Try again.";
        public final static String ENTER_DELIM = "Enter Delimiter of choice (default: ',') => ";
        public final static String INVALID_DELIM = "Forbidden Delimiter. Delimiter cannot be part of selected Time Format";

        public final static String INIT_STRING = """
            =============================
                    CHORONORBIT
            =============================
            An app that finds the time 
            ranges when the maximum 
            number of satellites are 
            visible to the ground 
            station and how many 
            satellites there are 
            during those time ranges
            =============================
            """;

        public final static String SELECT_TIME_FORMAT = """
            Select one of the following timestamp formats:

            [1] Timestamp (HH:mm:ss.SSS) (default)
            [2] CCSDS ASCII Time Code A (YYYY-MM-DDThh:mm:ss.d→dZ)
            """;


    }
}
