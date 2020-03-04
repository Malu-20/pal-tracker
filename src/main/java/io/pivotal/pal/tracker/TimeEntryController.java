package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import io.pivotal.pal.tracker.TimeEntry;
import java.util.List;
import java.util.Collection;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/time-entries")
public class TimeEntryController {

    @Autowired
    private TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }



    @PostMapping
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntry) {
        //System.out.println(this.getClass().getSimpleName() + " - Create new employee method is invoked.");
       // return timeEntryRepository.create(timeEntry);
        TimeEntry createdTimeEntry = timeEntryRepository.create(timeEntry);

        // Returning a ResponseEntity allows us to control the resulting HTTP status code
        return new ResponseEntity<>(createdTimeEntry, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable long id)  {
        //System.out.println(this.getClass().getSimpleName() + " - Get employee details by id is invoked.");

        TimeEntry timeEntry = timeEntryRepository.find(id);
        if (timeEntry != null) {
            return new ResponseEntity<>(timeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeEntry>> list() {
        //System.out.println(this.getClass().getSimpleName() + " - Get all employees service is invoked.");
        return new ResponseEntity<>(timeEntryRepository.list(), HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<TimeEntry>  update( @PathVariable long id, @RequestBody TimeEntry updTimeEntry)  {
        //System.out.println(this.getClass().getSimpleName() + " - Update employee details by id is invoked.");

        TimeEntry updatedTimeEntry = timeEntryRepository.update(id, updTimeEntry);
        if (updatedTimeEntry != null) {
            return new ResponseEntity<>(updatedTimeEntry, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable long id)  {
        //System.out.println(this.getClass().getSimpleName() + " - Delete employee by id is invoked.");



        timeEntryRepository.delete(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}