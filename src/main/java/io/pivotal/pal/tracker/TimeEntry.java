package io.pivotal.pal.tracker;

import java.time.LocalDate;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

public class TimeEntry {

    private long timeEntryId;
    private long projectId;
    private long userId;
    private LocalDate date;
    private long hours;

    public TimeEntry(long projectId, long userId, LocalDate date, long hours) {
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long timeEntryId, long projectId, long userId, LocalDate date, long hours) {
        this.timeEntryId = timeEntryId;
        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                date.equals(timeEntry.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(timeEntryId, projectId, userId, date, hours);
    }

}
