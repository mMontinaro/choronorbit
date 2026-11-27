package io.github.mmontinaro.chronorbit.constants;

public final class CliConstants {
    public final static String INTERACTIVE_ARG = "--interactive";
        public final static String HELP_ARG = "--help";
        public final static String HELP_H_ARG = "--h";
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

        public static String HELP_STRING = """
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

            Usage:
            $ java -jar chronorbit.jar <input_file> [options]

            Args:
                <input_file>    - Path to satellite visibility file.

            Options:
                --interactive            - Opens progarm with interactive config menu.
                --help,-h,--HELP,--H     - Displays this help message and exit.

            Time formats:
            %s

            Default Time format:    TIMESTAMP
            Default delimiter:      Comma (,)
            """;
}
