package io.github.mmontinaro.chronorbit.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import io.github.mmontinaro.chronorbit.common.Constants;
import io.github.mmontinaro.chronorbit.model.Interval;

public class FileReader {
    public static List<Interval> read(Path path) throws IOException{
        try(Stream<String> lines = Files.lines(path)){
            return lines.map(FileReader::parseLine).toList();
        }
    }

    private static Interval parseLine(String line){
        String[] timestamps = line.split(",", -1);

        if(timestamps.length != 2){
            throw new IllegalArgumentException(Constants.INVALID_LINE_SKIPPING + line);
        }

        return new Interval(
            LocalTime.parse(timestamps[0]), // start
            LocalTime.parse(timestamps[1])  // end
        );
    }
}
