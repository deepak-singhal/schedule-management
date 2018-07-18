package com.gs.scm.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "LEAVES")
@Entity(name = "LEAVES")
public class LeaveEntity implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "employeeid")
    private String employeeid;

    @Column(name = "leavestartdate")
    private LocalDateTime leavestartdate;

    @Column(name = "leaveenddate")
    private LocalDateTime leaveenddate;


    public LeaveEntity() {}

    public LeaveEntity(Long id, String employeeid, LocalDateTime leavestartdate, LocalDateTime leaveenddate) {
        this.id = id;
        this.employeeid = employeeid;
        this.leavestartdate = leavestartdate;
        this.leaveenddate = leaveenddate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public LocalDateTime getLeavestartdate() {
        return leavestartdate;
    }

    public void setLeavestartdate(LocalDateTime leavestartdate) {
        this.leavestartdate = leavestartdate;
    }

    public LocalDateTime getLeaveenddate() {
        return leaveenddate;
    }

    public void setLeaveenddate(LocalDateTime leaveenddate) {
        this.leaveenddate = leaveenddate;
    }

}
