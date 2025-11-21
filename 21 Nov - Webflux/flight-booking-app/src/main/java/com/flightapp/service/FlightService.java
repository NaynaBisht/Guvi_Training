package com.flightapp.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.flightapp.entity.Flight;
import com.flightapp.repository.FlightRepository;
import com.flightapp.request.FlightSearchRequest;
import com.flightapp.response.FlightSearchResponse;
import com.flightapp.response.FlightSearchResponse.FlightInfo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightRepository flightRepository;

    public Mono<FlightSearchResponse> searchFlights(FlightSearchRequest request) {

        log.debug("Search request: {}", request);

        LocalDateTime startTime = request.getDepartDate().atStartOfDay();
        LocalDateTime endTime = request.getDepartDate().atTime(23, 59, 59);

        int passengerCount = request.getPassengers().getTotalPassengers();

        Flux<FlightInfo> results = flightRepository
                .findByDepartingAirportAndArrivalAirportAndDepartureTimeBetween(
                        request.getDepartingAirport(),
                        request.getArrivalAirport(),
                        startTime,
                        endTime)
                .filter(flight -> flight.getAvailableSeats() >= passengerCount)
                .map(this::toFlightInfo);

        return results.collectList()
                .map(list -> {
                    FlightSearchResponse response = new FlightSearchResponse();
                    response.setTotalFlights(list.size());
                    response.setFlights(list);
                    return response;
                });
    }

    private FlightInfo toFlightInfo(Flight flight) {
        FlightInfo info = new FlightInfo();
        info.setId(flight.getFlightNumber());
        info.setFlightNumber(flight.getFlightNumber());
        info.setAirlineName(flight.getAirlineName());
        info.setDepartingAirport(flight.getDepartingAirport());
        info.setArrivalAirport(flight.getArrivalAirport());
        info.setDepartureTime(flight.getDepartureTime().toString());
        info.setArrivalTime(flight.getArrivalTime().toString());
        long minutes = java.time.Duration.between(flight.getDepartureTime(), flight.getArrivalTime()).toMinutes();
        info.setDuration(minutes + " minutes");
        info.setPrice(flight.getPrice());
        info.setAvailableSeats(flight.getAvailableSeats());
        return info;
    }
}
