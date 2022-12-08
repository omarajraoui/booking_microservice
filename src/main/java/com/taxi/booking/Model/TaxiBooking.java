package com.taxi.booking.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TaxiBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    private Long taxiBookingId;
    private String start;
    private String end;
    private String endTime;
    private String bookedTime;
    private long customerId;
    private Date cancelTime;
    private String taxiId;
    private TaxiStatus taxiStatus;
    private TaxiBookingStatus taxiBookingStatus;






}
