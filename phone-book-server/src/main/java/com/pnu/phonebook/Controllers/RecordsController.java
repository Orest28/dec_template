package com.pnu.phonebook.Controllers;


import com.pnu.phonebook.Model.Record;
import com.pnu.phonebook.Services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// юзати перші два запити @Get, @Post, id забрати, бо там для фільтрів решта запитів


@RestController
@RequestMapping("/api/")
@CrossOrigin("*")
public class RecordsController {

    @Autowired
    private RecordService recordService;

    public static String id;

    @GetMapping(value = "records")
    public Iterable<Record> getAllRecords() {
        return recordService.findAllRecords();
    }

    @PostMapping(value = "create")
    public Record saveRecord(@RequestBody Record record) {
        return recordService.saveOrUpdateRecord(record);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteRecord(@PathVariable String id) {
        recordService.deleteRecord(id);
    }

    @PostMapping(value = "read/{id}")
    public void readData(@PathVariable String id) {
        RecordsController.id = id;
        System.out.println(id);
    }

    @GetMapping(value = "/showRecord")
    public Record getRecord() {
        return recordService.getRecord(id);
    }

    @GetMapping(value = "filter/{firstName}")
    public Iterable<Record> getRecordsByName(@PathVariable String firstName) {
        return recordService.findRecordsByName(firstName);
    }
}