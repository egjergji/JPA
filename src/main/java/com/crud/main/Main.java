package com.crud.main;

import com.crud.model.dto.BookingDTO;
import com.crud.model.dto.FlightDTO;
import com.crud.model.dto.UserDTO;
import com.crud.model.dto.UserDetailsDTO;
import com.crud.service.BookingService;
import com.crud.service.FlightService;
import com.crud.service.UserService;
import com.crud.service.impl.BookingServiceImpl;
import com.crud.service.impl.FlightServiceImpl;
import com.crud.service.impl.UserServiceImpl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Initialize services
        UserService userService = new UserServiceImpl();
        FlightService flightService = new FlightServiceImpl();
        BookingService bookingService = new BookingServiceImpl();

        // **USER OPERATIONS**

        // Create a new UserDTO
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername("jane_doe");
        userDTO.setRole("USER"); // Using a String instead of an enum

        // Create UserDetailsDTO and set it to UserDTO
        UserDetailsDTO userDetailsDTO = new UserDetailsDTO();
        userDetailsDTO.setFirstName("Jane");
        userDetailsDTO.setLastName("Doe");
        userDetailsDTO.setEmail("jane.doe@example.com");
        userDetailsDTO.setPhoneNumber("5551234567");
        userDTO.setUserDetails(userDetailsDTO);

        // Save the user
        userService.saveUser(userDTO);

        // Retrieve all users
        List<UserDTO> allUsers = userService.loadAllUsers();
        System.out.println("All users:");
        allUsers.forEach(System.out::println);

        // Find a user by username
        UserDTO foundUser = userService.findByUsername("jane_doe");
        System.out.println("Found user:");
        System.out.println(foundUser);

        // **FLIGHT OPERATIONS**

        // Create a new FlightDTO
        FlightDTO flightDTO = new FlightDTO();
        flightDTO.setOrigin("New York");
        flightDTO.setDestination("Los Angeles");
        flightDTO.setAirline("Airways");
        flightDTO.setFlightNumber("NYC-LAX-100");
        flightDTO.setDepartureDate(LocalDateTime.of(2023, 12, 1, 9, 30).toString());
        flightDTO.setArrivalDate(LocalDateTime.of(2023, 12, 1, 12, 45).toString());
        flightDTO.setStatus("Scheduled"); // Using a String instead of an enum

        // Save the flight
        flightService.saveFlight(flightDTO);

        // Retrieve all flights
        List<FlightDTO> allFlights = flightService.loadAllFlights();
        System.out.println("All flights:");
        allFlights.forEach(System.out::println);

        // Find a flight by flight number
        FlightDTO foundFlight = flightService.findByFlightNumber("NYC-LAX-100");
        System.out.println("Found flight:");
        System.out.println(foundFlight);

        // **BOOKING OPERATIONS**

        // Create a new BookingDTO
        BookingDTO bookingDTO = new BookingDTO();
        bookingDTO.setBookingDate(LocalDate.now());
        bookingDTO.setStatus("Confirmed"); // Using a String instead of an enum
        bookingDTO.setUser(foundUser);
        bookingDTO.setFlight(foundFlight);

        // Save the booking
        bookingService.saveBooking(bookingDTO);

        // Retrieve all bookings
        List<BookingDTO> allBookings = bookingService.loadAllBookings();
        System.out.println("All bookings:");
        allBookings.forEach(System.out::println);

        // Find bookings by user ID
        Long userId = foundUser.getId();
        List<BookingDTO> userBookings = bookingService.findBookingsByUserId(userId);
        System.out.println("Bookings for user ID " + userId + ":");
        userBookings.forEach(System.out::println);

     
    }
}
