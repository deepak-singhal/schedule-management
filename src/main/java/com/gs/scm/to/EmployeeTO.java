package com.gs.scm.to;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.TimeZone;

public class EmployeeTO {

    @NotBlank
    private String employeeId;

    private String firstname;

    private String lastname;

    private TimeZone timeZone;

    private String role;

    private String employmentStatus;

    private int points;

    private List<ReservationTO> reservations;

    private List<LeaveTO> leaves;


    public EmployeeTO() {
    }

    public EmployeeTO(String employeeId,
                      String firstname,
                      String lastname,
                      TimeZone timeZone,
                      String role,
                      String employmentStatus,
                      int points,
                      List<ReservationTO> reservations,
                      List<LeaveTO> leaves) {
        this.employeeId = employeeId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.timeZone = timeZone;
        this.role = role;
        this.employmentStatus = employmentStatus;
        this.points = points;
        this.reservations = reservations;
        this.leaves = leaves;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmploymentStatus() {
        return employmentStatus;
    }

    public void setEmploymentStatus(String employmentStatus) {
        this.employmentStatus = employmentStatus;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<ReservationTO> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationTO> reservations) {
        this.reservations = reservations;
    }

    public List<LeaveTO> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<LeaveTO> leaves) {
        this.leaves = leaves;
    }
}
