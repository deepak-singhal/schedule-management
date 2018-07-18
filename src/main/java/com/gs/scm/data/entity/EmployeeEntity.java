package com.gs.scm.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.TimeZone;

@Table(name = "EMPLOYEE")
@Entity(name = "EMPLOYEE")
public class EmployeeEntity implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "employeeid")
    private String employeeid;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "timezone")
    private TimeZone timezone;

    @Column(name = "role")
    private String role;

    @Column(name = "employmentstatus")
    private String employmentstatus;

    @Column(name = "points")
    private int points;

    @OneToMany
    @JoinColumn(name = "employeeid")
    private List<ReservationEntity> reservations;

    @OneToMany
    @JoinColumn(name = "employeeid")
    private List<LeaveEntity> leaves;

    public EmployeeEntity() {
    }

    public EmployeeEntity(String employeeid, String firstname, String lastname, TimeZone timezone, String role, String employmentstatus, int points) {
        this.employeeid = employeeid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.timezone = timezone;
        this.role = role;
        this.employmentstatus = employmentstatus;
        this.points = points;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeId) {
        this.employeeid = employeeId;
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

    public TimeZone getTimezone() {
        return timezone;
    }

    public void setTimezone(TimeZone timeZone) {
        this.timezone = timeZone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmploymentstatus() {
        return employmentstatus;
    }

    public void setEmploymentstatus(String employmentstatus) {
        this.employmentstatus = employmentstatus;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public List<ReservationEntity> getReservations() {
        return reservations;
    }

    public void setReservations(List<ReservationEntity> reservations) {
        this.reservations = reservations;
    }

    public List<LeaveEntity> getLeaves() {
        return leaves;
    }

    public void setLeaves(List<LeaveEntity> leaves) {
        this.leaves = leaves;
    }
}
