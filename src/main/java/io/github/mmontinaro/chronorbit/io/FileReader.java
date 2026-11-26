package io.github.mmontinaro.chronorbit.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import io.github.mmontinaro.chronorbit.cli.InputConfig;
import io.github.mmontinaro.chronorbit.common.Constants;
import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.model.enums.TimestampFormat;

public class FileReader {

    public static void checkPathExists(Path path) throws IOException{
        if(!Files.isRegularFile(path) || !Files.isReadable(path)){
            throw new IOException(path.toString());
        }
    }

    public static List<Interval> read(Path path, InputConfig config) throws IOException{
        try(Stream<String> lines = Files.lines(path)){
            if(config.timestampFormat() != TimestampFormat.TIMESTAMP){
                throw new UnsupportedOperationException("TODO");
            }
            return lines.map(line -> parseLine(line, config)).toList();
        }
    }

    private static Interval parseLine(String line, InputConfig config){
        String[] timestamps = line.split(Pattern.quote(config.delimiter()), -1);

        if(timestamps.length != 2){
            throw new IllegalArgumentException(Constants.INVALID_LINE_SKIPPING + line);
        }

        return new Interval(
            LocalTime.parse(timestamps[0]), // start
            LocalTime.parse(timestamps[1])  // end
        );
    }
}
