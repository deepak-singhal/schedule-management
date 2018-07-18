package com.gs.scm.data.service;

import com.gs.scm.data.entity.ReservationEntity;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.repository.ReservationRepository;
import com.gs.scm.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component("reservationEntityService")
public class ReservationEntityService {

    @Autowired
    ReservationRepository reservationRepository;


    @MethodLog(level = LogLevel.INFO)
    public void reserveMeeting(ReservationTO reservationTO) throws ApplicationFailureException {
        ReservationEntity reservationEntity = new ReservationEntity(reservationTO.getId(),
                                                                    reservationTO.getEmployeeId(),
                                                                    Timestamp.valueOf(reservationTO.getStarttime()),
                                                                    Timestamp.valueOf(reservationTO.getEndtime()));

        try {
            reservationRepository.save(reservationEntity);
        }catch (Exception e){
            throw new ApplicationFailureException(ExceptionConstant.SQL_EXCEPTION);
        }
    }
}
