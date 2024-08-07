package com.HotelReservations.steps;

import com.HotelReservations.models.BookingResponse;
import com.HotelReservations.services.ReservationService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ReservationSteps {

    ReservationService reservationService;
    String authKey;
    BookingResponse bookingResponse;

    @Given("User creates a new reservation")
    public void beginnigOfTheCall(){
        reservationService = new ReservationService();
    }

    @Given("User gives necessary information for reservation")
    public void createAuth(){
        authKey = reservationService.generateToken();
    }

    @When("User creates the reservation")
    public void createReservation(){
        bookingResponse = reservationService.createBooking();
    }

    @Then("Reservation is created successfully")
    public void reservationAssertion(){
        Assertions.assertEquals("Udemy",bookingResponse.getBooking().getFirstname());
        Assertions.assertEquals("Cucumber",bookingResponse.getBooking().getLastname());
        Assertions.assertEquals(1000,bookingResponse.getBooking().getTotalprice());
        Assertions.assertEquals(false,bookingResponse.getBooking().isDepositpaid());
        Assertions.assertEquals("2023-04-01",bookingResponse.getBooking().getBookingdates().getCheckin());
        Assertions.assertEquals("2023-05-01",bookingResponse.getBooking().getBookingdates().getCheckout());
        Assertions.assertEquals("Permission for pet",bookingResponse.getBooking().getAdditionalneeds());
    }

    @Then("The user cancelled the reservation")
    public void cancelReservation(){
        reservationService.deleteReservation(authKey,bookingResponse.getBookingid());
    }
}
