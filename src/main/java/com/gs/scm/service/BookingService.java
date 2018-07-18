package com.gs.scm.service;


import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.to.ReservationTO;

@FunctionalInterface
public interface BookingService {

    public void bookMeeting(ReservationTO reservationTO) throws ApplicationFailureException;

}
