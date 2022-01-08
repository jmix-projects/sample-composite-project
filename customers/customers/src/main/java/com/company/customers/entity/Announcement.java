package com.company.customers.entity;

import com.company.users.entity.InstantDatatype;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.PropertyDatatype;

import java.time.Instant;

@JmixEntity(name = "cst_Announcement")
public class Announcement {

    @PropertyDatatype(InstantDatatype.ID)
    private Instant time;

    private String message;

    public Instant getTime() {
        return time;
    }

    public void setTime(final Instant someTime) {
        time = someTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
