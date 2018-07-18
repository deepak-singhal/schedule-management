package com.gs.scm.to;

import java.time.LocalDateTime;


public class LeaveTO {

    private Long id;

    private String employeeId;

    private LocalDateTime leaveStartDate;

    private LocalDateTime leaveEndDate;

    public LeaveTO() {}

    public LeaveTO(Long id, String employeeId, LocalDateTime leaveStartDate, LocalDateTime leaveEndDate) {
        this.id = id;
        this.employeeId = employeeId;
        this.leaveStartDate = leaveStartDate;
        this.leaveEndDate = leaveEndDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public LocalDateTime getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(LocalDateTime leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public LocalDateTime getLeaveEndDate() {
        return leaveEndDate;
    }

    public void setLeaveEndDate(LocalDateTime leaveEndDate) {
        this.leaveEndDate = leaveEndDate;
    }
}
