package com.gs.scm.data.service;

import com.gs.scm.data.entity.EmployeeEntity;
import com.gs.scm.data.entity.LeaveEntity;
import com.gs.scm.data.entity.ReservationEntity;
import com.gs.scm.exception.ApplicationFailureException;
import com.gs.scm.exception.ExceptionConstant;
import com.gs.scm.logging.LogLevel;
import com.gs.scm.logging.MethodLog;
import com.gs.scm.repository.EmployeeRepository;
import com.gs.scm.to.EmployeeTO;
import com.gs.scm.to.LeaveTO;
import com.gs.scm.to.ReservationTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component("employeeEntityService")
public class EmployeeEntityService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @MethodLog(level = LogLevel.INFO)
    public void saveEmployee(EmployeeTO employeeTO) throws ApplicationFailureException {
        try {
            EmployeeEntity employeeEntity = employeeRepository.findById(employeeTO.getEmployeeId()).get();
            employeeEntity.setPoints(employeeEntity.getPoints() + employeeTO.getPoints());
            employeeRepository.save(employeeEntity);
        }catch (Exception e){
            throw new ApplicationFailureException(ExceptionConstant.SQL_EXCEPTION);
        }
    }

    @MethodLog(level = LogLevel.INFO)
    public EmployeeTO getEmployee(String employeeid) throws ApplicationFailureException {
        Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(employeeid);
        if(!optionalEmployeeEntity.isPresent())
            throw new ApplicationFailureException(ExceptionConstant.EMPLOYEE_NOT_FOUND_IN_DB);

        EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
        return new EmployeeTO(employeeEntity.getEmployeeid(),
                employeeEntity.getFirstname(),
                employeeEntity.getLastname(),
                employeeEntity.getTimezone(),
                employeeEntity.getRole(),
                employeeEntity.getEmploymentstatus(),
                employeeEntity.getPoints(),
                reservationEntityToTOConverter(employeeEntity.getReservations()),
                leaveEntityToTOConverter(employeeEntity.getLeaves()));
    }

    @MethodLog(level = LogLevel.INFO)
    private List<ReservationTO> reservationEntityToTOConverter(List<ReservationEntity> reservations) {
        List<ReservationTO> reservationTOs = new ArrayList<>();
        for (ReservationEntity reservation : reservations) {
            ReservationTO reservationTO = new ReservationTO(reservation.getId(),
                    reservation.getEmployeeid(),
                    reservation.getStarttime().toLocalDateTime(),
                    reservation.getEndtime().toLocalDateTime());
            reservationTOs.add(reservationTO);
        }

        return reservationTOs;
    }

    @MethodLog(level = LogLevel.INFO)
    private List<LeaveTO> leaveEntityToTOConverter(List<LeaveEntity> leaves) {
        List<LeaveTO> leaveTOs = new ArrayList<>();
        for (LeaveEntity leave : leaves) {
            LeaveTO leaveTO = new LeaveTO(leave.getId(),
                    leave.getEmployeeid(),
                    leave.getLeavestartdate(),
                    leave.getLeaveenddate());

            leaveTOs.add(leaveTO);
        }

        return leaveTOs;
    }
}
