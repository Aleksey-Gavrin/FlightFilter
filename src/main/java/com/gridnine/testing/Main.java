package com.gridnine.testing;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("Initial list of flights");
        List<Flight> testFlights = FlightBuilder.createFlights();
        System.out.println(testFlights);
        System.out.println("--------------------------------------------------");
        System.out.println("List of flights filtered with condition: departure date is in past");
        List<Flight> testFlightsFiltered1 = Filter.doFilterByDepartureDateIsCorrect(testFlights);
        System.out.println(testFlightsFiltered1);
        System.out.println("--------------------------------------------------");
        System.out.println("List of flights filtered with condition: arrival date is earlier than departure date");
        List<Flight> testFlightsFiltered2 = Filter.doFilterByArrivalDateIsCorrect(testFlights);
        System.out.println(testFlightsFiltered2);
        System.out.println("--------------------------------------------------");
        System.out.println("List of flights filtered with condition: waiting time during the flight is over 2 hours");
        List<Flight> testFlightsFiltered3 = Filter.doFilterByWaitingTimeMoreThan2Hours(testFlights);
        System.out.println(testFlightsFiltered3);
    }
}