package com.hostfully.demo.model.domain;

import java.time.Instant;

public class OccupiedRange {
    private Instant startingDate;
    private Instant endingDate;

    public OccupiedRange(Instant startingDate, Instant endingDate) {
        this.startingDate = startingDate;
        this.endingDate = endingDate;
    }

    public Instant getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(Instant startingDate) {
        this.startingDate = startingDate;
    }

    public Instant getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(Instant endingDate) {
        this.endingDate = endingDate;
    }
}