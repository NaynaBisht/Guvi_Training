package com.flightapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flightapp.request.FlightSearchRequest;
import com.flightapp.response.FlightSearchResponse;
import com.flightapp.service.FlightService;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1.0/flight")
@RequiredArgsConstructor
public class FlightSearchController {

    private final FlightService flightService;

    @PostMapping("/search")
    public Mono<ResponseEntity<FlightSearchResponse>> searchFlights(
            @RequestBody Mono<FlightSearchRequest> requestMono) {

        return requestMono
                .flatMap(flightService::searchFlights)
                .map(response -> ResponseEntity.ok(response));
    }
}
