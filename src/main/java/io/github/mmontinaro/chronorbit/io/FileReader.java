package io.github.mmontinaro.chronorbit.io;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import io.github.mmontinaro.chronorbit.cli.InputConfig;
import io.github.mmontinaro.chronorbit.constants.Constants;
import io.github.mmontinaro.chronorbit.error.UnableToReadException;
import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.model.enums.TimestampFormat;

public class FileReader {

    public static void checkPathExists(Path path) throws IOException{
        if(!Files.isRegularFile(path) || !Files.isReadable(path)){
            throw new IOException(path.toString());
        }
    }

    public static <T extends Comparable<? super T>> List<Interval<T>> read(
        Path path, 
        InputConfig config,
        TimeCodec codec
    //TODO add the codec
    ) throws IOException{
        try(Stream<String> lines = Files.lines(path)){
            return readLines(lines, config, codec) lines.map(line -> parseLine(line, config)).toList();
        } catch(UncheckedIOException e){
            throw new UnableToReadException();
        }
    }

    private static Interval parseLine(String line, InputConfig config){
        String[] timestamps = line.split(Pattern.quote(config.delimiter()), -1);

        if(timestamps.length != 2){
            throw new IllegalArgumentException(Constants.INVALID_LINE_SKIPPING + line);
        }

        // TODO cannot remain local time, need to create a generic class that can handle everything, a dictionary or codex, OR a codec since it transforms and parses
        return new Interval<>(
            LocalTime.parse(timestamps[0]), // start
            LocalTime.parse(timestamps[1])  // end
        );
    }
}
