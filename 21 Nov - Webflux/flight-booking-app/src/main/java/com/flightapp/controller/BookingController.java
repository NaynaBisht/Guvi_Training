package com.flightapp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.flightapp.entity.Booking;
import com.flightapp.request.BookingRequest;
import com.flightapp.response.BookingResponse;
import com.flightapp.service.BookingService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("api/v1.0/flight")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/ticket/{pnr}")
    public Mono<ResponseEntity<Booking>> getTicketDetailsByPnr(@PathVariable String pnr) {
        log.info("Fetching ticket details for PNR={}", pnr);

        return bookingService.getBookingByPnr(pnr)
                .map(response -> ResponseEntity.ok(response));
    }

    @GetMapping("/booking/history/{emailId}")
    public Flux<Booking> getBookingHistory(@PathVariable String emailId) {
        log.info("Fetching booking history for emailId={}", emailId);

        return bookingService.getBookingHistoryByEmailId(emailId);
    }

    @PostMapping("/booking/{flightNumber}")
    public Mono<ResponseEntity<BookingResponse>> bookFlight(
            @PathVariable String flightNumber, 
            @RequestBody Mono<BookingRequest> request) {

    	return request
                .flatMap(req -> bookingService.bookFlight(flightNumber, req))
                .map(response -> ResponseEntity.ok(response));
    }	

    @DeleteMapping("/booking/cancel/{pnr}")
    public Mono<ResponseEntity<String>> cancelBooking(@PathVariable String pnr) {
        log.warn("Cancel request received for PNR={}", pnr);

        return bookingService.cancelBooking(pnr)
        		.then(Mono.just(ResponseEntity.noContent().build()));
    }
}
