package io.github.mmontinaro.chronorbit.model;

public record Solution<T extends Comparable<? super T>>(Integer maxSatellites, Interval<T> interval) {}
