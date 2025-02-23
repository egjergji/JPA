package com.crud.model.dto;

import java.time.LocalDate;

public class BookingDTO {

    private Long id;
    private LocalDate bookingDate;
    private String status;
    private UserDTO user;
    private FlightDTO flight;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getBookingDate() { return bookingDate; }
    public void setBookingDate(LocalDate bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public UserDTO getUser() { return user; }
    public void setUser(UserDTO user) { this.user = user; }

    public FlightDTO getFlight() { return flight; }
    public void setFlight(FlightDTO flight) { this.flight = flight; }

    @Override
    public String toString() {
        return "BookingDTO{" +
                "id=" + id +
                ", bookingDate=" + bookingDate +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", flight=" + flight +
                '}';
    }
}
