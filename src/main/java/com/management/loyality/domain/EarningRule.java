package com.management.loyality.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class EarningRule {


    public EarningRule(){}
    public EarningRule(String idLoyalityType, LocalDate startDate, LocalDate endDate, int earnedPoint, String targetChar){
        this.setIdloyaltytype(idLoyalityType);
        this.setStartdate(startDate);
        this.setEnddate(endDate);
        this.setEarnedpoint(earnedPoint);
        this.setCurrentdate(LocalDate.now());
        this.setActive(1);
        this.setTargetchar(targetChar);
    }
    @Id
    @GenericGenerator(name = "id",strategy = "com.management.loyality.domain.IdGenerator",parameters = @org.hibernate.annotations.Parameter(name = "predicat", value = "RUL"))
    @GeneratedValue(generator = "id")
    @Column
    String idearningrule;

    @Column
    String idloyaltytype;
    @Column
    LocalDate startdate;
    @Column
    LocalDate enddate;
    @Column
    int earnedpoint;
    @Column
    LocalDate currentdate;
    @Column
    int active;
    @Column
    String targetchar;

    public String getIdearningrule() {
        return idearningrule;
    }

    public void setIdearningrule(String idearningrule) {
        this.idearningrule = idearningrule;
    }

    public String getIdloyaltytype() {
        return idloyaltytype;
    }

    public void setIdloyaltytype(String idloyaltytype) {
        this.idloyaltytype = idloyaltytype;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getEarnedpoint() {
        return earnedpoint;
    }

    public void setEarnedpoint(int earnedpoint) {
        this.earnedpoint = earnedpoint;
    }

    public LocalDate getCurrentdate() {
        return currentdate;
    }

    public void setCurrentdate(LocalDate currentdate) {
        this.currentdate = currentdate;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getTargetchar() {
        return targetchar;
    }

    public void setTargetchar(String targetchar) {
        this.targetchar = targetchar;
    }
}
