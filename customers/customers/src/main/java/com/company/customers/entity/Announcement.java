package com.company.customers.entity;

import io.jmix.core.metamodel.annotation.JmixEntity;

import java.time.Instant;

@JmixEntity(name = "cst_Announcement")
public class Announcement {

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
