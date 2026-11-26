package io.github.mmontinaro.chronorbit.io;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.mmontinaro.chronorbit.model.Interval;

@Disabled ("not ready")
public class FileReaderTest {
/* 
    private final static String CORRECT_STRING_START = "07:46:22.954";
    private final static LocalTime CORRECT_LOCAL_TIME_START = LocalTime.parse(CORRECT_STRING_START);
    
    private final static String CORRECT_STRING_END = "07:47:30.718";
    private final static LocalTime CORRECT_LOCAL_TIME_END = LocalTime.parse(CORRECT_STRING_END);
    Interval interval;


    @TempDir 
    Path tempDir;

    @ParameterizedTest 
    @MethodSource ("interval")
    void testRead(Interval interval) throws IOException{
        Path p = createPathFile(CORRECT_STRING_START + "," + CORRECT_STRING_END);
        assertEquals(List.of(interval), FileReader.read(p));
    }
    
    
    @ParameterizedTest 
    @MethodSource ("interval")
    void testReadMultipleLines(Interval interval) throws IOException{
        Path p = createPathFile(
            """
            %s,%s
            %s,%s
            """.formatted(CORRECT_STRING_START, CORRECT_STRING_END, CORRECT_STRING_START, CORRECT_STRING_END));
        assertEquals(List.of(interval, interval), FileReader.read(p));
    }
            
    @ParameterizedTest 
    @MethodSource ("interval")
    void shouldThrowIllegalArgumentExceptionWrongSeparator(Interval interval) throws IOException{
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FileReader.read(createPathFile(CORRECT_STRING_START + "-" + CORRECT_STRING_END));
        });  
    }

    @ParameterizedTest 
    @MethodSource ("interval")
    void shouldThrowIllegalArgumentExceptionMoreCommas(Interval interval) throws IOException{
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            FileReader.read(createPathFile(CORRECT_STRING_START + "," + CORRECT_STRING_END + "," + CORRECT_STRING_END));
        });  
    }

    @Test 
    void testCheckPathExists() throws IOException{
        Path p = createPathFile("");
        assertDoesNotThrow(() -> FileReader.checkPathExists(p));
    }

    @Test 
    void shouldThrowCheckPathExistsFileNotExists() throws IOException{
        Path p = tempDir.resolve("fail.dat");

        assertThrows(IOException.class, () -> FileReader.checkPathExists(p));
    }

    @Test 
    void shouldThrowCheckPathExistsDirNotExists() throws IOException{
        assertThrows(IOException.class, () -> FileReader.checkPathExists(tempDir));
    }

    private Path createPathFile(String fileContent) throws IOException {
        return Files.writeString(tempDir.resolve("satellites.dat"), fileContent);
    }


    static Stream<Arguments> interval(){
        return Stream.of(
            Arguments.of(new Interval(CORRECT_LOCAL_TIME_START, CORRECT_LOCAL_TIME_END))
        );
    }
        */
}
