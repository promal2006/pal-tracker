package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import io.pivotal.pal.tracker.TimeEntryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TimeEntryController {
    private final TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {

        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity create(TimeEntry timeEntryToCreate) {
        TimeEntry entryCreated = this.timeEntryRepository.create(timeEntryToCreate);
        return new ResponseEntity<>(entryCreated, HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> read(@PathVariable long timeEntryId) {
        TimeEntry entryFound = this.timeEntryRepository.find(timeEntryId);
        if (entryFound != null) {
            return new ResponseEntity<>(entryFound, HttpStatus.OK);
        }
        return new ResponseEntity<>(entryFound, HttpStatus.NOT_FOUND);
    }

    @RequestMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {
        List<TimeEntry> entryList = this.timeEntryRepository.list();
        return new ResponseEntity<>(entryList, HttpStatus.OK);
    }

    @PutMapping("/time-entries/{timeEntryId}")
    public ResponseEntity update(@PathVariable long timeEntryId, TimeEntry expected) {
        TimeEntry entryUpdated = this.timeEntryRepository.update(timeEntryId, expected);
        if (entryUpdated != null) {
            return new ResponseEntity(entryUpdated, HttpStatus.OK);
        }
        return new ResponseEntity(entryUpdated, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/time-entries/{timeEntryId}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long timeEntryId) {
        this.timeEntryRepository.delete(timeEntryId);
        return ResponseEntity.noContent().build();
    }
}
