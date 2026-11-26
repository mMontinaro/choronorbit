package io.github.mmontinaro.chronorbit.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalTime;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.model.Solution;

public class FormatterTest {
    private final static String CORRECT_STRING_START = "07:46:22.954";
    private final static LocalTime CORRECT_LOCAL_TIME_START = LocalTime.parse(CORRECT_STRING_START);
    
    private final static String CORRECT_STRING_END = "07:47:30.718";
    private final static LocalTime CORRECT_LOCAL_TIME_END = LocalTime.parse(CORRECT_STRING_END);
    Formatter formatter;
    Interval interval;
    
    @BeforeEach 
    public  void setup(){
        formatter = new Formatter();
    }

    @ParameterizedTest
    @MethodSource("solution")
    void shouldFormat(Solution solution) {
        String formatted = formatter.format(solution);
        String expected = "%s-%s;%d".formatted(CORRECT_STRING_START, CORRECT_STRING_END, 180);
        assertTrue(expected.equalsIgnoreCase(formatted));
    }

    @ParameterizedTest
    @MethodSource("notSolution")
    void shouldNotFormat(Solution notSolution) {
        // String f = formatter.format(notSolution);
        Assertions.assertThrows(Exception.class, () -> {
            formatter.format(notSolution);
        });
    }

    static Stream<Arguments> solution(){
        Interval interval = new Interval(CORRECT_LOCAL_TIME_START, CORRECT_LOCAL_TIME_END);
        return Stream.of(
            Arguments.of(new Solution(180, interval))
        );
    }
    static Stream<Arguments> notSolution(){
        Interval interval = new Interval(null, null);
        return Stream.of(
            Arguments.of(new Solution(180, interval))
        );
    }
}
