package com.lastma.data.models;

import java.util.Date;

public class Ticket {
    private ViolationType type;
    private int violationFee;
    private Date issuedDate;
    private int id;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ViolationType getType() {
        return type;
    }

    public void setType(ViolationType type) {
        this.type = type;
    }

    public int getViolationFee() {
        return violationFee;
    }

    public void setViolationFee(int violationFee) {
        this.violationFee = violationFee;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
}







