package io.pivotal.pal.tracker;

import io.pivotal.pal.tracker.TimeEntry;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;

public   class InMemoryTimeEntryRepository implements TimeEntryRepository {

    public InMemoryTimeEntryRepository()
    {
    }

    protected final HashMap<Long, TimeEntry> table = new HashMap<>();
    private Long currentId = 1L;
    public TimeEntry create(TimeEntry timeEntry)  {

       // timeEntry.setId(getNextId());
       // timeEntry.setId()+1L;
        long id=currentId++;
        timeEntry.setId(id);
        table.put(id, timeEntry);
        //System.out.println(table.get(timeEntry.getId()+1L) + " ----------------");
        return table.get(timeEntry.getId());
    }


    public TimeEntry find(long id)  {
        return table.get(id);
    }


    public List<TimeEntry> list()  {
        return new ArrayList<>(table.values());
    }

    public TimeEntry update(long id, TimeEntry timeEntry) {



        TimeEntry updateEntry = new TimeEntry(id,timeEntry.getProjectId(),timeEntry.getUserId(),timeEntry.getDate(),timeEntry.getHours());
        if(table.get(id) != null){
            timeEntry.setId(id);
            table.replace(id,updateEntry);
            return timeEntry;
        }else{
            return null;
        }
    }


    public void delete(long id)  {

        table.remove(id);
    }


}

