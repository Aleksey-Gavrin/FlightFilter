package com.gridnine.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class FilterTests {

    List<Flight> testFlights;

    @BeforeEach
    void init() {
        testFlights = FlightBuilder.createFlights();
    }

    @Test
    void doFilterByDepartureDateIsCorrectTest() {
        List<Flight> filteredFlights = Filter.doFilterByDepartureDateIsCorrect(testFlights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void doFilterByArrivalDateIsCorrectTest() {
        List<Flight> filteredFlights = Filter.doFilterByArrivalDateIsCorrect(testFlights);
        Assertions.assertEquals(5, filteredFlights.size());
    }

    @Test
    void doFilterByWaitingTimeMoreThan2HoursTest() {
        List<Flight> filteredFlights = Filter.doFilterByWaitingTimeMoreThan2Hours(testFlights);
        Assertions.assertEquals(4, filteredFlights.size());
    }
}
