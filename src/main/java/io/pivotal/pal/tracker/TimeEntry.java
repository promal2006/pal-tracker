package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class TimeEntry {

    private long timeEntryId;
    private long projectId;
    private long userId;
    private LocalDate parse;
    private long hours;

    public TimeEntry(long projectId, long userId, LocalDate parse, long hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.hours = hours;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate parse, long hours) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.parse = parse;
        this.hours = hours;
    }

    public TimeEntry() {

    }

    public long getHours() {
        return this.hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getParse() {
        return parse;
    }

    public void setParse(LocalDate parse) {
        this.parse = parse;
    }

    public long getId() {
        return this.timeEntryId;
    }

    public void setId(long timeEntryId) {
        this.timeEntryId = timeEntryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEntry timeEntry = (TimeEntry) o;
        return timeEntryId == timeEntry.timeEntryId &&
                projectId == timeEntry.projectId &&
                userId == timeEntry.userId &&
                hours == timeEntry.hours &&
                parse.equals(timeEntry.parse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, projectId, userId, parse, hours);
    }
}
