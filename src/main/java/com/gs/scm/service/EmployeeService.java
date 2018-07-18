package com.gs.scm.service;

import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.to.EmployeeTO;

@FunctionalInterface
public interface EmployeeService {
    public EmployeeTO getEmployee(String employeeid) throws ApplicationFailureException;
}
