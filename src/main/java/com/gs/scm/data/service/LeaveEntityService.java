package com.gs.scm.data.service;

import com.gs.scm.data.entity.LeaveEntity;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.repository.LeaveRepository;
import com.gs.scm.to.LeaveTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("leaveEntityService")
public class LeaveEntityService {

    @Autowired
    LeaveRepository leaveRepository;


    @MethodLog(level = LogLevel.INFO)
    public List<LeaveTO> getEmployeeLeaves(String employeeId) throws ApplicationFailureException {
        try {
            return convertLeaveEntityToTO(leaveRepository.findByEmployeeid(employeeId));
        }catch (Exception e){
            throw new ApplicationFailureException(ExceptionConstant.SQL_EXCEPTION);
        }
    }

    @MethodLog(level = LogLevel.INFO)
    private List<LeaveTO> convertLeaveEntityToTO(List<LeaveEntity> leaves) {
        ArrayList leaveTOs = new ArrayList();
        for(LeaveEntity leave : leaves){
            leaveTOs.add(leave);
        }

        return leaveTOs;
    }
}
