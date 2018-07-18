package com.gs.scm.to;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ReservationTO {

    private Long id;

    private String employeeId;

    @NotNull(message = "starttime can not be blank")
    @FutureOrPresent(message = "Booking StartDateTime should be of today or of future")
    private LocalDateTime starttime;

    @NotNull(message = "endtime can not be blank")
    @FutureOrPresent(message = "Booking EndDateTime should be of today or of future")
    private LocalDateTime endtime;


    public ReservationTO() {
    }

    public ReservationTO(Long id, String employeeId, LocalDateTime starttime, LocalDateTime endtime) {
        this.id = id;
        this.employeeId = employeeId;
        this.starttime = starttime;
        this.endtime = endtime;
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

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public LocalDateTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalDateTime endtime) {
        this.endtime = endtime;
    }
}
