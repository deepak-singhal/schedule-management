package com.gs.scm.service;

import com.gs.scm.data.service.EmployeeEntityService;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.to.EmployeeTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeEntityService employeeEntityService;

    @MethodLog(level = LogLevel.INFO)
    public EmployeeTO getEmployee(String employeeid) throws ApplicationFailureException {
        try {
            return employeeEntityService.getEmployee(employeeid);
        }catch (Exception e){
            throw new ApplicationFailureException(ExceptionConstant.SQL_EXCEPTION);
        }
    }
}
