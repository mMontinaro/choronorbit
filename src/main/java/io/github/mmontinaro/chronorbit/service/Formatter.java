package io.github.mmontinaro.chronorbit.service;

import java.time.format.DateTimeFormatter;

import io.github.mmontinaro.chronorbit.constants.TimeConstants;
import io.github.mmontinaro.chronorbit.model.Solution;

public class Formatter {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(TimeConstants.FormatPattern.TIMESTAMP);

    public String format(Solution solution){
        return "%s-%s;%d".formatted(
            solution.interval().start().format(FORMATTER),
            solution.interval().end().format(FORMATTER),
            solution.maxSatellites()
        );
    }
}
