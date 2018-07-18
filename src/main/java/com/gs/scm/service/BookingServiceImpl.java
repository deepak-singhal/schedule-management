package com.gs.scm.service;

import com.gs.scm.data.service.EmployeeEntityService;
import com.gs.scm.data.service.LeaveEntityService;
import com.gs.scm.data.service.ReservationEntityService;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.to.EmployeeTO;
import com.gs.scm.to.LeaveTO;
import com.gs.scm.to.ReservationTO;
import com.gs.scm.validator.DateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Component("bookingService")
public class BookingServiceImpl implements BookingService {

    @Autowired
    EmployeeEntityService employeeEntityService;

    @Autowired
    ReservationEntityService reservationEntityService;

    @Autowired
    LeaveEntityService leaveEntityService;

    @Autowired
    DateValidator dateValidator;

    @MethodLog(level = LogLevel.INFO)
    @Transactional(propagation = Propagation.REQUIRED)
    public void bookMeeting(ReservationTO reservationTO) throws ApplicationFailureException {

        if (!(dateValidator.isDateBeforeOneMonth(reservationTO.getStarttime())
                && dateValidator.isDateBeforeOneMonth(reservationTO.getEndtime())))
            throw new ApplicationFailureException(ExceptionConstant.INVALID_DATE);

        boolean isDateInLeaveRange = false;
        List<LeaveTO> leaveTOs = leaveEntityService.getEmployeeLeaves(reservationTO.getEmployeeId());
        int currentMeetingPoints = 0;
        for (LeaveTO leaveTO : leaveTOs)
            if (dateValidator.isDateInLeaveRange(reservationTO.getStarttime(), leaveTO.getLeaveStartDate(), leaveTO.getLeaveEndDate())
                    && dateValidator.isDateInLeaveRange(reservationTO.getStarttime(), leaveTO.getLeaveStartDate(), leaveTO.getLeaveEndDate())
                    && dateValidator.isDateInLeaveRange(reservationTO.getEndtime(), leaveTO.getLeaveStartDate(), leaveTO.getLeaveEndDate())
                    && dateValidator.isDateInLeaveRange(reservationTO.getEndtime(), leaveTO.getLeaveStartDate(), leaveTO.getLeaveEndDate())) {
                isDateInLeaveRange = true;
                break;
            }


        if (isDateInLeaveRange == true)
            throw new ApplicationFailureException(ExceptionConstant.INVALID_DATE);

        currentMeetingPoints = getMeetingPoints(Timestamp.valueOf(reservationTO.getStarttime()), Timestamp.valueOf(reservationTO.getEndtime()));

        reservationEntityService.reserveMeeting(reservationTO);

        EmployeeTO employeeTO = new EmployeeTO();
        employeeTO.setEmployeeId(reservationTO.getEmployeeId());
        employeeTO.setPoints(currentMeetingPoints);
        employeeEntityService.saveEmployee(employeeTO);

    }

    @MethodLog(level = LogLevel.INFO, params = true, returnVal = true)
    private int getMeetingPoints(Timestamp startTime, Timestamp endTime) {
        //Fetch Meeting Duration in Minutes & For every 30 Minutes, assign 1 point
        Long meetingDuration = (endTime.getTime() - startTime.getTime()) / 60000;
        System.out.println(meetingDuration);

        int currentMeetingPoints = meetingDuration.intValue()/30;

        return currentMeetingPoints;
    }


}
