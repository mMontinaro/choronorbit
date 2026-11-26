package io.github.mmontinaro.chronorbit.model;

import java.time.LocalTime;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class IntervalTest {
    private final static String CORRECT_STRING_START = "07:46:22.954";
    private final static LocalTime CORRECT_LOCAL_TIME_START = LocalTime.parse(CORRECT_STRING_START);
    
    private final static String CORRECT_STRING_END = "07:47:30.718";
    private final static LocalTime CORRECT_LOCAL_TIME_END = LocalTime.parse(CORRECT_STRING_END);
    
    Interval i;
    
    @BeforeEach 
    public  void setup(){
        i = new Interval(CORRECT_LOCAL_TIME_START, CORRECT_LOCAL_TIME_END);

    }

    @Test
    void testEnd() {
        Assertions.assertFalse(i.start() == null);
        Assertions.assertFalse(i.end() == null);
    }

    @Test
    void testStart() {
        Interval i = new Interval(CORRECT_LOCAL_TIME_START, CORRECT_LOCAL_TIME_END);
        Assertions.assertFalse(i.start() == null);
        Assertions.assertFalse(i.end() == null);
    }
}
