package io.github.mmontinaro.chronorbit.service;

import java.time.format.DateTimeFormatter;

import io.github.mmontinaro.chronorbit.common.Constants;
import io.github.mmontinaro.chronorbit.model.Solution;

public class Formatter {
    private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(Constants.TIMESTAMP_FORMAT);

    public String format(Solution solution){
        return "%s-%s;%d".formatted(
            solution.interval().start().format(FORMATTER),
            solution.interval().end().format(FORMATTER),
            solution.maxSatellites()
        );
    }
}
