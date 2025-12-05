package com.app.booking;

public class TicketBooking {

    public static void main(String[] args) {
        System.out.println("Welcome to Ticket Booking System");

        Ticket ticket = new Ticket();
        ticket.showTicketDetails();

        System.out.println("Booking Confirmed!");
    }
}