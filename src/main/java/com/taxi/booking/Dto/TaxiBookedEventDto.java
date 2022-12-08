package com.taxi.booking.Dto;

import com.taxi.booking.Model.TaxiBookingStatus;
import com.taxi.booking.Model.TaxiStatus;

public class TaxiBookedEventDto {
    private Long taxiBookingId;
    private String start;
    private String end;

    private long customerId;
    private String bookedTime;

    private TaxiBookingStatus taxiBookingStatus;
    private TaxiStatus taxiStatus;

    public TaxiBookedEventDto(Long taxiBookingId, String start, String end, long customerId, String bookedTime, TaxiStatus taxiStatus, TaxiBookingStatus taxiBookingStatus) {
        this.taxiBookingId = taxiBookingId;
        this.start = start;
        this.end = end;
        this.customerId = customerId;
        this.bookedTime = bookedTime;
        this.taxiStatus = taxiStatus;
        this.taxiBookingStatus = taxiBookingStatus;
    }


    public Long getTaxiBookingId() {
        return taxiBookingId;
    }

    public void setTaxiBookingId(Long taxiBookingId) {
        this.taxiBookingId = taxiBookingId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getBookedTime() {
        return bookedTime;
    }

    public void setBookedTime(String bookedTime) {
        this.bookedTime = bookedTime;

    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }


    public TaxiBookingStatus getTaxiBookingStatus() {
        return taxiBookingStatus;
    }

    public void setTaxiBookingStatus(TaxiBookingStatus taxiStatus) {
        this.taxiBookingStatus = taxiBookingStatus;
    }


    public TaxiStatus getTaxiStatus() {
        return taxiStatus;
    }

    public void setTaxiStatus(TaxiStatus taxiStatus) {
        this.taxiStatus = taxiStatus;
    }
}
