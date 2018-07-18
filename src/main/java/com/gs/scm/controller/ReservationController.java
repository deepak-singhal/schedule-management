package com.gs.scm.controller;

import com.gs.scm.exception.ApplicationBindingException;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.exception.ExceptionResponseObject;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.service.BookingService;
import com.gs.scm.service.EmployeeService;
import com.gs.scm.to.EmployeeTO;
import com.gs.scm.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    BookingService bookingService;

    @MethodLog(message = "Fetching Employee Details", level = LogLevel.INFO, params = true)
    @GetMapping("/employee/{employeeid}/calender")
    public EmployeeTO getEmployeeCalender(@PathVariable String employeeid) throws ApplicationFailureException {
        return employeeService.getEmployee(employeeid);
    }

    @MethodLog(message = "Scheduling Meeting", level = LogLevel.INFO, params = true)
    @PostMapping("/meeting")
    public void reserveEmployeeCalenderMeeting(@Valid @RequestBody ReservationTO reservationTO,
                                               BindingResult result) throws ApplicationFailureException, ApplicationBindingException {
        if (result.hasErrors())
            throw new ApplicationBindingException(result.getFieldErrors());

        bookingService.bookMeeting(reservationTO);
    }

    @ExceptionHandler(ApplicationFailureException.class)
    public ExceptionResponseObject applicationFailueExceptionHandler(ApplicationFailureException e) {
        ExceptionResponseObject responseObject = new ExceptionResponseObject();
        responseObject.setMessage(e.getExceptionConstant().getMessage())
                .setErrorCode(e.getExceptionConstant().getErrorCode())
                .setTimestamp(new Timestamp(System.currentTimeMillis()));
        return responseObject;
    }


    @ExceptionHandler(ApplicationBindingException.class)
    public List<ExceptionResponseObject> applicationFieldExceptionsHandler(ApplicationBindingException applicationBindingExceptions) {
        List<ExceptionResponseObject> exceptionResponseObjects = new ArrayList<>();
        for (FieldError error : applicationBindingExceptions.getFieldErrors()) {
            ExceptionResponseObject exceptionResponseObject = new ExceptionResponseObject();
            exceptionResponseObject.setTimestamp(new Timestamp(System.currentTimeMillis()));
            exceptionResponseObject.setErrorCode(ExceptionConstant.INVALID_FIELD.getErrorCode());
            exceptionResponseObject.setMessage(ExceptionConstant.INVALID_FIELD.getMessage()
                    + " : [" + error.getObjectName()
                    + "." + error.getField()
                    + "] : " + error.getDefaultMessage());

            exceptionResponseObjects.add(exceptionResponseObject);
        }

        return exceptionResponseObjects;
    }

}
