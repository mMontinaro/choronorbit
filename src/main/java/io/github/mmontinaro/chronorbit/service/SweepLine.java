package io.github.mmontinaro.chronorbit.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import io.github.mmontinaro.chronorbit.model.Interval;
import io.github.mmontinaro.chronorbit.model.Solution;

public class SweepLine {
    public List<Solution> sweepLine(List<Interval> intervals) {
        List<Solution> solutions = new ArrayList<>();

        List<LocalTime> start = intervals
                .stream()
                .map(i -> i.start())
                .sorted()
                .toList();

        List<LocalTime> end = intervals
                .stream()
                .map(i -> i.end())
                .sorted()
                .toList();

        int sPointer = 0;
        int ePointer = 0;
        int count = 0;
        int max = 0;
        LocalTime startRange = null;

        while (sPointer < start.size() && ePointer < end.size()) {
            if (!start.get(sPointer).isAfter(end.get(ePointer))) {
                ++count;
                LocalTime sValue = start.get(sPointer++);
                if (count > max) {
                    max = count;
                    solutions.clear();
                    startRange = sValue;
                } else if (count == max) {
                    startRange = sValue;
                }

            } else {
                if(count == max){
                    solutions.add(new Solution(max, new Interval(startRange, end.get(ePointer))));
                    startRange = null;
                }
                ++ePointer;
                --count;
            }

        }

        return solutions;
    }
}
