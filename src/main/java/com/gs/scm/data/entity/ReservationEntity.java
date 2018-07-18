package com.gs.scm.data.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Table(name = "RESERVATION")
@Entity(name = "RESERVATION")
public class ReservationEntity implements Serializable {

    private static final long serialVersionUID = 4L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "employeeid")
    String employeeid;

    @Column(name = "starttime")
    Timestamp starttime;

    @Column(name = "endtime")
    Timestamp endtime;

    public ReservationEntity() {
    }

    public ReservationEntity(Long id, String employeeid, Timestamp starttime, Timestamp endtime) {
        this.id = id;
        this.employeeid = employeeid;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getStarttime() {
        return starttime;
    }

    public void setStarttime(Timestamp starttime) {
        this.starttime = starttime;
    }

    public Timestamp getEndtime() {
        return endtime;
    }

    public void setEndtime(Timestamp endtime) {
        this.endtime = endtime;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
}