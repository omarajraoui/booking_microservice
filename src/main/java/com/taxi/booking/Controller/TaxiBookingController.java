package com.taxi.booking.Controller;

import com.taxi.booking.Dto.TaxiBookedEventDto;
import com.taxi.booking.Model.TaxiBooking;
import com.taxi.booking.Model.TaxiBookingStatus;
import com.taxi.booking.Model.TaxiStatus;
import com.taxi.booking.Service.TaxiBookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RequestMapping("/taxiBooking")
@RestController
public class TaxiBookingController {

    private final TaxiBookingService taxiBookingService;


    public TaxiBookingController(TaxiBookingService taxiBookingService) {
        this.taxiBookingService = taxiBookingService;
    }


//
//    ResponseEntity<List<User>>getUsers() {
//        return ResponseEntity.ok().body(userService.getUsers());

    @PostMapping
    @Transactional
    public ResponseEntity<?> book(@RequestBody TaxiBookedEventDto taxiBookedEventDto){
        TaxiBooking taxiBooked = taxiBookingService.book(taxiBookedEventDto);
        //need to communicate to the other taxi service to know if its booked
        taxiBooked.setTaxiBookingStatus(TaxiBookingStatus.Accepted);
        taxiBooked.setTaxiStatus(TaxiStatus.OCCUPIED); //should get it from the other service
        if (taxiBooked.getTaxiStatus() == TaxiStatus.OCCUPIED || taxiBooked.getTaxiStatus() == TaxiStatus.BROKEN )
        {
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Taxi not available at the moment");
        }
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(new TaxiBookedEventDto(taxiBooked.getTaxiBookingId(),taxiBooked.getStart(),taxiBooked.getEnd(),taxiBooked.getCustomerId(),taxiBooked.getBookedTime(),taxiBooked.getTaxiStatus(),taxiBooked.getTaxiBookingStatus()));


    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable Long id) {
        boolean deleted = false;
        deleted = taxiBookingService.cancel(id);
        Map<String,Boolean> response = new HashMap<>();
        response.put("deleted", deleted);
        return ResponseEntity.ok(response);
    }






}
