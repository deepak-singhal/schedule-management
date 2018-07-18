package com.gs.scm.validator;

import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component("dateValidator")
public class DateValidator {

    @MethodLog(level = LogLevel.INFO, params = true, returnVal = true)
    public boolean isDateBeforeOneMonth(LocalDateTime date){
        return date.isBefore(LocalDateTime.now().plusDays(30));
    }

    @MethodLog(level = LogLevel.INFO, params = true, returnVal = true)
    public boolean isDateInLeaveRange(LocalDateTime date, LocalDateTime leaveStartDate, LocalDateTime leaveEndDate) throws ApplicationFailureException {
        try{
            return date.isAfter(leaveStartDate) && date.isBefore(leaveEndDate);
        }catch (Exception e){
            throw new ApplicationFailureException(ExceptionConstant.INVALID_DATE_FORMAT);
        }
    }
}
