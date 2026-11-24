package io.github.mmontinaro.chronorbit.model;

import java.time.LocalTime;

public record Solution(Integer maxSatellites, LocalTime startTimeRange, LocalTime endTimeRange) {}
