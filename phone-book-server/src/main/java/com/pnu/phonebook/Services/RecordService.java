package com.pnu.phonebook.Services;

import com.pnu.phonebook.Model.Record;
import com.pnu.phonebook.Repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;


    public Record saveOrUpdateRecord(Record record) {
        Record updatedRecord = recordRepository.findByFirstNameAndLastName(record.getFirstName(), record.getLastName());
        if(updatedRecord!= null) {
            updatedRecord.setAddress(record.getAddress());
            updatedRecord.setNumber(record.getNumber());
            return recordRepository.save(updatedRecord);
        }
        return recordRepository.save(record);

    }

    public Iterable<Record> findAllRecords() {
        return recordRepository.findAll();
    }

    public void deleteRecord(String id) {
        recordRepository.deleteById(Long.parseLong(id));
    }

    public Record getRecord(String id) {
        return recordRepository.findById(Long.parseLong(id)).get();
    }

    public Iterable<Record> findRecordsByName(String firstName) {
        return recordRepository.findAllByFirstName(firstName);
    }
}
