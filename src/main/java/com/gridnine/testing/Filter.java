package com.gridnine.testing;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

public class Filter {

    public static List<Flight> doFilterByDepartureDateIsCorrect (List<Flight> flights) {
        return flights.stream()
                .filter(Filter::isFlightDepartureDateCorrect)
                .toList();

    }

    private static boolean isFlightDepartureDateCorrect (Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream()
                .map(segment -> segment.getDepartureDate()
                        .isAfter(LocalDateTime.now()))
                .allMatch(Predicate.isEqual(Boolean.TRUE));
    }

    public static List<Flight> doFilterByArrivalDateIsCorrect (List<Flight> flights) {
        return flights.stream()
                .filter(Filter::isFlightArrivalDateCorrect)
                .toList();

    }

    private static boolean isFlightArrivalDateCorrect (Flight flight) {
        List<Segment> segments = flight.getSegments();
        return segments.stream()
                .map(segment -> segment.getArrivalDate()
                        .isAfter(segment.getDepartureDate()))
                .allMatch(Predicate.isEqual(Boolean.TRUE));
    }

    public static List<Flight> doFilterByWaitingTimeMoreThan2Hours (List<Flight> flights) {
        return flights.stream()
                .filter(Filter::isFlightWaitingTimeLessThan2Hours)
                .toList();

    }

    private static boolean isFlightWaitingTimeLessThan2Hours (Flight flight) {
        List<Segment> segments = flight.getSegments();
        if (segments.size() <= 1) {
            return true;
        }
        int hoursToWait = 0;
        for (int i = 0; i < (segments.size() - 1);) {
            Duration hours = Duration.between(segments.get(i).getArrivalDate(), segments.get(++i).getDepartureDate());
            hoursToWait += hours.toHoursPart();
        }
        return hoursToWait <= 2;
    }
}
