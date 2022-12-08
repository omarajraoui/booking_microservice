package com.taxi.booking.Service;

import com.taxi.booking.Dto.TaxiBookedEventDto;
import com.taxi.booking.Dto.TaxiBookingAcceptedEventDTO;
import com.taxi.booking.Dto.TaxiBookingCanceledEventDTO;
import com.taxi.booking.Model.TaxiBooking;
import com.taxi.booking.Model.TaxiBookingStatus;
import com.taxi.booking.Model.TaxiLocation;
import com.taxi.booking.Repository.TaxiBookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaxiBookingService implements ITaxiBookingService {
    private final TaxiBookingRepository taxiBookingRepository;
//    private final TaxiService taxiService;

    public TaxiBookingService(TaxiBookingRepository taxiBookingRepository) {
        this.taxiBookingRepository = taxiBookingRepository;
    }

    @Override
    public TaxiBooking book(TaxiBookedEventDto taxiBookedEventDto) {
        TaxiBooking taxiBooking = new TaxiBooking();
        taxiBooking.setEnd(taxiBookedEventDto.getEnd());
        taxiBooking.setStart(taxiBookedEventDto.getStart());
        taxiBooking.setBookedTime(taxiBookedEventDto.getBookedTime());
        taxiBooking.setCustomerId(taxiBookedEventDto.getCustomerId());
        taxiBooking.setTaxiBookingStatus(taxiBookedEventDto.getTaxiBookingStatus());

        TaxiBooking savedTaxiBooking =
                taxiBookingRepository.save(taxiBooking);
        return savedTaxiBooking;
    }

//    @Override
//    public boolean deleteEmployee(Long id) {
//        EmployeeEntity employee = employeeRepository.findById(id).get();
//        employeeRepository.delete(employee);
//        return true;
//    }


    @Override
    public boolean cancel(Long taxiBookingId){ //, TaxiBookingCanceledEventDTO canceledEventDTO) {
        TaxiBooking taxiBooking = taxiBookingRepository.findById((Long) taxiBookingId).get();
        taxiBookingRepository.delete(taxiBooking);
        return true;
    }

    @Override
    public TaxiBooking accept(String taxiBookingId, TaxiBookingAcceptedEventDTO acceptedEventDTO) {
        return null;
    }

    @Override
    public TaxiLocation getBookings(Double latitude, Double longitude, Double radius) {
        return null;
    }

    @Override
    public TaxiBooking updateBookingStatus(String taxiBookingId, TaxiBookingStatus taxiBookingStatus) {
        return null;
    }

//    @Override
//    public TaxiBooking updateBookingStatus(String taxiBookingId, TaxiBookingStatus taxiBookingStatus) {
//        return null;
//    }


}
