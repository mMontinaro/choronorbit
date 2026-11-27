package io.github.mmontinaro.chronorbit.model;


public record Interval<T extends Comparable<? super T>>(T start, T end) {
}
