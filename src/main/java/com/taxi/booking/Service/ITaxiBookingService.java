package com.taxi.booking.Service;

import com.taxi.booking.Dto.TaxiBookingAcceptedEventDTO;
import com.taxi.booking.Dto.TaxiBookingCanceledEventDTO;
import com.taxi.booking.Model.TaxiBooking;
import com.taxi.booking.Dto.TaxiBookedEventDto;
import com.taxi.booking.Model.TaxiBookingStatus;
import com.taxi.booking.Model.TaxiLocation;

public interface ITaxiBookingService {
    public TaxiBooking book(TaxiBookedEventDto taxiBookedEventDto);
    public boolean cancel(Long taxiBookingId);// TaxiBookingCanceledEventDTO canceledEventDTO);
    public TaxiBooking accept(String taxiBookingId,
                              TaxiBookingAcceptedEventDTO acceptedEventDTO);
    public TaxiLocation getBookings( Double latitude, Double longitude,
                                     Double radius);

    public TaxiBooking updateBookingStatus(String taxiBookingId,
                               TaxiBookingStatus taxiBookingStatus);

}
