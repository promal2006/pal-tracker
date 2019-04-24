package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {
    private class SequenceIdGenerator {
        private AtomicLong currentValue = new AtomicLong(0L);
        public long getNextValue() {
            return currentValue.incrementAndGet();
        }
    }

    private SequenceIdGenerator idGenerator = new SequenceIdGenerator();
    private Map<Long, TimeEntry> inMemoryRepository = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        timeEntry.setId(idGenerator.getNextValue());
        this.inMemoryRepository.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return this.inMemoryRepository.get(id);
    }


    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        this.inMemoryRepository.replace(id, timeEntry);
        return this.inMemoryRepository.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(this.inMemoryRepository.values());
    }

    @Override
    public void delete(long id) {
        this.inMemoryRepository.remove(id);
    }
}
