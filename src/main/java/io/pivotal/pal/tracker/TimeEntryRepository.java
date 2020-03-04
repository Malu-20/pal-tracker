package io.pivotal.pal.tracker;
import io.pivotal.pal.tracker.TimeEntry;
import java.util.Collection;
import java.util.List;

public interface TimeEntryRepository {

 TimeEntry create(TimeEntry timeEntry);
 TimeEntry find(Long id);
 List<TimeEntry> list();
 TimeEntry update(Long id, TimeEntry timeEntry);
 void delete(Long id);


}